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
	@Inject private PersonasPanelController inquilinosPanelController;
	@Inject private CitasPanelController citasPanelController;
	@Inject private EscritorioPanelController escritorioPanelController;
	
	@Inject
	MenuPanelController(MenuPanel view) {
		
		this.view = view;
		
		view.getBtnPropiedades().addActionListener(e -> cambiaPanelPropiedades());
	
		view.getBtnContratos().addActionListener(e -> cambiaPanelContratos());
		
		view.getBtnInquilinos().addActionListener(e -> cambiaPanelInquilino());
		
		view.getBtnPagos().addActionListener(e -> cambiaPanelPagos());
      
		view.getBtnReportes().addActionListener(e -> cambiaPanelCitas());
     
		view.getBtnInmobiliaria().addActionListener(e -> cambiaPanelInmobiliaria());
		
		view.getBtnHome().addActionListener(e -> cambiaPanelEscritorio());
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	private void cambiaPanelInmobiliaria() {
		hideAll();
		inmobiliariaPanelController.showView();
		inmobiliariaPanelController.actualize();
	}
	
	private void cambiaPanelCitas(){
		hideAll();
		citasPanelController.showView();
		citasPanelController.actualize();
	}
	
	private void cambiaPanelEscritorio(){
		hideAll();
		escritorioPanelController.showView();
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
		citasPanelController.actualize();
	}
	
	private void hideAll(){
		contratosPanelController.hideView();
		inmobiliariaPanelController.hideView();
		pagosPanelController.hideView();
		propiedadesPanelController.hideView();
		inquilinosPanelController.hideView();
		citasPanelController.hideView();
		escritorioPanelController.hideView();
	}
}
