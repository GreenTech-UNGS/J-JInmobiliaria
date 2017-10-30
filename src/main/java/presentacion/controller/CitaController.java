package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import entities.Localidad;
import entities.Moneda;
import entities.Provincia;
import entities.TipoCita;
import entities.TipoOfrecimiento;
import model.CitaService;
import model.LocalidadService;
import presentacion.mappers.CitaFormMapper;
import presentacion.vista.CitaForm;

@Singleton
public class CitaController {

	private CitaForm view;
	@Inject private LocalidadService localidadService;
	@Inject private CitaService citaService;
	@Inject private CitaFormMapper mapper;
	
	private Cita currentCita;
	
	@Inject
	private CitaController(CitaForm view) {
		
		this.view = view;
		this.view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		this.view.getBtnAceptar().addActionListener(e -> agregarCita());
		
	}
	
	public void showView() {
	
		fillCombos();
		
		this.view.setVisible(true);

	}
	
	public void setModeNew() {
		
	}
	
	private void fillCombos() {
		
		view.getComboModelTipoCita().clearAndActualize(Arrays.asList(TipoCita.values()));
		
		view.getComboModelProvincia().clearAndActualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		AutoCompleteDecorator.decorate(view.getComboLocalidad());
		cambiaLocalidades();
		
	}

	private void cambiaLocalidades() {
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
		
	}
	
	private void agregarCita() {
		
		//TODO: falta validator
		currentCita = citaService.getNuevaCita();
		mapper.fillBean(currentCita);
		
		citaService.saveCita(currentCita);
		
	}
	
}
