package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Inmobiliaria;
import entities.Localidad;
import entities.Propiedad;
import entities.Provincia;
import misc.Binder;
import model.InmobiliariaService;
import model.LocalidadService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.mappers.InmobiliariaFormMapper;
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
	
	
	@Inject
	private InmobiliariaController(InmobiliariaForm view, InmobiliariaService inmobiliariaService,
									LocalidadService localidadService){
		this.view = view;
		this.inmobiliariaService = inmobiliariaService;
		this.provCombo = new ProvinciaComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.localidadService = localidadService;
		
		fillCombo();
		
		view.getBtnGuardar().addActionListener(e -> saveInmobiliaria());
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
	}
	
	private void fillCombo() {
	
		this.view.getCbProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		view.getCbLocalidad().setModel(localidadCombo);
		AutoCompleteDecorator.decorate(view.getCbLocalidad());
		cambiaLocalidades();
		
	}

	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
		localidadCombo.actualize(localidades);
		
	}

}