package presentacion.controller;

import com.google.inject.Inject;

import entities.Propietario;
import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.Telefono;
import misc.Binder;
import model.PropietarioService;
import model.PersonaService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.table.TelefonoTableModel;
import presentacion.validators.PropietarioValidator;
import presentacion.vista.AgregarPropietario;

public class AddPropietarioController {
	
	private AgregarPropietario view;
	PersonaService personaService;
	private PropietarioService propietarioService;
	
	@Inject
	private PropietarioValidator propietarioValidator;
	
	@Inject
	
	private TipoCredencialComboBoxModel tipoCredencialModel;
	private TelefonoTableModel telTable;
	
	private AddTelefonoController telefonoController;
	private ElegirPersonaController elegirPersona;
	private Propietario currentPropietario;
	private Binder<Propietario> binder;
	
	@Inject
	private AddPropietarioController(AgregarPropietario view,
								 PropietarioService propietarioService,
								 PersonaService personaService,
								 AddTelefonoController telefonoController,
								 ElegirPersonaController elegirPersona){
		
		this.view = view;
		this.propietarioService = propietarioService;
		this.telefonoController = telefonoController;
		this.personaService = personaService;
		this.elegirPersona = elegirPersona;
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		this.telTable = new TelefonoTableModel();
		this.binder = new Binder<Propietario>();
		
		view.getBtnGuardar().addActionListener(e -> saveCurrentPropietario());
		view.getBtnCancelar().addActionListener(e -> closeView());
		view.getBtnBuscar().addActionListener(e -> eligePersona());
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardarCambios().addActionListener(e -> actualizarPropietario());
		
		
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
		currentPropietario = propietarioService.getEmptyPropietario();
		binder.setObjective(currentPropietario);
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
		telTable.clean();
		if(currentPropietario != null) {
			telTable.addRows(personaService.getAllTelefonosOf(currentPropietario.getPersona()));			
		}
		
		view.getTableTelefono().setModel(telTable);
		this.view.getTableTelefono().setColumnModel(telTable.getTableColumnModel());
		this.view.getTableTelefono().getTableHeader().setReorderingAllowed(false);
	}
	
	private void saveCurrentPropietario() {
		binder.fillBean();

		if(propietarioValidator.isValid(currentPropietario)) {
			propietarioService.savePropietario(currentPropietario);
			view.setVisible(false);
		}
	}
	
	private void actualizarPropietario() {
		binder.fillBean();
		view.setVisible(false);
	}
	
	private void agregaTelefono() {
		telefonoController.setModeNew();
		telefonoController.showView();
		
		Telefono nuevoTel = telefonoController.getTelefono();
				
		if(telefonoController.getTelefonoValidator().isValid(nuevoTel)) {
			telTable.addRow(nuevoTel);
			currentPropietario.getPersona().insertTelefono(nuevoTel);
		}
	}
	
	private void eligePersona() {
		
		elegirPersona.showView();
		Persona p = elegirPersona.getPersona();
		
		if(p != null) {
			currentPropietario = propietarioService.getNewPropietarioFrom(p);
			binder.setObjective(currentPropietario);
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
	public void editarPropietario(Propietario c){
		fillTables();
		view.setTitle("Editar propietario");
		view.getBtnGuardar().setVisible(false);
		view.getBtnCancelar().setVisible(false);
		view.getBtnGuardarCambios().setVisible(true);
		fillCombos();
		
		currentPropietario = c;
		binder.setObjective(currentPropietario);
		binder.fillFields();
	}

	public void showView(){
		fillTables();
		view.setVisible(true);
	}
	
	public void closeView() {
		view.setVisible(false);
	}
}
