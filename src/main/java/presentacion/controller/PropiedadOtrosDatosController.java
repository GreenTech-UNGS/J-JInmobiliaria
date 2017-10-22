package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PropiedadOtrosDatos;
import entities.TipoPropiedad;
import presentacion.mappers.PropiedadOtrosDatosMapper;
import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosController {

	private PropiedadOtrosDatosForm view;
	
	@Inject PropiedadOtrosDatosMapper mapper;
	
	private boolean okWasPressed;
	
	@Inject
	private PropiedadOtrosDatosController(PropiedadOtrosDatosForm view) {
		
		this.view = view;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		
		fillCombo();
		
	}
	
	private void aceptar() {
		okWasPressed = true;
		this.view.setVisible(false);
	
	}

	private void fillCombo() {
		this.view.getTipoCombo().removeAllElements();
		this.view.getTipoCombo().actualize(Arrays.asList(TipoPropiedad.values()));
	}
	
	public void setModeNew() {
		okWasPressed = false;
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public PropiedadOtrosDatos getOtrosDatos() {
		if(!okWasPressed)
			return null;
			
		PropiedadOtrosDatos toRet = new PropiedadOtrosDatos();
		mapper.fillBean(toRet);
		
		
		return toRet;
	}
	
}
