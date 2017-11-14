package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Localidad;
import entities.Moneda;
import entities.Provincia;
import entities.Telefono;
import entities.TipoOfrecimiento;
import entities.Persona.TipoCredencial;
import model.InteresadoService;
import model.LocalidadService;
import model.LogicaNegocioException;
import model.PersonaService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
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
	private MonedaComboBoxModel monedaModel;
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
		this.monedaModel = new MonedaComboBoxModel();
		
		view.getBtnAgregarTelefono().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTelefono().addActionListener(e -> borrarTelefono());
		view.getBtnGuardar().addActionListener(e -> saveCurrentInteresado());
		view.getBtnCancelar().addActionListener(e -> this.view.setVisible(false));
		view.getCbProvincia().addActionListener(e -> cambiaLocalidades());
		view.getBtnGuardarCambios().addActionListener(e -> guardarCambiosCurrentInteresado());
	
		
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
		
		this.view.getCbCredencial().setModel(tipoCredencialModel);
		tipoCredencialModel.clearAndActualize(Arrays.asList(TipoCredencial.values()));
		AutoCompleteDecorator.decorate(view.getCbCredencial());

		this.view.getCbTipoOfrec().setModel(tipoOfrCombo);
		tipoOfrCombo.actualize(Arrays.asList(TipoOfrecimiento.values()));

		view.getComboModelProvincia().clearAndActualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		cambiaLocalidades();
	}
	
	private void cambiaLocalidades() {
		
		view.getComboModelLocalidad().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().clearAndActualize(localidades);
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
	
	private void guardarCambiosCurrentInteresado() {

		if(interesadoValidator.isValid()) {
			interesadoMapper.fillBean(currentInteresado);
			try {
				interesadoService.editInteresado(currentInteresado);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(interesadoValidator.getErrorMessage(), "Error");
		}
	}
	
	public void editarInteresado(Interesado i){
		
		view.setTitle("Editar interesado");
		view.getBtnGuardar().setVisible(false);
		view.getBtnGuardarCambios().setVisible(true);
		
		currentInteresado = i;
		fillCombos();
		fillTables();
		interesadoMapper.fillFields(i);
	}

}
