package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Inmobiliaria;
import entities.Localidad;
import entities.Provincia;
import entities.Telefono;
import model.InmobiliariaService;
import model.LocalidadService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.mappers.InmobiliariaFormMapper;
import presentacion.table.TelefonoTableModel;
import presentacion.validators.InmobiliariaFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.InmobiliariaForm;

public class InmobiliariaController {
	
	private InmobiliariaForm view;
	private InmobiliariaService inmobiliariaService;
	private Inmobiliaria currentInmobiliaria;
	private ProvinciaComboBoxModel provCombo;
	private LocalidadComboBoxModel localidadCombo;
	private LocalidadService localidadService;
	
	@Inject
	private InmobiliariaFormMapper inmobiliariaMapper;
	@Inject
	private InmobiliariaFormValidator inmobiliariaValidator;
	@Inject
	private MessageShow msgShow;
	
	private TelefonoTableModel telTable;
	
	private TelefonoController telefonoController;
	
	
	@Inject
	private InmobiliariaController(InmobiliariaForm view, InmobiliariaService inmobiliariaService,
									LocalidadService localidadService,
									MessageShow msgShow, TelefonoController telefonoController){
		this.view = view;
		this.inmobiliariaService = inmobiliariaService;
		this.provCombo = new ProvinciaComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.localidadService = localidadService;
		this.msgShow = msgShow;
		this.telTable = new TelefonoTableModel();
		this.telefonoController = telefonoController;
		
		fillCombo();
		fillTables();
		
		view.getBtnGuardar().addActionListener(e -> saveInmobiliaria());
		view.getBtnGuardarCambios().addActionListener(e -> saveInmobiliaria());
		view.getBtnAgregarTel().addActionListener(e -> agregaTelefono());
		view.getBtnBorrarTel().addActionListener(e -> borrarTelefono());
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	private void saveInmobiliaria(){
		if(inmobiliariaValidator.isValid()) {
			inmobiliariaMapper.fillBean(currentInmobiliaria);
			inmobiliariaService.saveInmobiliaria(currentInmobiliaria);
			view.setVisible(false);
		}
		else{
			msgShow.showErrorMessage(inmobiliariaValidator.getErrorMessage(), "Error");
		}
	}
	
	public void setModeNew() {
		currentInmobiliaria = inmobiliariaService.getEmptyInmobiliaria();
		inmobiliariaMapper.fillFields(currentInmobiliaria);
		telTable.clean();
	}
	
	private void fillCombo() {
	
		this.view.getCbProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		view.getCbLocalidad().setModel(localidadCombo);
		AutoCompleteDecorator.decorate(view.getCbLocalidad());
		cambiaLocalidades();
		
	}
	
	private void fillTables() {
		telTable.clean();
		if(currentInmobiliaria != null) {
			telTable.addRows(inmobiliariaService.getAllTelefonosOf(currentInmobiliaria));
			
		}
		view.getTableTelefono().setModel(telTable);
		this.view.getTableTelefono().setColumnModel(telTable.getTableColumnModel());
		this.view.getTableTelefono().getTableHeader().setReorderingAllowed(false);
	}

	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
		localidadCombo.actualize(localidades);
		
	}
	
	public void editInmobiliaria(Inmobiliaria i){
		
		view.setTitle("Editar Inmobiliaria");
		view.getBtnGuardar().setVisible(false);
		view.getBtnCancelar().setVisible(false);
		view.getBtnGuardarCambios().setVisible(true);
		fillCombo();
		currentInmobiliaria = i;
		inmobiliariaMapper.fillFields(i);
	}
	
	private void agregaTelefono() {
		telefonoController.setModeNew();
		telefonoController.showView();
		
		Telefono nuevoTel = telefonoController.getTelefono();
				
		if(nuevoTel != null) {
			telTable.addRow(nuevoTel);
			currentInmobiliaria.insertTelefono(nuevoTel);
		}
	}
	
	private void borrarTelefono() {
		int[] seleccionadas = this.view.getTableTelefono().getSelectedRows();
		
		for (int fila : seleccionadas){
			telTable.removeRow(fila);
		}
	}

}