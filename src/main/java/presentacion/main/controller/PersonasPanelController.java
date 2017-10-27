package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.ClienteFiltro;
import filtros.PropietarioFiltro;
import model.ClienteService;
import model.PropietarioService;
import presentacion.controller.ClienteController;
import presentacion.controller.PropietarioController;
import presentacion.controller.filtros.ClienteFiltroController;
import presentacion.controller.filtros.PropietarioFiltroController;
import presentacion.main.vista.InquilinosPanel;
import presentacion.table.ClientesTableModel;
import presentacion.table.PropietariosTableModel;

@Singleton
public class PersonasPanelController {
	
	private InquilinosPanel view;
	
	@Inject private ClienteController clienteController;
	@Inject private PropietarioController propietarioController;	
	@Inject private ClienteFiltroController clienteFiltro;
	@Inject private PropietarioFiltroController propietarioFiltro;
	
	@Inject private ClienteService clienteService;
	@Inject private PropietarioService propietarioService;

	@Inject private ClientesTableModel tableModelClien;
	@Inject private PropietariosTableModel propietariosTable;
	
	@Inject
	PersonasPanelController(InquilinosPanel view) {
		
		this.view = view;
		
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		this.view.getBtnEditarCliente().addActionListener(e -> editarCliente());
		this.view.getBtnAgregarPropietario().addActionListener(e -> agregarPropietario());
		this.view.getBtnEditarPropietario().addActionListener(e -> editarPropietario());
		this.view.getBtnAplicarFiltroClientes().addActionListener(e -> aplicarFiltroCliente());
		this.view.getBtnRemoverFiltroClientes().addActionListener(e  -> removerFiltroCliente());
		this.view.getBtnAplicarFiltroPropietarios().addActionListener(e -> aplicarFiltroPropietario());
		this.view.getBtnRemoverFiltroPropietarios().addActionListener(e  -> removerFiltroPropietario());
		
	}
		
	private void agregarCliente() {
		this.clienteController.setModeNew();
		this.clienteController.showView();

		fillTableClientes();
	}
	
	private void editarCliente() {
		int select = this.view.getTableClientes().getSelectedRow();
		
		if (select!=-1){
			clienteController.editarCliente(this.tableModelClien.getRow(select));
			clienteController.showView();
			this.fillTableClientes();
		}
	}
	
	private void editarPropietario() {
		int select = this.view.getTablePropietarios().getSelectedRow();
		
		if (select != -1){ 
			propietarioController.editarPropietario(this.propietariosTable.getRow(select));
			propietarioController.showView();
			this.fillTablePropietarios();
		}
	}
	
	private void agregarPropietario() {
		this.propietarioController.setModeNew();
		this.propietarioController.showView();

		fillTablePropietarios();
	}
	
	private void aplicarFiltroCliente() {
		clienteFiltro.setModeNew();
		clienteFiltro.showView();
		
		ClienteFiltro filtro = clienteFiltro.getFiltro();
		if(filtro != null) {
			tableModelClien.actualizeRows(clienteService.getAllByFiltro(filtro));
		}
		
	}
	
	private void removerFiltroCliente() {
		fillTableClientes();
	}
	
	private void aplicarFiltroPropietario() {
		propietarioFiltro.setModeNew();
		propietarioFiltro.showView();
		
		PropietarioFiltro filtro = propietarioFiltro.getFiltro();
		if(filtro != null) {
			propietariosTable.actualizeRows(propietarioService.getAllByFiltro(filtro));
		}
		
	}
	
	private void removerFiltroPropietario() {
		fillTablePropietarios();
	}
	
	private void fillTableClientes() {
		
		this.tableModelClien.clean();
		this.view.getTableClientes().setModel(tableModelClien);
		tableModelClien.actualizeRows(clienteService.getAll());
		
		this.view.getTableClientes().setColumnModel(tableModelClien.getTableColumnModel());
		this.view.getTableClientes().getTableHeader().setReorderingAllowed(false);
	}	
	
	private void fillTablePropietarios() {
		this.propietariosTable.clean();
		this.view.getTablePropietarios().setModel(propietariosTable);
		propietariosTable.actualizeRows(propietarioService.getAll());
		
		this.view.getTablePropietarios().setColumnModel(propietariosTable.getTableColumnModel());
		this.view.getTablePropietarios().getTableHeader().setReorderingAllowed(false);
	}

	public void showView() {
		
		this.view.setVisible(true);
		
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actualize() {
		
		fillTableClientes();
		fillTablePropietarios();
	}
}
