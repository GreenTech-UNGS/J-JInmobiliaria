package vistaController;

import com.google.inject.Inject;

import vista.AgregarCliente;

public class AgregarClienteController {
	
	public static AgregarClienteController instance;
	private AgregarCliente view;
	
	@Inject
	private AgregarClienteController(AgregarCliente view){
		this.view = view;
	}
	
	public void showView(){
			
			view.setVisible(true);
		}

}
