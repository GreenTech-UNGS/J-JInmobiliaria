package presentacion.controller;

import java.util.List;
import com.google.inject.Inject;

import entities.Propiedad;
import presentacion.table.PropiedadesTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	AddPropiedadesController propiedadesController;
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	AgregarClienteController clienteController;
	private PropiedadesTableModel tableModel;
	private List<Propiedad> propiedadesTabla; 
	
	@Inject
	private MainViewController(MainView view, AddPropiedadesController propiedadesController,
			AddContAlqController contratoAlqController, AddContVenController contratoVenController,
			AgregarClienteController clienteController){
		
		this.view = view;
		this.tableModel = new PropiedadesTableModel();
		this.propiedadesController = propiedadesController;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
	}


	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.propiedadesController.showView();
	}
	
	private void agregarContratoAlq() {
		this.contratoAlqController.showView();
	}
	
	private void agregarContratoVen() {
		this.contratoVenController.showView();
	}
	
	private void agregarCliente() {
		this.clienteController.setModeNew();
		this.clienteController.showView();
	}

}
