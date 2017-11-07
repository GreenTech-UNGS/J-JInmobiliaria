package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.CartelService;
import presentacion.table.CartelesTableModel;
import presentacion.vista.CartelView;

@Singleton
public class CartelViewController {

	private CartelView view;
	
	@Inject CartelService cartelService;
	@Inject CartelController cartelcontroller;
	
	private CartelesTableModel tableModel;
	
	@Inject
	private CartelViewController(CartelView view) {
		this.view = view;
		this.view.getBtnAgregar().addActionListener(e -> agregarCartel());
		
		this.tableModel = new CartelesTableModel();
			
		view.getTable().setModel(tableModel);
		view.getTable().getTableHeader().setColumnModel(tableModel.getTableColumnModel());
		view.getTable().getTableHeader().setReorderingAllowed(false);
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void agregarCartel() {
		cartelcontroller.setModeNew();
		cartelcontroller.showView();
		
	}

	public void showView() {
		fillTables();
		
		this.view.setVisible(true);
	
	}
	
	private void fillTables() {
		this.tableModel.clean();
		this.tableModel.actualizeRows(cartelService.getAll());
	}
	
}
