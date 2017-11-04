package presentacion.main.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import model.CitaService;
import net.sf.jasperreports.components.table.fill.FillTable;
import presentacion.controller.CitaController;
import presentacion.main.vista.CitasPanel;
import presentacion.table.CitasTableModel;
import presentacion.validators.MessageShow;

@Singleton
public class CitasPanelController {

	private CitasPanel view;
	@Inject private CitaController citaController;
	@Inject private CitaService citaService;
	
	@Inject private MessageShow msgShw;
	
	private CitasTableModel tableModel;
	
	@Inject
	private CitasPanelController(CitasPanel view){
		
		this.view = view;
		
		this.view.getBtnNueva().addActionListener(e -> agregarCita());
		this.view.getBtnCancelarCita().addActionListener(e -> cancelarCita());
		
		this.tableModel = new CitasTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().setColumnModel(tableModel.getTableColumnModel());
		view.getTable().getTableHeader().setReorderingAllowed(false);
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void agregarCita() {
		this.citaController.setModeNew();
		this.citaController.showView();
		actualize();
	}
	
	private void cancelarCita() {
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected >= 0 && 
				msgShw.showYesNoMessage("¿Quiere cancelar la cita?", "Cancelar cita")) {
			
			Cita selectedCita = tableModel.getRow(selected);
			citaService.cancelarCita(selectedCita);
			
		}
		
	}

	public void showView(){
		this.view.setVisible(true);
	}
	
	public void actualize() {
		fillTable();
		
	}

	public void hideView() {
		this.view.setVisible(false);
		
	}
	
	private void fillTable() {
		
		tableModel.clean();
		tableModel.actualizeRows(citaService.getProximas());
		
	}
	
}
