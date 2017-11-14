package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.ClienteFiltro;
import filtros.InteresadoFiltro;
import filtros.PropietarioFiltro;
import filtros.UsuarioFiltro;
import model.ClienteService;
import model.InteresadoService;
import model.PropietarioService;
import model.UsuarioService;
import presentacion.controller.ClienteController;
import presentacion.controller.InteresadoController;
import presentacion.controller.PropietarioController;
import presentacion.controller.UsuarioController;
import presentacion.controller.filtros.ClienteFiltroController;
import presentacion.controller.filtros.InteresadoFiltroController;
import presentacion.controller.filtros.PropietarioFiltroController;
import presentacion.controller.filtros.UsuarioFiltroController;
import presentacion.main.vista.PersonasPanel;
import presentacion.table.ClientesTableModel;
import presentacion.table.InteresadosTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.table.UsuariosTableModel;

@Singleton
public class PersonasPanelController {
	
	private PersonasPanel view;
	
	@Inject private ClienteController clienteController;
	@Inject private PropietarioController propietarioController;	
	@Inject private ClienteFiltroController clienteFiltro;
	@Inject private PropietarioFiltroController propietarioFiltro;
	@Inject private UsuarioFiltroController usuarioFiltro;
	@Inject private InteresadoFiltroController interesadoFiltro;
	@Inject private UsuarioController usuarioController;
	@Inject private InteresadoController interesadoController;
	
	@Inject private ClienteService clienteService;
	@Inject private PropietarioService propietarioService;
	@Inject private UsuarioService usuarioService;
	@Inject private InteresadoService interesadoService;

	@Inject private ClientesTableModel tableModelClien;
	@Inject private PropietariosTableModel propietariosTable;
	@Inject private UsuariosTableModel usuariosTable;
	@Inject private InteresadosTableModel interesadosTable;
	
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
		this.view.getBtnEditarUsuario().addActionListener(e -> editarUsuario());
		this.view.getBtnHabilitar().addActionListener(e -> habilitarUsuario());
		this.view.getBtnDeshabilitar().addActionListener(e -> deshabilitarUsuario());
		this.view.getBtnAgregarInteresado().addActionListener(e -> agregarInteresado());
		this.view.getBtnEditarInteresado().addActionListener(e -> editarInteresado());
		this.view.getBtnAplicarFiltroUsuarios().addActionListener(e -> aplicarFiltroUsuario());
		this.view.getBtnRemoverFiltroUsuarios().addActionListener(e -> removerFiltroUsuarios());
		this.view.getBtnAplicarFiltroInteresados().addActionListener(e -> aplicarFiltroInteresado());
		this.view.getBtnRemoverFiltroInteresados().addActionListener(e -> removerFiltroInteresados());
		
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
	
	private void editarInteresado() {
		int select = this.view.getTableInteresados().getSelectedRow();
		
		if (select!=-1){
			interesadoController.editarInteresado(this.interesadosTable.getRow(select));
			interesadoController.showView();
			this.fillTableInteresados();
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
	
	
	private void editarUsuario() {
		
		int select = this.view.getTableUsuarios().getSelectedRow();
		
		if (select != -1){ 
			usuarioController.editUsuario(this.usuariosTable.getRow(select));
			usuarioController.showView();
			this.fillTableUsuarios();
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
	

	private void agregarInteresado() {
		this.interesadoController.setModeNew();
		this.interesadoController.showView();
		fillTableInteresados();
	}

	
	private void aplicarFiltroCliente() {
		clienteFiltro.setModeNew();
		clienteFiltro.showView();
		
		ClienteFiltro filtro = clienteFiltro.getFiltro();
		if(filtro != null) {
			tableModelClien.actualizeRows(clienteService.getAllByFiltro(filtro));
		}
		
	}
	
	private void aplicarFiltroUsuario() {
		usuarioFiltro.setModeNew();
		usuarioFiltro.showView();
		
		UsuarioFiltro filtro = usuarioFiltro.getFiltro();
		if(filtro != null) {
			usuariosTable.actualizeRows(usuarioService.getAllByFiltro(filtro));
		}
		
	}
	
	private void aplicarFiltroInteresado() {
		interesadoFiltro.setModeNew();
		interesadoFiltro.showView();
		
		InteresadoFiltro filtro = interesadoFiltro.getFiltro();
		if(filtro != null) {
			interesadosTable.actualizeRows(interesadoService.getAllByFiltro(filtro));
		}
		
	}
	
	private void removerFiltroUsuarios(){
		fillTableUsuarios();
	}
	
	private void removerFiltroCliente() {
		fillTableClientes();
	}
	
	private void removerFiltroInteresados(){
		fillTableInteresados();
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
	
	private void fillTableInteresados(){
		this.interesadosTable.clean();
		this.view.getTableInteresados().setModel(interesadosTable);
		interesadosTable.actualizeRows(interesadoService.getAll());
		
		this.view.getTableInteresados().setColumnModel(interesadosTable.getTableColumnModel());
		this.view.getTableInteresados().getTableHeader().setReorderingAllowed(false);
	}

	public void showView() {
		
		this.view.setVisible(true);
		fillTableUsuarios();
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actualize() {
		
		fillTableUsuarios();
		fillTableClientes();
		fillTablePropietarios();
		fillTableInteresados();
	}
	
	private void habilitarUsuario() {
		
		int select = this.view.getTableUsuarios().getSelectedRow();
		
		if (select != -1){ 
			usuarioService.habilitarUsuario(this.usuariosTable.getRow(select));
			this.fillTableUsuarios();
		}
	}
	
	private void deshabilitarUsuario() {
		
		int select = this.view.getTableUsuarios().getSelectedRow();
		
		if (select != -1){ 
			usuarioService.deshabilitarUsuario(this.usuariosTable.getRow(select));
			this.fillTableUsuarios();
		}
	}
}
