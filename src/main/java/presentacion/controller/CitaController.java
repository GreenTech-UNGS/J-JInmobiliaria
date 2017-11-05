package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.joda.time.Period;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import entities.Localidad;
import entities.PersonaBasica;
import entities.Propiedad;
import entities.Provincia;
import entities.TipoCita;
import model.CitaService;
import model.LocalidadService;
import model.LocalizationService;
import model.LogicaNegocioException;
import model.UsuarioService;
import persistencia.dao.iface.LocalizationDao.MapPoint;
import presentacion.mappers.CitaFormMapper;
import presentacion.table.PersonaBasicaTableModel;
import presentacion.validators.CitaFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.CitaForm;

@Singleton
public class CitaController {

	private CitaForm view;
	@Inject private LocalidadService localidadService;
	@Inject private CitaService citaService;
	@Inject private UsuarioService usuarioService;
	@Inject private LocalizationService localizationService;
	
	@Inject private CitaFormMapper mapper;
	@Inject private CitaFormValidator validator;
	
	@Inject private ElegirAsistenteController elegirAsistente;
	@Inject private ElegirPropiedadController elegirPropiedad;
	
	@Inject private MessageShow msgShw;
	
	private PersonaBasicaTableModel tableModel;
	
	private Cita currentCita;
	
	private final Coordinate centerOfMap = new Coordinate(50.064191736659104, 8.96484375);
	
	@Inject
	private CitaController(CitaForm view) {
		
		this.view = view;
		this.view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		this.view.getBtnAceptar().addActionListener(e -> agregarCita());
		this.view.getBtnAgregar().addActionListener(e -> agregarAsistente());
		this.view.getBtnBorrar().addActionListener(e -> borrarAsistente());
		this.view.getChckbxAsistir().addActionListener(e -> actualizaAsistenteAlUsuario(((AbstractButton)e.getSource()).isSelected()));
		this.view.getBtnDesdePropiedad().addActionListener(e -> desdePropiedad());
		this.view.getBtnActualizar().addActionListener(e -> actualizaMapa());
		
		this.tableModel = new PersonaBasicaTableModel();
		
		view.getTableAsistentes().setModel(tableModel);
		view.getTableAsistentes().setColumnModel(tableModel.getTableColumnModel());
		view.getTableAsistentes().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		view.getTableAsistentes().getTableHeader().setReorderingAllowed(false);
		
	}


	private void actualizaAsistenteAlUsuario(boolean selected) {
		
		if(selected) {
			tableModel.addRow(usuarioService.getUsuarioLogeado().getPersona());
			currentCita.getAsistentes().add(usuarioService.getUsuarioLogeado().getPersona());
		}
		else {
			tableModel.removeRow(usuarioService.getUsuarioLogeado().getPersona());
			currentCita.getAsistentes().add(usuarioService.getUsuarioLogeado().getPersona());
		
		}
		
	}	
	
	private void borrarAsistente() {
		
		int selectedIndex = view.getTableAsistentes().getSelectedRow();
		PersonaBasica selected = tableModel.getRow(selectedIndex);
		
		if(selected.equals(usuarioService.getUsuarioLogeado().getPersona()))
			view.getChckbxAsistir().setSelected(false);
		
		if(selectedIndex >= 0) {
			tableModel.removeRow(selectedIndex);
			currentCita.getAsistentes().remove(selectedIndex);
		}
		
	}
	
	private void agregarCita() {
		
		if(validator.isValid()) {
			mapper.fillBean(currentCita);
		
			actualizaMapaThread();
			
			int avisoCorto = (int)view.getSpinnerAvisoCorto().getValue();
			int avisoLargo = (int)view.getSpinnerAvisoLargo().getValue();
			citaService.crearNotificaciones(currentCita, avisoCorto, avisoLargo);
			
			citaService.saveCita(currentCita);
			this.view.setVisible(false);
		}
		else {
			msgShw.showErrorMessage(validator.getErrorMessage(), "Error");
		}
		
		
	}
		
	private void agregarAsistente() {
		elegirAsistente.showView();
		PersonaBasica asistente = elegirAsistente.getAsistente();
		
		if(asistente.equals(usuarioService.getUsuarioLogeado().getPersona()))
			view.getChckbxAsistir().setSelected(true);
		
		if(!currentCita.getAsistentes().contains(asistente)) {
			tableModel.addRow(asistente);
			currentCita.getAsistentes().add(asistente);
		}
		
		
	}
	
	private void desdePropiedad() {
		elegirPropiedad.showViewProp();
		
		Propiedad p = elegirPropiedad.getPropiedad();
		
		if(p != null) {
			view.getTfCalle().setText(p.getCalle());
			view.getTfAltura().setText(p.getAltura());
			view.getComboModelLocalidad().setSelected(p.getLocalidad());
			view.getComboModelProvincia().setSelected(p.getLocalidad().getProvincia());
			
			actualizaMapa();
		}
		
	}
	
	private void actualizaMapa() {

		Thread t = new Thread(() -> actualizaMapaThread());
		t.start();
	}
	
	private void actualizaMapaThread() {

		String calle = view.getTfCalle().getText();
		String altura = view.getTfAltura().getText();
		Localidad localidad = view.getComboModelLocalidad().getSelected();

		System.out.println(localidad);
		
		MapPoint punto = null;
		try {
			punto = localizationService.getLocalizationOf(calle, altura, localidad);
			Coordinate localizacion = new Coordinate(punto.getLat(), punto.getLon());
			restartMapa();
			
			view.getMapa().addMapMarker(new MapMarkerDot(localizacion));
			view.getMapa().setDisplayPosition(localizacion, 15);
			
			currentCita.setLat(punto.getLat());
			currentCita.setLng(punto.getLon());
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error");
		}	
		
	}
	
	private void restartMapa() {
		
		view.getMapa().removeAllMapMarkers();
		view.getMapa().setDisplayPosition(centerOfMap, 3);
	}


	public void showView() {

		this.view.setVisible(true);

	}
	
	public void setModeNew() {

		view.setTitle("Crear Cita");
		
		currentCita = citaService.getNuevaCita();
		fillCombos();
		fillTables();
		mapper.fillFields(currentCita);
		restartMapa();
	}	
	
	public void setModeEdit(Cita cita) {
		
		view.setTitle("Editar Cita");
		
		currentCita = cita;
		fillCombos();
		fillTables();
		
		mapper.fillFields(currentCita);
		restartMapa();
		actualizaMapa();
		
	}
	
	private void fillCombos() {
		
		view.getComboModelTipoCita().clearAndActualize(Arrays.asList(TipoCita.values()));
		
		view.getComboModelProvincia().clearAndActualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		AutoCompleteDecorator.decorate(view.getComboLocalidad());
		cambiaLocalidades();
		
	}
	
	private void fillTables() {
		
		tableModel.clean();
		
		currentCita.getAsistentes().forEach(a -> tableModel.addRow(a));
		
	}

	private void cambiaLocalidades() {
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
		
	}



	

}
