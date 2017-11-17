package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.EscritorioPanel;
import presentacion.main.vista.InmobiliariaPanel;

@Singleton
public class EscritorioPanelController {
	
	private EscritorioPanel view;
	
	@Inject
	private EscritorioPanelController(EscritorioPanel view){
		this.view = view;
	}
	
	public void showView() {
		
		this.view.setVisible(true);
		System.out.println("se apreto");
	}
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}
}
