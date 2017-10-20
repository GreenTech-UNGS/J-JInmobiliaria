
package presentacion.controller;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.Telefono;
import model.ClienteService;
import model.PersonaService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.mappers.ClienteFormMapper;
import presentacion.table.TelefonoTableModel;
import presentacion.validators.ClienteFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.ClienteForm;

public class ClienteController {
	
	private ClienteForm view;
	PersonaService personaService;
	private ClienteService clienteService;
	
	@Inject
	private ClienteFormValidator clienteValidator;
	@Inject
	private ClienteFormMapper clienteMapper;
	
	@Inject
	private MessageShow msgShow;
	
	private TipoCredencialComboBoxModel tipoCredencialModel;
	private TelefonoTableModel telTable;
	
	private TelefonoController telefonoController;
	private ElegirPersonaController elegirPersona;
	private Cliente currentCliente;
	
	@Inject
	private ClienteController(ClienteForm view,
								 ClienteService clienteService,
								 PersonaService personaService,
								 TelefonoController telefonoController,
								 ElegirPersonaController elegirPersona){
		
		this.view = view;
		this.clienteService = clienteService;
		this.telefonoController = telefonoController;
		this.personaService = personaService;
		this.elegirPersona = elegirPersona;
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		this.telTable = new TelefonoTableModel();
		
		view.getBtnGuardar().addActionListener(e -> saveCurrentCliente());
		view.getBtnCancelar().addActionListener(e -> closeView());
		view.getBtnBuscar().addActionListener(e -> eligePersona());
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardarCambios().addActionListener(e -> saveCurrentCliente());
		
		
		fillCombos();
		fillTables();
		
	}

	public void setModeNew() {
		currentCliente = clienteService.getEmptyCliente();
		clienteMapper.fillFields(currentCliente);
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
		telTable.clean();
		if(currentCliente != null) {
			telTable.addRows(personaService.getAllTelefonosOf(currentCliente.getPersona()));
			
		}
		view.getTableTelefono().setModel(telTable);
		this.view.getTableTelefono().setColumnModel(telTable.getTableColumnModel());
		this.view.getTableTelefono().getTableHeader().setReorderingAllowed(false);
	}
	
	private void saveCurrentCliente() {
		
		if(clienteValidator.isValid()) {
			clienteMapper.fillBean(currentCliente);
			clienteService.saveCliente(currentCliente);
			view.setVisible(false);
		}
		else{
			msgShow.showErrorMessage(clienteValidator.getErrorMessage(), "Error");
		}
	}
	
	private void agregaTelefono() {
		telefonoController.setModeNew();
		telefonoController.showView();
		
		Telefono nuevoTel = telefonoController.getTelefono();
				
		if(nuevoTel != null) {
			telTable.addRow(nuevoTel);
			currentCliente.getPersona().insertTelefono(nuevoTel);
		}
	}
	
	private void eligePersona() {
		
		elegirPersona.showView();
		Persona p = elegirPersona.getPersona();
		
		if(p != null) {
			currentCliente = clienteService.getNewClienteFrom(p);
			clienteMapper.fillFields(currentCliente);
			
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
		
		currentCliente = c;
		fillCombos();
		fillTables();
		clienteMapper.fillFields(c);
	}

	public void showView(){
		fillTables();
		view.setVisible(true);
	}
	
	public void closeView() {
		view.setVisible(false);
	}
}
