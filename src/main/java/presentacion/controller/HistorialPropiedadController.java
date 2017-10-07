package presentacion.controller;

import com.google.inject.Inject;

import presentacion.vista.HistorialPropiedadView;

public class HistorialPropiedadController {
	
	private HistorialPropiedadView view;
	
	@Inject
	public HistorialPropiedadController(HistorialPropiedadView view){
		this.view = view;
	}
	
	public void showView(){
		
		view.setVisible(true);
	}

}
