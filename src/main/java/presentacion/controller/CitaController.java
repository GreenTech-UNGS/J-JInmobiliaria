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
import entities.UnidadTiempo;
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
	
	@Inject private ElegirPropiedadController elegirPropiedad;
	
	@Inject private MessageShow msgShw;
	
	private Cita currentCita;
	
	private final Coordinate centerOfMap = new Coordinate(50.064191736659104, 8.96484375);
	
	@Inject
	private CitaController(CitaForm view) {
		
		this.view = view;
		this.view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		this.view.getBtnAceptar().addActionListener(e -> agregarCita());
		this.view.getBtnDesdePropiedad().addActionListener(e -> desdePropiedad());
		this.view.getBtnActualizar().addActionListener(e -> actualizaMapa());
		
		
		
	}

	private void agregarCita() {
		
		if(validator.isValid()) {
			mapper.fillBean(currentCita);
			if(view.getChckbxAsistir().isSelected())
				currentCita.setAsistente(usuarioService.getUsuarioLogeado());
			actualizaMapaThread();
			
			int avisoCorto = (int)view.getSpinnerAvisoCorto().getValue();
			int avisoLargo = (int)view.getSpinnerAvisoLargo().getValue();
			UnidadTiempo avisoCortoUnidad = view.getUnidadCorta().getSelected();
			UnidadTiempo avisoLargoUnidad = view.getUnidadLarga().getSelected();
			citaService.crearNotificaciones(currentCita, avisoCorto, avisoCortoUnidad, avisoLargo, avisoLargoUnidad);
			
			citaService.saveCita(currentCita);
			this.view.setVisible(false);
		}
		else {
			msgShw.showErrorMessage(validator.getErrorMessage(), "Error");
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
		mapper.fillFields(currentCita);
		restartMapa();
	}	
	
	public void setModeEdit(Cita cita) {
		
		view.setTitle("Editar Cita");
		
		currentCita = cita;
		fillCombos();
		
		mapper.fillFields(currentCita);
		restartMapa();
		actualizaMapa();
		
	}
	
	private void fillCombos() {
		
		view.getComboModelTipoCita().clearAndActualize(Arrays.asList(TipoCita.values()));
		view.getUnidadCorta().clearAndActualize(Arrays.asList(UnidadTiempo.values()));
		view.getUnidadLarga().clearAndActualize(Arrays.asList(UnidadTiempo.values()));
		
		view.getComboModelProvincia().clearAndActualize(localidadService.getProvincias());
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		AutoCompleteDecorator.decorate(view.getComboLocalidad());
		cambiaLocalidades();
		
	}

	private void cambiaLocalidades() {
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
		
	}



	

}
