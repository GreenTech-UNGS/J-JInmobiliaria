package presentacion.controller;

import com.google.inject.Inject;

import presentacion.vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	public static AddPropiedadesController instance;
	private AgregarPropiedad view;
	
	@Inject
	private AddPropiedadesController(AgregarPropiedad view){
		
		this.view = view;
	}
	
	public void showView(){
			
			view.setVisible(true);
		}

}
