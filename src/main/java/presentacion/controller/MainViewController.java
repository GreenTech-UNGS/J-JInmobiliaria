package presentacion.controller;

import com.google.inject.Inject;
import dto.PendientesPropietariosDTO;
import entities.*;
import model.*;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import presentacion.reportes.ReportePropietariosPagosPendientes;
import presentacion.table.*;
import presentacion.vista.MainView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainViewController {
	
	private MainView view;

	private PropiedadesTableModel tableModelProp;
	private PropietariosTableModel propietariosTable;
	private CuotasTableModel cuotasTable;
	private ContratosTableModel contratosTable;	
	private ContratosTableModel contratosTable2;
	private ClientesTableModel tableModelClien;
	private ReservaTableModel reservaTable;
	private PagosPropietariosTableModel pagopropTable;
	
	ContratoAlquilerController contratoAlqController;
	ContratoVentaController contratoVenController;
	ClienteController clienteController;	
	PropietarioController propietarioController;	
	PropiedadController propiedadController;
	ReservarPropiedadController reservaController;
	RegistrarCobroController cobroController;

	PropiedadService propiedadService;
	ClienteService clienteService;
	ContratoService contratoService;
	PropietarioService propietarioService;
	CuotaService cuotaService;
	ReservaService reservaService;
	PagosCobrosService pagoCobroService;
	
	
	@Inject
	private MainViewController(MainView view,
			PropiedadController propiedadesController,
			ContratoAlquilerController contratoAlqController,
			ContratoVentaController contratoVenController,
			ClienteController clienteController,
			PropietarioController propietarioController,
			ReservarPropiedadController reservaController,
			PropiedadService propiedadService,
			PagosCobrosService pagoCobroService,
			ClienteService clienteService,
			PropiedadesTableModel tableModelprop,
			CuotasTableModel cuotasTable,
			PropietarioService propietarioService,
			CuotaService cuotaService,
			ContratosTableModel contratosTable,
			ContratosTableModel contratosTable2,
			PagosPropietariosTableModel pagopropTable,
			ContratoService contratoService,
			ReservaService reservaService,
			RegistrarCobroController cobroController){
		
		this.view = view;
		this.tableModelClien = new ClientesTableModel();
		this.propietariosTable = new PropietariosTableModel();
		this.cuotasTable = cuotasTable;
		this.reservaTable = new ReservaTableModel();
		this.tableModelProp = tableModelprop;
		this.propiedadController = propiedadesController;
		this.pagoCobroService = pagoCobroService;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		this.propietarioController = propietarioController;
		this.reservaController = reservaController;
		this.propiedadService = propiedadService;
		this.clienteService = clienteService;
		this.propietarioService = propietarioService;
		this.cuotaService = cuotaService;
		this.contratosTable = contratosTable;
		this.contratosTable2 = contratosTable2;
		this.pagopropTable = pagopropTable;
		this.contratoService = contratoService;
		this.reservaService = reservaService;
		this.cobroController = cobroController;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnReservarPropiedad().addActionListener(e -> agregarReserva());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		this.view.getBtnEditarCliente().addActionListener(e -> editarCliente());
		this.view.getBtnEditPropiedad().addActionListener(e -> editarPropiedad());
		this.view.getBtnAgregarPropietario().addActionListener(e -> agregarPropietario());
		this.view.getBtnEditarPropietario().addActionListener(e -> editarPropietario());
		this.view.getBtnDesreservar().addActionListener(e -> borrarReserva());
		this.view.getBtnRegistrarCobro().addActionListener(e -> registrarCobro());
		this.view.getBtnRenovar().addActionListener(e -> renovarContrato());
		this.view.getBtnRegistrarPago().addActionListener(e -> registrarPago());
		
		this.view.getBtnGenerarReportePropietarios().addActionListener(e -> generaReportePropietarios());
		
		this.view.getBtnPropiedades().addActionListener(e -> {fillTableProp();
													fillTableReservas();});
		this.view.getBtnContratos().addActionListener(e -> {fillTableContratosAlquiler(); 
													fillTableContratosVenta();});
		this.view.getBtnPagos().addActionListener(e -> {fillTableCuotas();
												fillTablePagosProps();});
		this.view.getBtnInquilinos().addActionListener(e -> {fillTableClientes();
														fillTablePropietarios();});	
		
		selectDetalleProp();
		fillAllTables();
	}

	private void fillAllTables() {
		fillTableClientes();
		fillTableCuotas();
		fillTableProp();
		fillTablePropietarios();
		fillTableContratosVenta();
		fillTableContratosAlquiler();
		fillTablePagosProps();
		fillTableReservas();
	}

	private void generaReportePropietarios() {
		List<PendientesPropietariosDTO> dtos = propietarioService.pagosPendientesReporte();
		ReportePropietariosPagosPendientes reporte = new ReportePropietariosPagosPendientes(dtos);
		
		reporte.mostrar();
		
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
		propietariosTable.actualizeRows(propietarioService.getAll());
		
		this.view.getTablePropietarios().setColumnModel(propietariosTable.getTableColumnModel());
		this.view.getTablePropietarios().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableReservas() {
		this.reservaTable.clean();
		this.view.getTablaReservas().setModel(reservaTable);
		reservaTable.actualizeRows(reservaService.getAll());
		
		this.view.getTablaReservas().setColumnModel(reservaTable.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);	
	}
	
	private void fillTableContratosVenta() {
		
		this.contratosTable.clean();
		this.view.getTablaContratoVenta().setModel(contratosTable);
		contratoService.getContratosVenta().forEach(c -> contratosTable.addRow(c));
		
		this.view.getTablaContratoVenta().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoVenta().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableContratosAlquiler() {
		
		this.contratosTable2.clean();
		this.view.getTablaContratoAlquiler().setModel(contratosTable2);
		contratoService.getContratosAlquiler().forEach(c -> contratosTable2.addRow(c));
		
		this.view.getTablaContratoAlquiler().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoAlquiler().getTableHeader().setReorderingAllowed(false);
	}

	
	private void fillTableCuotas() {
		this.cuotasTable.clean();
		this.view.getTableCuotas().setModel(cuotasTable);
		cuotaService.getAll().forEach(c -> cuotasTable.addRow(c));
		
		this.view.getTableCuotas().setColumnModel(cuotasTable.getTableColumnModel());
		this.view.getTableCuotas().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTablePagosProps() {
		this.pagopropTable.clean();
		this.view.getTablePagosPropietarios().setModel(pagopropTable);
		pagoCobroService.getAllPagosPropsPendientes().forEach(c -> pagopropTable.addRow(c));
		
		this.view.getTablePagosPropietarios().setColumnModel(pagopropTable.getTableColumnModel());
		this.view.getTablePagosPropietarios().getTableHeader().setReorderingAllowed(false);
		
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
		this.fillTableProp();
		this.fillTableReservas();
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
	
	private void editarCliente() {
		int select = this.view.getTableClientes().getSelectedRow();
		
		if (select!=-1){
			clienteController.editarCliente(this.tableModelClien.getRow(select));
			clienteController.showView();
			this.fillTableClientes();
		}
	}

	private void editarPropiedad() {
		int select = this.view.getTablePropiedades().getSelectedRow();

		if (select!=-1){
			propiedadController.editPropiedad(this.tableModelProp.getRow(select));
			propiedadController.showView();
			this.fillTableProp();
		}
	}
	private void agregarPropietario() {
		this.propietarioController.setModeNew();
		this.propietarioController.showView();

		fillTablePropietarios();
	}
		
	private void editarPropietario() {
		int select = this.view.getTablePropietarios().getSelectedRow();
		
		if (select != -1){ 
			propietarioController.editarPropietario(this.propietariosTable.getRow(select));
			propietarioController.showView();
			this.fillTablePropietarios();
		}
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
	
	private void borrarReserva(){
		if(this.view.getTablaReservas().getSelectedRow()!=-1){
			Reserva seleccion = reservaTable.getRow(this.view.getTablaReservas().getSelectedRow());
			
			
			HistoriaEstadoProp estado = new HistoriaEstadoProp();
    		estado.setEstado(EstadoProp.DISPONIBLE);
    		estado.setFecha(DateTime.now());
    		
    		Propiedad propiedad = seleccion.getPropiedad();
    		
    		propiedad.getEstados().add(estado);
    		propiedadService.actualizarPropiedad(propiedad);
    		
    		reservaService.remove(seleccion);
    		
			fillTableReservas();
			fillTableProp();
		}
	}
	
	private void renovarContrato(){
		if(this.view.getTablaContratoAlquiler().getSelectedRow()!=-1){
			ContratoAlquiler seleccion = (ContratoAlquiler)contratosTable2.getRow(this.view.getTablaContratoAlquiler().getSelectedRow());
			
			this.contratoAlqController.setRenovarMode(seleccion);
			fillTableContratosAlquiler();
		}
	}
		
	private void registrarCobro() {
		int select = this.view.getTableCuotas().getSelectedRow();
		
		if (select!=-1){
			CuotaAlquiler c = cuotasTable.getRow(select);
			if(!cuotaService.getEstadoOf(c).equals(EstadoCuota.PENDIENTE)) {
				JOptionPane.showMessageDialog(null, "Solo se pueden registrar pagos de cuotas pendientes", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				cobroController.setCuota(c);
			
				cobroController.showView();
				this.fillTableCuotas();
			}			
		}		
	}
	
	private void registrarPago() {
		int select = this.view.getTablePagosPropietarios().getSelectedRow();
		
		if (select!=-1){
			PagoPropietario p = pagopropTable.getRow(select);
			
			int option = JOptionPane.showConfirmDialog(null, "?Desea registrar el pago al propietario?", "Resgistrar Pago", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(option == 0) {
				pagoCobroService.registrarpagoPropietario(p);
				this.fillTablePagosProps();
			}			
		}
	}
}
