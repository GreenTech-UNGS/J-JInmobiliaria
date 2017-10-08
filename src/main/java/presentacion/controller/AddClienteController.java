package presentacion.controller;

import javax.swing.JOptionPane;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.Telefono;
import misc.Binder;
import model.ClienteService;
import model.PersonaService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.table.TelefonoTableModel;
import presentacion.validators.ClienteValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.AgregarCliente;

public class AddClienteController {
	
	private AgregarCliente view;
	PersonaService personaService;
	private ClienteService clienteService;
	
	@Inject
	private ClienteValidator clienteValidator;
	
	@Inject
	private MessageShow msgShow;
	
	private TipoCredencialComboBoxModel tipoCredencialModel;
	private TelefonoTableModel telTable;
	
	private AddTelefonoController telefonoController;
	private ElegirPersonaController elegirPersona;
	private Cliente currentCliente;
	private Binder<Cliente> binder;
	
	@Inject
	private AddClienteController(AgregarCliente view,
								 ClienteService clienteService,
								 PersonaService personaService,
								 AddTelefonoController telefonoController,
								 ElegirPersonaController elegirPersona){
		
		this.view = view;
		this.clienteService = clienteService;
		this.telefonoController = telefonoController;
		this.personaService = personaService;
		this.elegirPersona = elegirPersona;
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		this.telTable = new TelefonoTableModel();
		this.binder = new Binder<Cliente>();
		
		view.getBtnGuardar().addActionListener(e -> saveCurrentCliente());
		view.getBtnCancelar().addActionListener(e -> closeView());
		view.getBtnBuscar().addActionListener(e -> eligePersona());
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardarCambios().addActionListener(e -> actualizarCliente());
		
		
		binder.bind("persona.nombre",
				view.getTextNombre()::getText,
				s -> view.getTextNombre().setText((String)s));
		binder.bind("persona.apellido",
				view.getTextApellido()::getText,
				s -> view.getTextApellido().setText((String)s));
		binder.bind("persona.credencial",
				() -> view.getTextCredencial().getText().replaceAll("\\.", "").replaceAll("-", ""),
				s -> view.getTextCredencial().setText((String)s));
		binder.bind("persona.email",
				view.getTextMail()::getText,
				s -> view.getTextMail().setText((String)s));
				
		binder.bind("persona.tipoCred",
				tipoCredencialModel::getSelected,
				t -> tipoCredencialModel.setSelected((TipoCredencial)t));
		
		fillCombos();
		fillTables();
		
	}

	public void setModeNew() {
		currentCliente = clienteService.getEmptyCliente();
		binder.setObjective(currentCliente);
		binder.fillFields();
		telTable.clean();
		
		setEditCampos(true);
	}
	
	private void fillCombos() {
		tipoCredencialModel.agregaElemento(TipoCredencial.DNI);
		tipoCredencialModel.agregaElemento(TipoCredencial.CUIT);
		tipoCredencialModel.setSelected(TipoCredencial.DNI);
		view.getComboCredencial().setModel(tipoCredencialModel);
	}
	
	private void fillTables() {
		if(currentCliente != null) {
			telTable.addRows(personaService.getAllTelefonosOf(currentCliente.getPersona()));
			
		}
		view.getTableTelefono().setModel(telTable);
		this.view.getTableTelefono().setColumnModel(telTable.getTableColumnModel());
		this.view.getTableTelefono().getTableHeader().setReorderingAllowed(false);
	}
	
	private void saveCurrentCliente() {
		binder.fillBean();

		if(clienteValidator.isValid(currentCliente)) {
			clienteService.saveCliente(currentCliente);
			view.setVisible(false);
		}
	}
	
	private void actualizarCliente() {
		binder.fillBean();
		clienteService.actualizarCliente(currentCliente);
		view.setVisible(false);
	}
	
	private boolean fieldsOk(){
		//Esto tendría que hacerlo el validador
		boolean emptys = view.getTextCredencial().getText().isEmpty();
		emptys |= view.getTextNombre().getText().isEmpty();
		emptys |= view.getTextApellido().getText().isEmpty();
		emptys |= view.getTextMail().getText().isEmpty();
		
		if(emptys){
			JOptionPane.showMessageDialog(view, "Hay campos obligatorios que estan vacios",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;}
		return true;}
	
	private void agregaTelefono() {
		telefonoController.setModeNew();
		telefonoController.showView();
		
		Telefono nuevoTel = telefonoController.getTelefono();
				
		if(telefonoController.getTelefonoValidator().isValid(nuevoTel)) {
			telTable.addRow(nuevoTel);
			currentCliente.getPersona().insertTelefono(nuevoTel);
		}
	}
	
	private void eligePersona() {
		
		elegirPersona.showView();
		Persona p = elegirPersona.getPersona();
		
		if(p != null) {
			currentCliente = clienteService.getNewClienteFrom(p);
			binder.setObjective(currentCliente);
			binder.fillFields();
			
			setEditCampos(false);
			
		}	
	}
	
	private void setEditCampos(boolean b) {
		
		view.getTextCredencial().setEditable(b);
		view.getTextApellido().setEditable(b);
		view.getTextNombre().setEditable(b);
		view.getTextMail().setEditable(b);
		view.getComboCredencial().setEnabled(b);
		
		view.getBtnAgregarTelefono().setEnabled(b);
		view.getBtnBorrarTelefono().setEnabled(b);
		
	}
	
	private void borrarTelefono() {
		int[] seleccionadas = this.view.getTableTelefono().getSelectedRows();
		
		for (int fila : seleccionadas){
			telTable.removeRow(fila);
			
		}
	}
	public void editarCliente(Cliente c){
		view.setTitle("Editar cliente");
		view.getBtnGuardar().setVisible(false);
		view.getBtnCancelar().setVisible(false);
		view.getBtnGuardarCambios().setVisible(true);
		fillCombos();
		
		currentCliente = c;
		binder.setObjective(currentCliente);
		binder.fillFields();
	}

	public void showView(){
			
		view.setVisible(true);
	}
	
	public void closeView() {
		view.setVisible(false);
	}
}
