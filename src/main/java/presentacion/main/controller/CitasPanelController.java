package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.CitasPanel;

@Singleton
public class CitasPanelController {

	private CitasPanel view;
	
	@Inject
	private CitasPanelController(CitasPanel view){
		
		this.view = view;
		
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	public void actualize() {
		// TODO Auto-generated method stub
		
	}

	public void hideView() {
		this.view.setVisible(false);
		
	}
	
}