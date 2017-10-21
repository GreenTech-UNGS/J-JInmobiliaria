package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.InmobiliariaService;
import presentacion.controller.InmobiliariaController;
import presentacion.main.vista.InmobiliariaPanel;
import presentacion.table.InmobiliariaTableModel;

@Singleton
public class InmobiliariaPanelController {

	private InmobiliariaPanel view;
	@Inject private InmobiliariaController inmobiliariaController;
	@Inject private InmobiliariaTableModel tableInmobiliaria;
	@Inject private InmobiliariaService inmobiliariaService;
	
	@Inject
	InmobiliariaPanelController(InmobiliariaPanel view) {
		
		this.view = view;
		
		this.view.getBtnAgregarInmobiliaria().addActionListener(e -> agregarInmobiliaria());
		this.view.getBtnEditarInmobiliaria().addActionListener(e -> editarInmobiliaria());
		
	}
	
		private void agregarInmobiliaria() {
		this.inmobiliariaController.setModeNew();
		this.inmobiliariaController.showView();
		fillTableInmobiliarias();
	}
		
	private void editarInmobiliaria() {
		int seleccion = this.view.getTableInmobiliaria().getSelectedRow();
		
		if (seleccion !=-1){
			inmobiliariaController.editInmobiliaria(this.tableInmobiliaria.getRow(seleccion));
			inmobiliariaController.showView();
			fillTableInmobiliarias();
		}
	}	
	
	private void fillTableInmobiliarias(){
		this.tableInmobiliaria.clean();
		this.view.getTableInmobiliaria().setModel(tableInmobiliaria);
		
		inmobiliariaService.getAll().forEach(e -> tableInmobiliaria.addRow(e));
		this.view.getTableInmobiliaria().getTableHeader().setReorderingAllowed(false);
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void showView() {
		
		this.view.setVisible(true);
		
	}

	public void actualize() {
		fillTableInmobiliarias();
	}
}
