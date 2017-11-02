package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Localidad;
import entities.Provincia;
import entities.Telefono;
import entities.TipoOfrecimiento;
import entities.Persona.TipoCredencial;
import model.InteresadoService;
import model.LocalidadService;
import model.LogicaNegocioException;
import model.PersonaService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
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
	private TipoCredencialComboBoxModel tipoCredencialModel;
	@Inject private InteresadoFormMapper interesadoMapper;
	@Inject private InteresadoFormValidator interesadoValidator;
	@Inject private MessageShow msgShw;
	@Inject private LocalidadService localidadService;
	
	private TipoOfrecimientoComboBoxModel tipoOfrCombo;
	private ProvinciaComboBoxModel provCombo;
	private Interesado currentInteresado;
	private TelefonoTableModel telTable;
	private LocalidadComboBoxModel localidadModel;
	@Inject private TelefonoController telefonoController;
	
	@Inject	
	private InteresadoController(InteresadoForm view){
		this.view = view;
		this.telTable = new TelefonoTableModel();
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		this.localidadModel = new LocalidadComboBoxModel();
		this.provCombo = new ProvinciaComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardar().addActionListener(e -> saveCurrentInteresado());
		view.getBtnCancelar().addActionListener(e -> this.view.setVisible(false));
		view.getCbProvincia().addActionListener(e -> cambiaLocalidades());
		
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
//		tipoCredencialModel.agregaElemento(TipoCredencial.DNI);
//		tipoCredencialModel.agregaElemento(TipoCredencial.CUIT);
//		tipoCredencialModel.setSelected(TipoCredencial.DNI);
		
		this.view.getCbCredencial().setModel(tipoCredencialModel);
		tipoCredencialModel.actualize(Arrays.asList(TipoCredencial.values()));
		AutoCompleteDecorator.decorate(view.getCbCredencial());
		
//		view.getCbCredencial().setModel(tipoCredencialModel);
		
//		this.view.getCbProvincia().setModel(provCombo);
//		provCombo.actualize(Arrays.asList(Provincia.values()));
//		AutoCompleteDecorator.decorate(view.getCbProvincia());

		this.view.getCbTipoOfrec().setModel(tipoOfrCombo);
		tipoOfrCombo.actualize(Arrays.asList(TipoOfrecimiento.values()));

//		this.view.getCbLocalidad().setModel(localidadModel);
//		AutoCompleteDecorator.decorate(view.getCbLocalidad());

		view.getComboModelProvincia().clearAndActualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		AutoCompleteDecorator.decorate(view.getCbLocalidad());
		cambiaLocalidades();
	}
	
	private void cambiaLocalidades() {
//		localidadModel.removeAllElements();
//		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
//		localidadModel.actualize(localidades);
		
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
		
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
		fillCombos();
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
