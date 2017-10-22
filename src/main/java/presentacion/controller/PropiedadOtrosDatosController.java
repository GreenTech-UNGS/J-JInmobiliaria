package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PropiedadOtrosDatos;
import entities.TipoPropiedad;
import presentacion.mappers.PropiedadOtrosDatosMapper;
import presentacion.validators.MessageShow;
import presentacion.validators.PropiedadOtrosDatosValidator;
import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosController {

	private PropiedadOtrosDatosForm view;
	
	@Inject PropiedadOtrosDatosMapper mapper;
	@Inject PropiedadOtrosDatosValidator validator;
	@Inject MessageShow msgShw;
	
	private boolean okWasPressed;
	private PropiedadOtrosDatos currentDatos;
	
	@Inject
	private PropiedadOtrosDatosController(PropiedadOtrosDatosForm view) {
		
		this.view = view;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		
		fillCombo();
		
	}
	
	private void aceptar() {
		if(validator.isValid()) {
			okWasPressed = true;
			this.view.setVisible(false);
		}
		else {
			msgShw.showErrorMessage(validator.getErrorMessage(), "Error");
		}
	
	}

	private void fillCombo() {
		this.view.getTipoCombo().removeAllElements();
		this.view.getTipoCombo().actualize(Arrays.asList(TipoPropiedad.values()));
	}
	
	public void setModeNew() {
		okWasPressed = false;
		currentDatos = new PropiedadOtrosDatos();
		currentDatos.setTipo(TipoPropiedad.Otro);
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public PropiedadOtrosDatos getOtrosDatos() {
		if(!okWasPressed)
			return null;
			
		mapper.fillBean(currentDatos);
		
		return currentDatos;
	}
	
}
