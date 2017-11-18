package presentacion.controller.filtros;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Provincia;
import filtros.InmobiliariaFiltro;
import model.LocalidadService;
import presentacion.mappers.InmobiliariaFiltroMapper;
import presentacion.vista.filtros.InmobiliariaFiltroView;

@Singleton
public class InmobiliariaFiltroController {
	
	private InmobiliariaFiltroView view;
	
	@Inject InmobiliariaFiltroMapper mapper;
	private InmobiliariaFiltro currentFiltro;
	private boolean wasOkPressed;
	LocalidadService localidadService;
	
	@Inject
	private InmobiliariaFiltroController(InmobiliariaFiltroView view, LocalidadService localidadService){
		this.view = view;
		this.wasOkPressed = false;
		this.localidadService = localidadService;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		view.getBtnCancelar().addActionListener(e -> view.setVisible(false));
		view.getCbProvincia().addActionListener(e -> cambiaLocalidades());
	}
	
	
	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	private void fillCombo() {
		view.getComboModelProvincia().clearAndActualize(localidadService.getProvincias());
		AutoCompleteDecorator.decorate(view.getCbProvincia());
		
		cambiaLocalidades();
		
	}

	private void cambiaLocalidades() {
		
		view.getComboModelLocalidad().removeAllElements();
		view.getComboModelLocalidad().agregaElemento(null);
		List<Localidad> localidades = localidadService.getAllOf(view.getComboModelProvincia().getSelected());
		view.getComboModelLocalidad().actualize(localidades);
	}
	
	public void setModeNew() {
		fillCombo();
		
		currentFiltro = new InmobiliariaFiltro();
		mapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	public void showView() {
		wasOkPressed = false;
		view.setVisible(true);
	}
	
	public InmobiliariaFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		currentFiltro.setLocalidad(view.getComboModelLocalidad().getSelected());
		return currentFiltro;
	}
	

}
