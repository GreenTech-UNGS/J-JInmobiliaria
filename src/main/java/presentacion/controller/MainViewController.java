package presentacion.controller;

import java.util.List;

import com.google.inject.Inject;

import entities.Propiedad;
import model.ClienteService;
import model.CuotaService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.table.ClientesTableModel;
import presentacion.table.CuotasTableModel;
import presentacion.table.PersonaTableModel;
import presentacion.table.PropiedadesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	@Inject
	private PropiedadesTableModel tableModelProp;
	private PropietariosTableModel propietariosTable;
	private CuotasTableModel cuotasTable;
	private List<Propiedad> TablaPropiedades; 
	
	private ClientesTableModel tableModelClien;
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	
	AddClienteController clienteController;	
	AddPropiedadController propiedadController;

	ReservarPropiedadController reservaController;

	PropiedadService propiedadService;
	ClienteService clienteService;
	PropietarioService propietarioService;
	CuotaService cuotaService;
	
	
	@Inject
	private MainViewController(MainView view,
			AddPropiedadController propiedadesController,
			AddContAlqController contratoAlqController,
			AddContVenController contratoVenController,
			AddClienteController clienteController,
			ReservarPropiedadController reservaController,
			PropiedadService propiedadService,
			ClienteService clienteService,
			PropiedadesTableModel tableModelprop,
			PropietarioService propietarioService,
			CuotaService cuotaService){
		
		this.view = view;
		this.tableModelClien = new ClientesTableModel();
		this.propietariosTable = new PropietariosTableModel();
		this.cuotasTable = new CuotasTableModel();
		this.tableModelProp = tableModelprop;
		this.propiedadController = propiedadesController;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		this.reservaController = reservaController;
		this.propiedadService = propiedadService;
		this.clienteService = clienteService;
		this.propietarioService = propietarioService;
		this.cuotaService = cuotaService;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnReservarPropiedad().addActionListener(e -> agregarReserva());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		
		fillTableClientes();
		fillTablePropietarios();
		fillTableCuotas();
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
	
	private void fillTableCuotas() {
		this.cuotasTable.clean();
		this.view.getTableCuotas().setModel(cuotasTable);
		cuotaService.getPendientes().forEach(c -> cuotasTable.addRow(c));
		
		this.view.getTableCuotas().setColumnModel(cuotasTable.getTableColumnModel());
		this.view.getTableCuotas().getTableHeader().setReorderingAllowed(false);
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

	private void viewPropiedad(){

		Propiedad seleccionada;
		int propRow = view.getTablePropiedades().getSelectedRow();
		boolean isPropSelected =  propRow > 0;
		if (isPropSelected) {
			seleccionada = tableModelProp.getRow(propRow);
			this.propiedadController.setModeView(seleccionada);
			this.propiedadController.showView();
		}

	}

	private void agregarReserva(){
	    /*FIXME siente que esto no está bien, cómo podríamos hacer
	     que se actualicen los combo bos cada vez que se abre ña ventana de reserva?*/
	    this.reservaController.fillComboCliente();
	    this.reservaController.fillComboPropiedad();
		this.reservaController.showView();
	}

	private void agregarContratoAlq() {
		this.contratoAlqController.setModeNew();
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
