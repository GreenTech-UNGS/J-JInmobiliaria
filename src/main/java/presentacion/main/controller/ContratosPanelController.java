package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.ContratosPanel;

@Singleton
public class ContratosPanelController {

	private ContratosPanel view;
	
	@Inject ContratosAlquilerTabController alquilerController;
	@Inject ContratosVentaTabController ventaController;
	
	@Inject
	public ContratosPanelController(ContratosPanel view) {
		
		this.view = view;
		
		//TODO: se podria cambiar a que se actualize cada table individualmente
		this.view.getTabs().addChangeListener(e -> actualize());
		
	}
	
	public void showView(){
		this.view.setVisible(true);
		this.view.getTabs().setSelectedIndex(0);
	}
	
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actualize() {
		alquilerController.fillTableContratosAlquiler();
		ventaController.fillTableContratosVenta();
	}
}
