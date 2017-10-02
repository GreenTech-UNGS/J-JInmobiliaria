package vistaController;

import vista.AgregarCliente;

public class AgregarClienteController {
	
	public static AgregarClienteController instance;
	private AgregarCliente view;
	
	public static AgregarClienteController getController(){
		if(instance == null)
			instance = new AgregarClienteController();
		return instance;
	}
	
	public AgregarClienteController(){
		
		view = new AgregarCliente();
	}
	
	public void showView(){
			
			view.setVisible(true);
		}

}
