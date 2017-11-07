package presentacion.controller;

import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.GastoFijoService;
import presentacion.table.GastoFijoTableModel;
import presentacion.vista.GastosFijoView;

@Singleton
public class GastioFijoViewController {

	private GastosFijoView view;
	
	@Inject private GastoFijoService gastoService;
	@Inject private GastoFijoController gastoController;
	
	private GastoFijoTableModel tableModel;
	
	@Inject
	private GastioFijoViewController(GastosFijoView view) {
		
		this.view = view;
		this.view.getBtnAgregar().addActionListener(e -> agregarGasto());
		
		tableModel = new GastoFijoTableModel();
		view.getTable().setModel(tableModel);
		view.getTable().getTableHeader().setReorderingAllowed(false);
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void agregarGasto() {
		gastoController.setModeNew();
		gastoController.showView();
		fillTable();
	}

	public void showView() {
		fillTable();
		
		this.view.setVisible(true);
	}
	
	private void fillTable() {
		tableModel.clean();
		tableModel.actualizeRows(gastoService.getAll());
	}
	
}
