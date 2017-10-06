package presentacion.controller;

import java.util.List;
import com.google.inject.Inject;

import entities.Propiedad;
import model.ClienteService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.table.ClientesTableModel;
import presentacion.table.PersonaTableModel;
import presentacion.table.PropiedadesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	@Inject
	private PropiedadesTableModel tableModelProp;
	private PropietariosTableModel propietariosTable;
	private List<Propiedad> TablaPropiedades; 
	
	private ClientesTableModel tableModelClien;
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	
	AddClienteController clienteController;	
	AddPropiedadController propiedadController;
	
	PropiedadService propiedadService;
	ClienteService clienteService;
	PropietarioService propietarioService;
	
	@Inject
	private MainViewController(MainView view, AddPropiedadController propiedadesController,
			AddContAlqController contratoAlqController, AddContVenController contratoVenController,
			AddClienteController clienteController,
			PropiedadService propiedadService, ClienteService clienteService,PropiedadesTableModel tableModelprop,
			PropietarioService propietarioService){
		
		this.view = view;
		this.tableModelClien = new ClientesTableModel();
		this.propietariosTable = new PropietariosTableModel();
		this.tableModelProp = tableModelprop;
		this.propiedadController = propiedadesController;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		this.propiedadService = propiedadService;
		this.clienteService = clienteService;
		this.propietarioService = propietarioService;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		
		fillTableClientes();
		fillTablePropietarios();
		fillTableProp();
	}


	private void fillTableClientes() {
		
		this.tableModelClien.clean();
		this.view.getTableClientes().setModel(tableModelClien);
		tableModelClien.actualizeRows(clienteService.getAll());
		
		this.view.getTableClientes().setColumnModel(tableModelClien.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTablePropietarios() {
		this.propietariosTable.clean();
		this.view.getTablePropietarios().setModel(propietariosTable);
		propietarioService.getAll().forEach(p -> propietariosTable.addRow(p));
		
		this.view.getTablePropietarios().setColumnModel(propietariosTable.getTableColumnModel());
		this.view.getTablePropietarios().getTableHeader().setReorderingAllowed(false);
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
