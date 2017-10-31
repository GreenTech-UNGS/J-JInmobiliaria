package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Telefono;
import entities.Persona.TipoCredencial;
import model.InteresadoService;
import model.LogicaNegocioException;
import model.PersonaService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.mappers.InteresadoFormMapper;
import presentacion.table.TelefonoTableModel;
import presentacion.validators.InteresadoFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.InteresadoForm;

@Singleton
public class InteresadoController {
	
	private InteresadoForm view;
	@Inject private PersonaService personaService;
	@Inject private InteresadoService interesadoService;
	@Inject	private TipoCredencialComboBoxModel tipoCredencialModel;
	@Inject private InteresadoFormMapper interesadoMapper;
	@Inject private InteresadoFormValidator interesadoValidator;
	@Inject private MessageShow msgShw;
	
	private Interesado currentInteresado;
	private TelefonoTableModel telTable;
	@Inject private TelefonoController telefonoController;
	
	@Inject	
	private InteresadoController(InteresadoForm view){
		this.view = view;
		this.telTable = new TelefonoTableModel();
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardar().addActionListener(e -> saveCurrentInteresado());
		view.getBtnCancelar().addActionListener(e -> this.view.setVisible(false));
		
		fillTables();
		fillCombos();
	}

	private void agregaTelefono() {
		telefonoController.setModeNew();
		telefonoController.showView();
		
		Telefono nuevoTel = telefonoController.getTelefono();		
		if(nuevoTel != null) {
			telTable.addRow(nuevoTel);
			currentInteresado.getPersona().insertTelefono(nuevoTel);
		}
	}
	
	private void borrarTelefono() {
		int[] seleccionadas = this.view.getTableTel().getSelectedRows();
		
		for (int fila : seleccionadas){
			telTable.removeRow(fila);			
		}
	}
	
	private void fillTables() {
		telTable.clean();
		if(currentInteresado != null) {
			telTable.addRows(personaService.getAllTelefonosOf(currentInteresado.getPersona()));
			
		}
		view.getTableTel().setModel(telTable);
		this.view.getTableTel().setColumnModel(telTable.getTableColumnModel());
		this.view.getTableTel().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillCombos() {
		tipoCredencialModel.agregaElemento(TipoCredencial.DNI);
		tipoCredencialModel.agregaElemento(TipoCredencial.CUIT);
		tipoCredencialModel.setSelected(TipoCredencial.DNI);
		view.getCbCredencial().setModel(tipoCredencialModel);
	}
	
	public void setModeNew() {
		currentInteresado = interesadoService.getEmptyInteresado();
		interesadoMapper.fillFields(currentInteresado);
		telTable.clean();
		
		fillTables();
		view.setTitle("Agregar interesado");
		fillCombos();
	}
	
	public void showView(){
		fillTables();
		view.setVisible(true);
	}
	
	
	private void saveCurrentInteresado() {
		if(interesadoValidator.isValid()) {
			interesadoMapper.fillBean(currentInteresado);
			try {
				interesadoService.saveInteresado(currentInteresado);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(interesadoValidator.getErrorMessage(), "Error");
		}
	}

}
