package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.ContratoService;
import presentacion.controller.ContratoVentaController;
import presentacion.main.vista.ContratosVentaTab;
import presentacion.table.ContratosTableModel;

@Singleton
public class ContratosVentaTabController {

	private ContratosVentaTab view;

	@Inject private ContratoVentaController contratoVenController;
	@Inject private ContratosTableModel contratosTable;	

	@Inject private ContratoService contratoService;

	@Inject
	private ContratosVentaTabController(ContratosVentaTab view) {
		
		this.view = view;
		this.view.getBtnAgregarContratoVen().addActionListener(e -> agregarContratoVen());
	}
	
	private void agregarContratoVen() {
		this.contratoVenController.setModeNew();
		this.contratoVenController.showView();
		fillTableContratosVenta();
	}
	
	protected void fillTableContratosVenta() {
		
		this.contratosTable.clean();
		this.view.getTablaContratoVenta().setModel(contratosTable);
		contratoService.getContratosVenta().forEach(c -> contratosTable.addRow(c));
		
		this.view.getTablaContratoVenta().setColumnModel(contratosTable.getTableColumnModel());
		this.view.getTablaContratoVenta().getTableHeader().setReorderingAllowed(false);
	}
	
}
