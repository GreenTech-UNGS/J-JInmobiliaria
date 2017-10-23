package presentacion.controller.filtros;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Moneda;
import entities.Provincia;
import entities.TipoOfrecimiento;
import entities.Persona.TipoCredencial;
import filtros.PropiedadFiltro;
import filtros.PropietarioFiltro;
import model.LocalidadService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
import presentacion.mappers.PropiedadFiltroMapper;
import presentacion.vista.filtros.PropiedadFiltroView;

public class PropiedadFiltroController {
	
	private PropiedadFiltroView view;
	
	@Inject private PropiedadFiltroMapper mapper;
	
	private PropiedadFiltro currentFiltro;
	private boolean wasOkPressed;
	private LocalidadService localidadService;
	
	ProvinciaComboBoxModel provCombo;
	MonedaComboBoxModel monedaCombo;
	LocalidadComboBoxModel localidadCombo;
	TipoOfrecimientoComboBoxModel tipoOfrCombo;
	
	@Inject
	private PropiedadFiltroController(PropiedadFiltroView view, LocalidadService localidadService){
		this.view = view;
		wasOkPressed = false;
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		this.localidadService = localidadService;
		
		view.getBtnFiltrar().addActionListener(e -> aceptar());
		view.getCbProvincia().addActionListener(e -> cambiaLocalidades());
		
	}
	
	public void setModeNew(){
		view.getCbLocalidad().removeAllItems();
		view.getCbProvincia().removeAllItems();
		view.getCbMoneda().removeAllItems();
		
		fillCombos();

		
		currentFiltro = new PropiedadFiltro();
//		mapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public PropiedadFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		return currentFiltro;
	}
	
	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	private void fillCombos() {
		
		this.view.getCbProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		this.view.getCbMoneda().setModel(monedaCombo);
		monedaCombo.actualize(Arrays.asList(Moneda.values()));
		
		this.view.getCbLocalidad().setModel(localidadCombo);
		AutoCompleteDecorator.decorate(view.getCbLocalidad());
		cambiaLocalidades();
		
		this.view.getCbTipoOfrec().setModel(tipoOfrCombo);
		tipoOfrCombo.actualize(Arrays.asList(TipoOfrecimiento.values()));
		
	}
	
	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
		localidadCombo.actualize(localidades);
		
	}
}
