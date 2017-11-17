package presentacion.controller.filtros;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Moneda;
import entities.Provincia;
import entities.TipoOfrecimiento;
import filtros.PropiedadFiltro;
import model.LocalidadService;
import presentacion.mappers.PropiedadFiltroMapper;
import presentacion.vista.filtros.PropiedadFiltroView;

public class PropiedadFiltroController {
	
	private PropiedadFiltroView view;
	
	@Inject private PropiedadFiltroMapper mapper;
	
	private PropiedadFiltro currentFiltro;
	private boolean wasOkPressed;
	private LocalidadService localidadService;
	
	
	@Inject
	private PropiedadFiltroController(PropiedadFiltroView view, LocalidadService localidadService){
		this.view = view;
		wasOkPressed = false;
		
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
		mapper.fillFields(currentFiltro);
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
		
		view.getProvCombo().clearAndActualize(localidadService.getProvincias());
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		view.getMonedaCombo().clearAndActualize(Arrays.asList(Moneda.values()));
		
		AutoCompleteDecorator.decorate(view.getCbLocalidad());
		cambiaLocalidades();
		
		view.getTipoOfrCombo().clearAndActualize(Arrays.asList(TipoOfrecimiento.values()));
		
	}
	
	private void cambiaLocalidades() {
		
		view.getLocalidadCombo().removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(view.getProvCombo().getSelected());
		view.getLocalidadCombo().clearAndActualize(localidades);
		
	}
}
