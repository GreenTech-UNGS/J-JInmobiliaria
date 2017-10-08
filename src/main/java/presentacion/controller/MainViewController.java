package presentacion.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.joda.time.YearMonth;

import com.google.inject.Inject;

import entities.EstadoCuota;
import entities.Propiedad;
import model.ClienteService;
import model.ContratoService;
import model.CuotaService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.table.ClientesTableModel;
import presentacion.table.ContratosTableModel;
import presentacion.table.CuotasTableModel;

import presentacion.table.PropiedadesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;

	private PropiedadesTableModel tableModelProp;
	private PropietariosTableModel propietariosTable;
	private CuotasTableModel cuotasTable;
	private ContratosTableModel contratosTable;	
	private ContratosTableModel contratosTable2;
	private ClientesTableModel tableModelClien;
	
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	AddClienteController clienteController;	
	AddPropiedadController propiedadController;
	ReservarPropiedadController reservaController;

	PropiedadService propiedadService;
	ClienteService clienteService;
	ContratoService contratoService;
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
			CuotaService cuotaService,
			ContratosTableModel contratosTable,
			ContratosTableModel contratosTable2,
			ContratoService contratoService){
		
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
		this.contratosTable = contratosTable;
		this.contratosTable2 = contratosTable2;
		this.contratoService = contratoService;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnReservarPropiedad().addActionListener(e -> agregarReserva());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		
		fillTableClientes();
		fillTablePropietarios();
		fillTableCuotas();
		fillTableProp();
		fillTableContratosVenta();
		fillTableContratosAlquiler();
		selectDetalleProp();
	}


	private void fillTableClientes() {
		
		this.tableModelClien.clean();
		this.view.getTableClientes().setModel(tableModelClien);
		tableModelClien.actualizeRows(clienteService.getAll());
		
		this.view.getTableClientes().setColumnModel(tableModelClien.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableContratosVenta() {
		
		this.contratosTable.clean();
		this.view.getTablaContratoVenta().setModel(contratosTable);
		contratosTable.actualizeRows(contratoService.getContratosVenta());
		System.out.println("prueba" + contratoService.getContratosVenta());
	//	contratoService.getContratosVenta().forEach( p -> contratosTable.addRow(p));
		
		this.view.getTablaContratoVenta().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoVenta().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableContratosAlquiler() {
		
		this.contratosTable2.clean();
		this.view.getTablaContratoAlquiler().setModel(contratosTable2);
		contratosTable2.actualizeRows(contratoService.getContratosAlquiler());
	//	contratoService.getContratosAlquiler().forEach(p -> contratosTable2.addRow(p));
		
		this.view.getTablaContratoAlquiler().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoAlquiler().getTableHeader().setReorderingAllowed(false);
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
		cuotaService.getCuotasOf(YearMonth.now(), EstadoCuota.PENDIENTE).forEach(c -> cuotasTable.addRow(c));
		
		this.view.getTableCuotas().setColumnModel(cuotasTable.getTableColumnModel());
		this.view.getTableCuotas().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableProp(){
		this.tableModelProp.clean();
		this.view.getTablePropiedades().setModel(tableModelProp);
		propiedadService.getAll().forEach(p -> tableModelProp.addRow(p));

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
		boolean isPropSelected =  propRow >= 0;
		if (isPropSelected) {
			seleccionada = tableModelProp.getRow(propRow);
			this.propiedadController.setModeView(seleccionada);
			this.propiedadController.setEnabled(false);
			this.propiedadController.showView();
			this.propiedadController.setEnabled(true);
			
		}

	}

	private void agregarReserva(){
		this.reservaController.setModeNew();
		this.reservaController.showView();
	}

	private void agregarContratoAlq() {
		this.contratoAlqController.setModeNew();
		this.contratoAlqController.showView();
		fillTableContratosAlquiler();
	}
	
	private void agregarContratoVen() {
		this.contratoVenController.setModeNew();
		this.contratoVenController.showView();
		fillTableContratosVenta();
	}
	
	private void agregarCliente() {
		this.clienteController.setModeNew();
		this.clienteController.showView();

		fillTableClientes();
		
	}
	
	private void selectDetalleProp(){
		this.view.getTablePropiedades().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				if (me.getClickCount() ==2){
					int selected = view.getTablePropiedades().getSelectedRow();
					if(selected == -1) return;
					viewPropiedad();
				}
			}
		});
	}
}
