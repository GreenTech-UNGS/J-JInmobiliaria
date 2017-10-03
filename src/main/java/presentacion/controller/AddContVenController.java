package presentacion.controller;

import com.google.inject.Inject;

import presentacion.vista.AddContratoVen;

public class AddContVenController {
	
	public static AddContVenController instance;
	private AddContratoVen view;
	
	@Inject
	private AddContVenController(AddContratoVen view){
		
		this.view = view;
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
}
