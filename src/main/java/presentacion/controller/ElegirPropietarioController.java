package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Propietario;
import model.PropietarioService;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.ElegirPropietarioView;

public class ElegirPropietarioController{
	
	private ElegirPropietarioView view;
	private PropietarioService propietarioService;
	private PropietariosTableModel tableModelProp;
	PropietarioController propietarioController;
	
	@Inject
	private ElegirPropietarioController(ElegirPropietarioView view,
										PropietarioService propietarioService,
										PropietarioController propietarioController){
		
		this.view = view;
		this.propietarioService = propietarioService;
		this.tableModelProp = new PropietariosTableModel();
		this.propietarioController = propietarioController;
		fillTableProp();
		
		this.view.getBtnAgregarOtro().addActionListener(e -> agregarOtroPropietario());
		
	}
	private void agregarOtroPropietario() {
		propietarioController.setModeNew();
		propietarioController.showView();
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
		fillTableProp();
		view.setVisible(true);
	}

	public Propietario getPropietario(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return tableModelProp.getRow(selected);
	}

}
