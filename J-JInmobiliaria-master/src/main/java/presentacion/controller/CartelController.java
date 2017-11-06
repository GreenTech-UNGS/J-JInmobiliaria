package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cartel;
import presentacion.mappers.CartelMapper;
import presentacion.vista.CartelForm;

@Singleton
public class CartelController {

	private CartelForm view;
	
	@Inject CartelMapper mapper;

	private Cartel currentCartel;
	private boolean okWasPressed;
	
	@Inject
	private CartelController(CartelForm view) {
		this.view = view;
		
		this.view.getBtnAceptar().addActionListener(e -> aceptar());

	}

	private void aceptar() {
		okWasPressed = true;
		this.view.setVisible(false);
	}

	public void showView() {
		this.view.setVisible(true);
	}
	
	public Cartel getCartel() {
		
		if(!okWasPressed)
			return null;
		
		mapper.fillBean(currentCartel);
		
		return currentCartel;
		
	}

	public void setModeNew() {
		okWasPressed = false;
		currentCartel = new Cartel();
		
		mapper.fillFields(currentCartel);
		
	}
		
}
