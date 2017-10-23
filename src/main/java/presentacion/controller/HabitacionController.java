package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Habitacion;
import entities.TipoHabitacion;
import presentacion.mappers.HabitacionMapper;
import presentacion.vista.HabitacionForm;

@Singleton
public class HabitacionController {

	private HabitacionForm view;
	
	@Inject HabitacionMapper mapper;

	private Habitacion currentHabitacion;
	private boolean okWasPressed;
	
	@Inject
	private HabitacionController(HabitacionForm view) {
		this.view = view;
		
		this.view.getBtnAceptar().addActionListener(e -> aceptar());
		
		fillCombo();
	}

	private void aceptar() {
		okWasPressed = true;
		this.view.setVisible(false);
	}

	public void showView() {
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
		currentHabitacion.setTipo(TipoHabitacion.Otro);
		
		mapper.fillFields(currentHabitacion);
		
	}
	
	private void fillCombo() {
		this.view.getComboModel().actualize(Arrays.asList(TipoHabitacion.values()));
		
	}
	
}
