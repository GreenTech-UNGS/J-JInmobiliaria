package presentacion.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.joda.time.DateTime;
import javax.swing.JOptionPane;

import org.joda.time.YearMonth;

import com.google.inject.Inject;

import entities.Contrato;
import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Propiedad;
import entities.Reserva;
import model.ClienteService;
import model.ContratoService;
import model.CuotaService;
import model.PagosCobrosService;
import model.PropiedadService;
import model.PropietarioService;
import model.ReservaService;
import presentacion.table.ClientesTableModel;
import presentacion.table.ContratosTableModel;
import presentacion.table.CuotasTableModel;
import presentacion.table.PagosPropietariosTableModel;
import presentacion.table.PropiedadesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.table.ReservaTableModel;
import presentacion.vista.MainView;

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
	
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	AddClienteController clienteController;	
	AddPropiedadController propiedadController;
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
			AddPropiedadController propiedadesController,
			AddContAlqController contratoAlqController,
			AddContVenController contratoVenController,
			AddClienteController clienteController,
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
		this.view.getBtnDesreservar().addActionListener(e -> borrarReserva());
		this.view.getBtnRegistrarCobro().addActionListener(e -> registrarCobro());
		this.view.getBtnRenovar().addActionListener(e -> renovarContrato());

		
		fillTableClientes();
		fillTableCuotas();
		fillTableProp();
		fillTableContratosVenta();
		fillTableContratosAlquiler();
		fillTablePagosProps();
		selectDetalleProp();
		fillTableReservas();
	}

	private void fillTableClientes() {
		
		this.tableModelClien.clean();
		this.view.getTableClientes().setModel(tableModelClien);
		tableModelClien.actualizeRows(clienteService.getAll());
		
		this.view.getTableClientes().setColumnModel(tableModelClien.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);
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
		cuotaService.getCuotasOf(YearMonth.now(), EstadoCuota.values()).forEach(c -> cuotasTable.addRow(c));
		
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
		CuotaAlquiler selected = null;
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
}
