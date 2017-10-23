package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.CobrosDeAlquileresDTO;
import dto.MovimientoDeCajaDTO;
import dto.PendientesPropietariosDTO;
import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.PagoPropietario;
import filtros.CuotaFiltro;
import model.CuotaService;
import model.MovimientoCajaService;
import model.PagosCobrosService;
import org.joda.time.YearMonth;
import presentacion.controller.MovimientoCajaController;
import presentacion.controller.RegistrarCobroController;
import presentacion.controller.filtros.CuotaFiltroController;
import presentacion.main.vista.PagosPanel;
import presentacion.reportes.ReporteCobrosDeAlquileres;
import presentacion.reportes.ReporteMovimientosDeCaja;
import presentacion.reportes.ReportePropietariosPagosPendientes;
import presentacion.table.CuotasTableModel;
import presentacion.table.PagosPropietariosTableModel;

import javax.swing.*;
import java.util.List;

@Singleton
public class PagosPanelController {

	private PagosPanel view;
	
	@Inject private CuotasTableModel cuotasTable;
	@Inject private PagosPropietariosTableModel pagopropTable;
	@Inject private CuotaService cuotaService;
	@Inject private MovimientoCajaService movimientoService;
	
	@Inject private PagosCobrosService pagoCobroService;
	@Inject private RegistrarCobroController cobroController;
	@Inject private CuotaFiltroController cuotaFiltro;
	
	@Inject private MovimientoCajaController movimientoController;
	
	private CuotaFiltro currentCuotaFiltro;
	
	@Inject
	PagosPanelController(PagosPanel view) {
		
		this.view = view;

		this.view.getBtnRegistrarCobro().addActionListener(e -> registrarCobro());
		this.view.getBtnRegistrarPago().addActionListener(e -> registrarPago());
		this.view.getBtnRegistrarIngreso().addActionListener(e -> registraMovimientoCaja(true));
		this.view.getBtnRegistrarEgreso().addActionListener(e -> registraMovimientoCaja(false));
		
		this.view.getBtnGenerarReporteCobros().addActionListener(e -> generaReporteCobroDeAlquileres());
		this.view.getBtnGenerarReportePropietarios().addActionListener(e -> generaReportePropietarios());
		this.view.getBtnGenerarReporteMovimientos().addActionListener(e -> generaReporteMovimientos());
		
		this.view.getBtnAplicarFiltroAlq().addActionListener(e -> aplicarFiltroAlq());
		this.view.getBtnRemoverFiltroAlq().addActionListener(e -> removerFiltroAlq());
		
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
			
			int option = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pago al propietario?", "Resgistrar Pago", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(option == 0) {
				pagoCobroService.registrarpagoPropietario(p);
				this.fillTablePagosProps();
			}			
		}
	}
	
	private void aplicarFiltroAlq(){
		this.cuotaFiltro.setModeNew();
		this.cuotaFiltro.showView();
		
		CuotaFiltro filtro = cuotaFiltro.getFiltro();
		
		//if(filtro != null)
			currentCuotaFiltro = filtro;
			//cuotasTable.actualizeRows(cuotaService.getAllByFiltro(filtro));
			fillTableCuotas();
	}
	
	private void removerFiltroAlq(){
		currentCuotaFiltro = null;
		this.fillTableCuotas();
	}
	
	private void fillTableCuotas() {
		this.cuotasTable.clean();
		this.view.getTableCuotas().setModel(cuotasTable);
		if(currentCuotaFiltro == null)cuotaService.getAllOfNow().forEach(c -> cuotasTable.addRow(c));
		else cuotasTable.actualizeRows(cuotaService.getAllByFiltro(currentCuotaFiltro));
		
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
	
	private void registraMovimientoCaja(boolean isIngreso){
	
		if(isIngreso)movimientoController.setModeNewIngreso();
		else movimientoController.setModeNewEgreso();
		movimientoController.showView();
	}
		
	private void generaReportePropietarios() {
		List<PendientesPropietariosDTO> dtos = pagoCobroService.pagosPendientesReporte();
		ReportePropietariosPagosPendientes reporte = new ReportePropietariosPagosPendientes(dtos);
		
		reporte.mostrar();
		
	}
	private void generaReporteMovimientos() {
		List<MovimientoDeCajaDTO> dtos = movimientoService.getReporteMovimientoDeCaja();
		ReporteMovimientosDeCaja reporte = new ReporteMovimientosDeCaja(dtos);

		reporte.mostrar();
	}

	private void generaReporteCobroDeAlquileres() {
		List<CobrosDeAlquileresDTO> dtos =
				pagoCobroService.cobrosDeAlquilerReporteOf(cuotasTable.getAllRows());
		ReporteCobrosDeAlquileres reporte = new ReporteCobrosDeAlquileres(dtos);
		reporte.mostrar();

	}
	
	private void fillTableMovimientosCaja() {
		this.view.getTableMovimientosModel().clean();
		
		this.view.getTableMovimientosModel().addRows(movimientoService.getAll());

		this.view.getTableMovimientosCaja().getTableHeader().setReorderingAllowed(false);
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void showView() {
		
		this.view.setVisible(true);
		
	}

	public void actualize() {
		fillTableMovimientosCaja();
		fillTablePagosProps();
		fillTableCuotas();
		
	}
}
