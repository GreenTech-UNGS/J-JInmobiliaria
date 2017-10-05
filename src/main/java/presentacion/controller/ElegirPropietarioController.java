package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Propietario;
import model.PropietarioService;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.ElegirPropietario;

public class ElegirPropietarioController {
	
	private ElegirPropietario view;
	private PropietarioService propietarioService;
	private PropietariosTableModel tableModelProp;
	
	@Inject
	private ElegirPropietarioController(ElegirPropietario view, PropietarioService propietarioService){
		
		this.view = view;
		this.propietarioService = propietarioService;
		this.tableModelProp = new PropietariosTableModel();
		fillTableProp();
		
	}
	private void fillTableProp() {
		
		this.view.getTable().setModel(tableModelProp);
		this.view.getTable().setColumnModel(tableModelProp.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelProp.clean();
		tableModelProp.actualizeRows(propietarioService.getAll());
		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
	}
	public void showView(){
		
		view.setVisible(true);
	}
	
	public Propietario getPropietario(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return tableModelProp.getRow(selected);
	}

}
