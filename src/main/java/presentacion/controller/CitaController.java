package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.CitaForm;

@Singleton
public class CitaController {

	private CitaForm view;
	
	@Inject
	private CitaController(CitaForm view) {
		
		this.view = view;
		
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
}
