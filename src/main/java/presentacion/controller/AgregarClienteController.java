package presentacion.controller;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona.TipoCredencial;
import entities.Telefono;
import misc.Binder;
import model.ClienteService;
import model.PersonaService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.table.TelefonoTableModel;
import presentacion.vista.AgregarCliente;

public class AgregarClienteController {
	
	private AgregarCliente view;
	PersonaService personaService;
	private ClienteService clienteService;
	
	private TipoCredencialComboBoxModel tipoCredencialModel;
	private TelefonoTableModel telTable;
	
	private AgregaTelefonoController telefonoController;
	private Cliente currentCliente;
	private Binder<Cliente> binder;
	
	@Inject
	private AgregarClienteController(AgregarCliente view,
			ClienteService clienteService,
			PersonaService personaService,
			AgregaTelefonoController telefonoController){
		
		this.view = view;
		this.clienteService = clienteService;
		this.telefonoController = telefonoController;
		this.personaService = personaService;
		
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		this.telTable = new TelefonoTableModel();
		
		view.getBtnGuardar().addActionListener(e -> saveCurrentCliente());
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		
		this.binder = new Binder<Cliente>();
		
		binder.bind("persona.nombre", view.getTextNombre());
		binder.bind("persona.apellido", view.getTextApellido());
		binder.bind("persona.credencial", view.getTextCredencial());
		binder.bind("persona.email", view.getTextMail());
		binder.bind("persona.tipoCred",
				tipoCredencialModel::getSelected,
				t -> tipoCredencialModel.setSelected((TipoCredencial)t));
		
		fillCombos();
		fillTables();
		
	}
	
	public void setModeNew() {
		currentCliente = clienteService.getEmptyCliente();
		binder.setObjective(currentCliente);
		
		telTable.clean();
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
		System.out.println(currentCliente.getPersona().getTipoCred());
		System.out.println(tipoCredencialModel.getSelected());
		clienteService.saveCliente(currentCliente);

		view.setVisible(false);
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
	
	private void borrarTelefono() {
		int[] seleccionadas = this.view.getTableTelefono().getSelectedRows();
		
		for (int fila : seleccionadas){
			telTable.removeRow(fila);
			
		}
	}

	
	public void showView(){
			
		view.setVisible(true);
	}
	
	

}
