package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.MenuPanel;

@Singleton
public class MenuPanelController {

	private MenuPanel view;
	
	@Inject private ContratosPanelController contratosPanelController;
	@Inject private InmobiliariaPanelController inmobiliariaPanelController;
	@Inject private PagosPanelController pagosPanelController;
	@Inject private PropiedadesPanelController propiedadesPanelController;
	@Inject private InquilinosPanelController inquilinosPanelController;
	@Inject private ReportePanelController reportePanelController;
	
	@Inject
	MenuPanelController(MenuPanel view) {
		
		this.view = view;
		
		view.getBtnPropiedades().addActionListener(e -> cambiaPanelPropiedades());
	
		view.getBtnContratos().addActionListener(e -> cambiaPanelContratos());
		
		view.getBtnInquilinos().addActionListener(e -> cambiaPanelInquilino());
		
		view.getBtnPagos().addActionListener(e -> cambiaPanelPagos());
      
		view.getBtnReportes().addActionListener(e -> cambiaPanelReportes());
     
		view.getBtnInmobiliaria().addActionListener(e -> cambiaPanelInmobiliaria());
	  
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	private void cambiaPanelInmobiliaria() {
		hideAll();
		System.out.println("asd");
		inmobiliariaPanelController.showView();
		inmobiliariaPanelController.actualize();
	}

	private void cambiaPanelReportes() {
		hideAll();
		reportePanelController.showView();
		reportePanelController.actualize();
	}

	private void cambiaPanelPagos() {
		hideAll();
		pagosPanelController.showView();
		pagosPanelController.actualize();
	}

	private void cambiaPanelInquilino() {
		hideAll();
		inquilinosPanelController.showView();
		inquilinosPanelController.actualize();
	}

	private void cambiaPanelContratos() {
		hideAll();
		contratosPanelController.showView();
		contratosPanelController.actualize();
	}

	private void cambiaPanelPropiedades() {
		hideAll();
		propiedadesPanelController.showView();
		propiedadesPanelController.actualize();
	}
	
	public void actualizeAll(){
		contratosPanelController.actualize();
		inmobiliariaPanelController.actualize();
		pagosPanelController.actualize();
		propiedadesPanelController.actualize();
		inquilinosPanelController.actualize();
		reportePanelController.actualize();
	}
	
	private void hideAll(){
		contratosPanelController.hideView();
		inmobiliariaPanelController.hideView();
		pagosPanelController.hideView();
		propiedadesPanelController.hideView();
		inquilinosPanelController.hideView();
		reportePanelController.hideView();
	}
}
