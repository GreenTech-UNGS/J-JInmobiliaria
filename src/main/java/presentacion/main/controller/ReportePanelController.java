package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.ReportesPanel;

@Singleton
public class ReportePanelController {
	
	@Inject private ReportesPanel view;

	public void hideView() {
		
		this.view.setVisible(false);
		
	}
	
	public void showView() {
		
		this.view.setVisible(true);
		
	}

	public void actualize() {
		// TODO Auto-generated method stub
		
	}

}
