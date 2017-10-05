package presentacion.controller;

import java.util.List;
import com.google.inject.Inject;

import entities.Propiedad;
import model.ClienteService;
import model.PropiedadService;
import presentacion.table.ClientesTableModel;
import presentacion.table.PropiedadesTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	private PropiedadesTableModel tableModelProp;
	private List<Propiedad> TablaPropiedades; 
	
	private ClientesTableModel tableModelClien;
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	
	AddClienteController clienteController;	
	AddPropiedadController propiedadController;
	
	PropiedadService propiedadService;
	ClienteService clienteService;
	
	@Inject
	private MainViewController(MainView view, AddPropiedadController propiedadesController,
			AddContAlqController contratoAlqController, AddContVenController contratoVenController,
			AddClienteController clienteController,
			PropiedadService propiedadService, ClienteService clienteService){
		
		this.view = view;
		this.tableModelProp = new PropiedadesTableModel();
		this.tableModelClien = new ClientesTableModel();
		this.propiedadController = propiedadesController;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		this.propiedadService = propiedadService;
		this.clienteService = clienteService;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		
		fillTableClientes();
		fillTableProp();
	}


	private void fillTableClientes() {
		
		this.tableModelClien.clean();
		this.view.getTableClientes().setModel(tableModelClien);
		tableModelClien.actualizeRows(clienteService.getAll());
		
		this.view.getTableClientes().setColumnModel(tableModelClien.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableProp(){
		
		this.tableModelProp.clean();
		this.view.getTablePropiedades().setModel(tableModelProp);
		tableModelProp.actualizeRows(propiedadService.getAll());
		
		this.view.getTablePropiedades().setColumnModel(tableModelProp.getTableColumnModel());
		this.view.getTablePropiedades().getTableHeader().setReorderingAllowed(false);
		
		
	}


	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.propiedadController.setModeNew();
		this.propiedadController.showView();
		fillTableProp();
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
		fillTableClientes();
	}
}
