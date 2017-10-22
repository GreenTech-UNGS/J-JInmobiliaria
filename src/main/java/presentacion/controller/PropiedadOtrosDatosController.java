package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosController {

	private PropiedadOtrosDatosForm view;
	
	@Inject
	private PropiedadOtrosDatosController(PropiedadOtrosDatosForm view) {
		
		this.view = view;
		
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
}
