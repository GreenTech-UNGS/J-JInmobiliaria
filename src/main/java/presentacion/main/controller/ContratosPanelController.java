package presentacion.main.controller;

import javax.swing.JOptionPane;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;
import entities.EstadoContrato;
import filtros.ContratoAlquilerFiltro;
import model.ContratoService;
import presentacion.controller.ContratoAlquilerController;
import presentacion.controller.ContratoVentaController;
import presentacion.controller.filtros.ContratoAlquilerFiltroController;
import presentacion.main.vista.ContratosPanel;
import presentacion.table.ContratosTableModel;

@Singleton
public class ContratosPanelController {

	private ContratosPanel view;
	@Inject private ContratoAlquilerController contratoAlqController;
	@Inject private ContratoVentaController contratoVenController;
	@Inject private ContratoService contratoService;
	
	@Inject private ContratoAlquilerFiltroController alquilerfiltro; 
	
	@Inject private ContratosTableModel contratosTable;	
	@Inject private ContratosTableModel contratosTable2;
	
	ContratoAlquilerFiltro currentAlqFiltro;
	
	@Inject
	public ContratosPanelController(ContratosPanel view) {
		
		this.view = view;
		
		this.view.getBtnRenovar().addActionListener(e -> renovarContrato());
		this.view.getBtnCancelarContrato().addActionListener(e -> cancelarContrato());
		
		this.view.getBtnAgregarContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnAgregarContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnEditarContrato().addActionListener(e -> editarContrato());
		
		this.view.getBtnAplicarFiltro().addActionListener(e -> aplicarFiltroAlq());
		this.view.getBtnRemoverFiltro().addActionListener(e -> removerFiltroAlq());
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	private void renovarContrato(){
		if(this.view.getTablaContratoAlquiler().getSelectedRow()!=-1){
			ContratoAlquiler seleccion = (ContratoAlquiler)contratosTable2.getRow(this.view.getTablaContratoAlquiler().getSelectedRow());
			
			this.contratoAlqController.setRenovarMode(seleccion);
			fillTableContratosAlquiler();
		}
	}
	
	private void cancelarContrato() {
		if (this.view.getTablaContratoAlquiler().getSelectedRow()!=-1){
			
			ContratoAlquiler contrato = (ContratoAlquiler) contratosTable2.getRow(this.view.getTablaContratoAlquiler().getSelectedRow());
			
			if (contratoService.getEstadoOf(contrato)!=EstadoContrato.DEFINITIVO){
				 JOptionPane.showMessageDialog(null, "Solo se pueden cancelar contratos definitivos");
				return;
			}
			ContratoAlquiler seleccion = (contrato);
			contratoService.cancelarContrato(seleccion);
			fillTableContratosAlquiler();
		}
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
	
	private void editarContrato() {
		int select = this.view.getTablaContratoAlquiler().getSelectedRow();

		if (select!=-1){
			ContratoAlquiler contrato =  (ContratoAlquiler) this.contratosTable2.getRow(select);
			
			if (contratoService.getEstadoOf(contrato)!=EstadoContrato.BORRADOR){
				 JOptionPane.showMessageDialog(null, "Solo se pueden editar contratos en borrador");
				return;
			}
			
			contratoAlqController.editarContrato(contrato);
			contratoAlqController.showView();
			
			this.fillTableContratosAlquiler();
		}
	}
	
	private void aplicarFiltroAlq() {
		alquilerfiltro.setModeNew();
		alquilerfiltro.showView();
		
		currentAlqFiltro = alquilerfiltro.getFiltro();
		
		fillTableContratosAlquiler();
	}
	
	private void removerFiltroAlq() {
		currentAlqFiltro = null;
		fillTableContratosAlquiler();
	}
	
	private void fillTableContratosAlquiler() {
		
		this.contratosTable2.clean();
		this.view.getTablaContratoAlquiler().setModel(contratosTable2);
		if(currentAlqFiltro == null)contratoService.getContratosAlquiler().forEach(c -> contratosTable2.addRow(c));
		else contratoService.getcontratosAlquilerBy(currentAlqFiltro).forEach(c -> contratosTable2.addRow(c));
		
		this.view.getTablaContratoAlquiler().setColumnModel(contratosTable2.getTableColumnModel());
		this.view.getTablaContratoAlquiler().getTableHeader().setReorderingAllowed(false);
	}	
	
	private void fillTableContratosVenta() {
		
		this.contratosTable.clean();
		this.view.getTablaContratoVenta().setModel(contratosTable);
		contratoService.getContratosVenta().forEach(c -> contratosTable.addRow(c));
		
		this.view.getTablaContratoVenta().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoVenta().getTableHeader().setReorderingAllowed(false);
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actualize() {
		fillTableContratosAlquiler();
		fillTableContratosVenta();
	}
}
