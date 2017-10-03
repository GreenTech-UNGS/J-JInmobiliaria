package presentacion.controller;

import com.google.inject.Inject;

import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	AddPropiedadesController propiedadesController;
	AddContratoController contratoController;
	AgregarClienteController clienteController;
	
	@Inject
	private MainViewController(MainView view, AddPropiedadesController propiedadesController,
			AddContratoController contratoController, AgregarClienteController clienteController){
		
		this.view = view;
		this.propiedadesController = propiedadesController;
		this.contratoController = contratoController;
		this.clienteController = clienteController;
		
//		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
//		this.view.getBtnContrato().addActionListener(e -> agregarContrato());
//		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
	}


	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.propiedadesController.showView();
	}
	
	private void agregarContrato() {
		this.contratoController.showView();
	}
	
	private void agregarCliente() {
		this.clienteController.setModeNew();
		this.clienteController.showView();
		
	}
}
