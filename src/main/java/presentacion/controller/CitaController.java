package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import entities.Localidad;
import entities.Moneda;
import entities.PersonaBasica;
import entities.Provincia;
import entities.TipoCita;
import entities.TipoOfrecimiento;
import model.CitaService;
import model.LocalidadService;
import model.UsuarioService;
import presentacion.mappers.CitaFormMapper;
import presentacion.table.PersonaBasicaTableModel;
import presentacion.vista.CitaForm;

@Singleton
public class CitaController {

	private CitaForm view;
	@Inject private LocalidadService localidadService;
	@Inject private CitaService citaService;
	@Inject private UsuarioService usuarioService;
	@Inject private CitaFormMapper mapper;
	
	@Inject private ElegirAsistenteController elegirAsistente;
	
	private PersonaBasicaTableModel tableModel;
	
	private Cita currentCita;
	
	@Inject
	private CitaController(CitaForm view) {
		
		this.view = view;
		this.view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		this.view.getBtnAceptar().addActionListener(e -> agregarCita());
		this.view.getBtnAgregar().addActionListener(e -> agregarAsistente());
		this.view.getChckbxAsistir().addActionListener(e -> actualizaAsistenteAlUsuario(((AbstractButton)e.getSource()).isSelected()));
	
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


	public void showView() {
	
		fillCombos();
		fillTables();
		
		this.view.setVisible(true);

	}
	
	public void setModeNew() {

		currentCita = citaService.getNuevaCita();
	}
	
	private void fillCombos() {
		
		view.getComboModelTipoCita().clearAndActualize(Arrays.asList(TipoCita.values()));
		
		view.getComboModelProvincia().clearAndActualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		AutoCompleteDecorator.decorate(view.getComboLocalidad());
		cambiaLocalidades();
		
	}
	
	private void fillTables() {
		
	}

	private void cambiaLocalidades() {
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
		
	}
	
	private void agregarCita() {
		
		//TODO: falta validator
		mapper.fillBean(currentCita);
		
		citaService.saveCita(currentCita);
		
	}
		
	private void agregarAsistente() {
		elegirAsistente.showView();
		PersonaBasica asistente = elegirAsistente.getAsistente();
		
		if(!currentCita.getAsistentes().contains(asistente)) {
			tableModel.addRow(asistente);
			currentCita.getAsistentes().add(asistente);
		}
		
		
	}
}
