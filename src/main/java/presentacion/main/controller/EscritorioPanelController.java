package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.CitaService;
import model.ContratoService;
import presentacion.main.vista.EscritorioPanel;
import presentacion.table.CitasTableModel;
import presentacion.table.ContratosTableModel;

@Singleton
public class EscritorioPanelController {
	
	private EscritorioPanel view;
	
	@Inject CitasTableModel citaTableModel;
	@Inject private CitaService citaService;
	@Inject private ContratosTableModel contratosTableModel;
	@Inject private ContratoService contratoService;
	
	@Inject
	private EscritorioPanelController(EscritorioPanel view){
		this.view = view;
	}
	
	public void showView() {
		fillTables();
		this.view.setVisible(true);
	}
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}
	
	private void fillTables(){
		fillTableCitas();
		fillTableContratos();
	}
	
	private void fillTableContratos(){
		this.contratosTableModel.clean();
		this.view.getTableContratos().setModel(contratosTableModel);
		
		contratoService.getProximosVencer().forEach(e -> contratosTableModel.addRow(e));
		this.view.getTableContratos().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableCitas(){
		this.citaTableModel.clean();
		this.view.getTableMisCitas().setModel(citaTableModel);
		
		citaService.getAllOfLogueado().forEach(e -> citaTableModel.addRow(e));
		this.view.getTableMisCitas().getTableHeader().setReorderingAllowed(false);
	}
}
