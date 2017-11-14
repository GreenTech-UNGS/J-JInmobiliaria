package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.InmobiliariaFiltro;
import filtros.UsuarioFiltro;
import model.InmobiliariaService;
import presentacion.controller.InmobiliariaController;
import presentacion.controller.filtros.InmobiliariaFiltroController;
import presentacion.main.vista.InmobiliariaPanel;
import presentacion.table.InmobiliariaTableModel;

@Singleton
public class InmobiliariaPanelController {

	private InmobiliariaPanel view;
	@Inject private InmobiliariaController inmobiliariaController;
	@Inject private InmobiliariaTableModel tableInmobiliaria;
	@Inject private InmobiliariaService inmobiliariaService;
	@Inject private InmobiliariaFiltroController inmobiliariaFiltro;
	
	@Inject
	InmobiliariaPanelController(InmobiliariaPanel view) {
		
		this.view = view;
		
		this.view.getBtnAgregarInmobiliaria().addActionListener(e -> agregarInmobiliaria());
		this.view.getBtnEditarInmobiliaria().addActionListener(e -> editarInmobiliaria());
		
		this.view.getBtnAplicarFiltro().addActionListener(e -> aplicarFiltro());
		this.view.getBtnRemoverFiltro().addActionListener(e -> removerFiltro());
		
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
	
	private void aplicarFiltro() {
		inmobiliariaFiltro.setModeNew();
		inmobiliariaFiltro.showView();
		
		InmobiliariaFiltro filtro = inmobiliariaFiltro.getFiltro();
		if(filtro != null) {
			tableInmobiliaria.actualizeRows(inmobiliariaService.getAllByFiltro(filtro));
		}
		
	}
	
	private void removerFiltro(){
		fillTableInmobiliarias();
	}
}
