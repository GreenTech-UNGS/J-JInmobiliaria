package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Habitacion;
import entities.TipoHabitacion;
import model.PropiedadService;
import persistencia.dao.iface.PropiedadDao;
import presentacion.mappers.HabitacionMapper;
import presentacion.vista.HabitacionForm;

@Singleton
public class HabitacionController {

	private HabitacionForm view;
	
	@Inject HabitacionMapper mapper;
	@Inject PropiedadService propiedadService; 

	private Habitacion currentHabitacion;
	private boolean okWasPressed;
	
	@Inject
	private HabitacionController(HabitacionForm view) {
		this.view = view;
		
		this.view.getBtnAceptar().addActionListener(e -> aceptar());
		
	}

	private void aceptar() {
		okWasPressed = true;
		this.view.setVisible(false);
	}

	public void showView() {
		fillCombo();
		this.view.setVisible(true);

	}
	
	public Habitacion getHabitacion() {
		
		if(!okWasPressed)
			return null;
		
		mapper.fillBean(currentHabitacion);
		
		return currentHabitacion;
		
	}

	public void setModeNew() {
		okWasPressed = false;
		currentHabitacion = new Habitacion();
		
		mapper.fillFields(currentHabitacion);
		
	}
	
	private void fillCombo() {
		this.view.getComboModel().actualize(propiedadService.getAllTipoHabitacion());
		
	}
	
}
