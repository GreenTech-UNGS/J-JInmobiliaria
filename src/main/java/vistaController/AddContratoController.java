package vistaController;

import com.google.inject.Inject;

import vista.AddContratoAlq;

public class AddContratoController {
	
	public static AddContratoController instance;
	private AddContratoAlq view;
	
	@Inject
	private AddContratoController(AddContratoAlq view){
		
		this.view = view;
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
}
