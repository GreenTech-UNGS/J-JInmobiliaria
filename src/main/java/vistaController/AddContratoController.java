package vistaController;

import vista.AddContratoAlq;

public class AddContratoController {
	
	public static AddContratoController instance;
	private AddContratoAlq view;
	
	public static AddContratoController getController(){
		if(instance == null)
			instance = new AddContratoController();
		return instance;
	}
	
	public AddContratoController(){
		
		view = new AddContratoAlq();
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
}
