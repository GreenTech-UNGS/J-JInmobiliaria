package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import model.InmobiliariaService;
import presentacion.table.InmobiliariaTableModel;
import presentacion.vista.EligeInmobiliariaView;

@Singleton
public class EligeInmobiliariaController {

	EligeInmobiliariaView view;
	InmobiliariaTableModel tableModel;
	
	InmobiliariaService inmobiliariaService;
	
	@Inject
	private EligeInmobiliariaController(EligeInmobiliariaView view,
			InmobiliariaService inmoService) {
		this.view = view;
		this.inmobiliariaService = inmoService;
		this.tableModel = new InmobiliariaTableModel();
		
		this.view.getBtnAceptar().addActionListener(e -> this.view.setVisible(false));
	}
	
	public Inmobiliaria getInmobiliaria() {
		
		int selected = this.view.getTable().getSelectedRow();
		
		if(selected == -1)
			return null;
		
		Inmobiliaria toRet = tableModel.getRow(selected);
		return toRet;
	}
	
	private void fillTable() {
		
		this.view.getTable().setModel(tableModel);
		this.view.getTable().setColumnModel(tableModel.getTableColumnModel());
		this.view.getTable().getTableHeader().setReorderingAllowed(false);
		this.view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		inmobiliariaService.getAll().forEach(i -> tableModel.addRow(i));
		
	}
	
	public void showView() {
		fillTable();
		this.view.setVisible(true);
	}
	
}
