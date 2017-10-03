package presentacion.controller;

import com.google.inject.Inject;

import presentacion.vista.AddContratoAlq;

public class AddContAlqController {
	
	public static AddContAlqController instance;
	private AddContratoAlq view;
	
	@Inject
	private AddContAlqController(AddContratoAlq view){
		
		this.view = view;
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
}
