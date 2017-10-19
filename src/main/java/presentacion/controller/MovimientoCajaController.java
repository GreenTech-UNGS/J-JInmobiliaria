package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.MovimientoCajaForm;

@Singleton
public class MovimientoCajaController {

	private MovimientoCajaForm view;
	
	@Inject
	private MovimientoCajaController(MovimientoCajaForm view) {
		this.view = view;
	}
	
	public void setModeNew(){
		
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	public void hideView(){
		this.view.setVisible(false);
	}
	
}
