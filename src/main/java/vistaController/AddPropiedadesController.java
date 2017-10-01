package vistaController;

import vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	public static AddPropiedadesController instance;
	private AgregarPropiedad view;
	
	public static AddPropiedadesController getController(){
		if(instance == null)
			instance = new AddPropiedadesController();
		return instance;
	}
	
	public AddPropiedadesController(){
		
		view = new AgregarPropiedad();
	}
	
	public void showView(){
			
			view.setVisible(true);
		}

}
