package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.CitaService;
import model.ContratoService;
import model.CuotaService;
import presentacion.main.vista.EscritorioPanel;
import presentacion.table.CitasTableModel;
import presentacion.table.ContratosTableModel;
import presentacion.table.CuotasTableModel;

@Singleton
public class EscritorioPanelController {
	
	private EscritorioPanel view;
	
	private CitasTableModel citaTableModel;
	@Inject private CitaService citaService;
	private ContratosTableModel contratosTableModel;
	@Inject private ContratoService contratoService;
	private CuotasTableModel cuotasMesTableModel;
	@Inject CuotaService cuotaService;
	private CuotasTableModel cuotasVencidasTableModel;
	
	@Inject
	private EscritorioPanelController(EscritorioPanel view){
		this.view = view;
		citaTableModel = new CitasTableModel();
		contratosTableModel = new ContratosTableModel();
		cuotasMesTableModel = new CuotasTableModel(cuotaService);
		cuotasVencidasTableModel = new CuotasTableModel(cuotaService);
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}
	
	private void fillTables(){
		fillTableCitas();
		fillTableContratos();
		fillTableCuotasMes();
		fillTableCuotasVencidas();
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
	
	private void fillTableCuotasMes(){
		this.cuotasMesTableModel.clean();
		this.view.getTableCuotasMes().setModel(cuotasMesTableModel);
		
		cuotaService.getAllOfNow().forEach(e -> cuotasMesTableModel.addRow(e));
		this.view.getTableCuotasMes().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableCuotasVencidas(){
		this.cuotasVencidasTableModel.clean();
		this.view.getTableCuotasVencidas().setModel(cuotasVencidasTableModel);
		
		cuotaService.getVencidas().forEach(e -> cuotasVencidasTableModel.addRow(e));
		this.view.getTableCuotasVencidas().getTableHeader().setReorderingAllowed(false);
	}
	
	public void actualize() {
		fillTables();
		
	}
}
