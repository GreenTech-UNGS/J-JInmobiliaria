package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.ClienteFiltro;
import filtros.PropietarioFiltro;
import model.ClienteService;
import model.PropietarioService;
import model.UsuarioService;
import presentacion.controller.ClienteController;
import presentacion.controller.PropietarioController;
import presentacion.controller.UsuarioController;
import presentacion.controller.filtros.ClienteFiltroController;
import presentacion.controller.filtros.PropietarioFiltroController;
import presentacion.main.vista.PersonasPanel;
import presentacion.table.ClientesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.table.UsuariosTableModel;

@Singleton
public class PersonasPanelController {
	
	private PersonasPanel view;
	
	@Inject private ClienteController clienteController;
	@Inject private PropietarioController propietarioController;	
	@Inject private ClienteFiltroController clienteFiltro;
	@Inject private PropietarioFiltroController propietarioFiltro;
	@Inject private UsuarioController usuarioController;
	
	@Inject private ClienteService clienteService;
	@Inject private PropietarioService propietarioService;
	@Inject private UsuarioService usuarioService;

	@Inject private ClientesTableModel tableModelClien;
	@Inject private PropietariosTableModel propietariosTable;
	@Inject private UsuariosTableModel usuariosTable;
	
	@Inject
	PersonasPanelController(PersonasPanel view) {
		
		this.view = view;
		
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		this.view.getBtnEditarCliente().addActionListener(e -> editarCliente());
		this.view.getBtnAgregarPropietario().addActionListener(e -> agregarPropietario());
		this.view.getBtnEditarPropietario().addActionListener(e -> editarPropietario());
		this.view.getBtnAplicarFiltroClientes().addActionListener(e -> aplicarFiltroCliente());
		this.view.getBtnRemoverFiltroClientes().addActionListener(e  -> removerFiltroCliente());
		this.view.getBtnAplicarFiltroPropietarios().addActionListener(e -> aplicarFiltroPropietario());
		this.view.getBtnRemoverFiltroPropietarios().addActionListener(e  -> removerFiltroPropietario());
		this.view.getBtnAgregarUsuario().addActionListener(e -> agregarUsuario());
		
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
	
	private void agregarUsuario() {
		this.usuarioController.setModeNew();
		this.usuarioController.showView();
		
		fillTableUsuarios();
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
	
	private void fillTableUsuarios(){
		this.usuariosTable.clean();
		this.view.getTableUsuarios().setModel(usuariosTable);
		usuariosTable.actualizeRows(usuarioService.getAll());
		
		this.view.getTableUsuarios().setColumnModel(usuariosTable.getTableColumnModel());
		this.view.getTableUsuarios().getTableHeader().setReorderingAllowed(false);
	}

	public void showView() {
		
		this.view.setVisible(true);
		fillTableUsuarios();
		
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actualize() {
		
		fillTableClientes();
		fillTablePropietarios();
		fillTableUsuarios();
	}
}
