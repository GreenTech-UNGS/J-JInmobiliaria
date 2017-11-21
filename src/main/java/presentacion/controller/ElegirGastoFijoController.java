package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.GastoFijo;
import model.GastoFijoService;
import presentacion.table.GastoFijoTableModel;
import presentacion.vista.ElegirGastoFijoView;

@Singleton
public class ElegirGastoFijoController {
	
	private ElegirGastoFijoView view;
	@Inject private GastoFijoService gastoFijoService;
	private GastoFijoTableModel tableModel;
	
	private boolean okPressed;
	
	@Inject
	private ElegirGastoFijoController(ElegirGastoFijoView view) {
		
		this.view = view;
		okPressed = false;
		
		this.view.getBtnAceptar().addActionListener(e -> ok());
		
		tableModel = new GastoFijoTableModel();
		this.view.getTable().setModel(tableModel);
		this.view.getTable().setColumnModel(tableModel.getTableColumnModel());
		
	}
	
	private void ok() {
		okPressed = true;
		fillTable();
		view.setVisible(false);
	}

	private void fillTable() {
		
		this.tableModel.clean();
		this.tableModel.actualizeRows(gastoFijoService.getAll());
		
	}

	public void showView(){
		okPressed = false;
		
		view.setVisible(true);
	}
	
	public GastoFijo getGastoFijo(){
		if(!okPressed)
			return null;
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected >= 0)
			return tableModel.getRow(selected);
		
		return null;
	}

}
