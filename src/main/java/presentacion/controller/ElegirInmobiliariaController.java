package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Inmobiliaria;
import model.InmobiliariaService;
import presentacion.table.InmobiliariaTableModel;
import presentacion.vista.ElegirInmobiliaria;

public class ElegirInmobiliariaController {
	private ElegirInmobiliaria view;
	private InmobiliariaService inmobiliariaService;
	private InmobiliariaTableModel inmobiliariaTable;
	
	@Inject
	public ElegirInmobiliariaController(ElegirInmobiliaria view, InmobiliariaService inmobiliariaService){
		
		this.view = view;
		this.inmobiliariaService = inmobiliariaService;
		this.inmobiliariaTable = new InmobiliariaTableModel();
		fillTableInmobiliaria();
	}

	private void fillTableInmobiliaria() {
		
		this.view.getTable().setModel(inmobiliariaTable);
		this.view.getTable().setColumnModel(inmobiliariaTable.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.inmobiliariaTable.clean();
		inmobiliariaTable.actualizeRows(inmobiliariaService.getAll());
		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
		
	}
	
	public void showView(){
		
		view.setVisible(true);
	}
	
	public Inmobiliaria getInmobiliaria(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return inmobiliariaTable.getRow(selected);
	}

}
