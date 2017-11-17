package presentacion.controller.filtros;

import java.util.Arrays;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Moneda;
import entities.Provincia;
import entities.TipoOfrecimiento;
import filtros.InteresadoFiltro;
import model.LocalidadService;
import presentacion.mappers.InteresadoFiltroMapper;
import presentacion.vista.filtros.InteresadoFiltroView;

@Singleton
public class InteresadoFiltroController {
	
	private InteresadoFiltroView view;
	
	@Inject InteresadoFiltroMapper interesadoMapper;
	
	private InteresadoFiltro currentFiltro;
	private boolean wasOkPressed;
	private LocalidadService localidadService;
	
	@Inject
	private InteresadoFiltroController(InteresadoFiltroView view, LocalidadService localidadService){
		this.view = view;
		wasOkPressed = false;
		this.localidadService = localidadService;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
	}
	

	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void setModeNew() {
		
		view.getCbLocalidad().removeAllItems();
		view.getCbProvincia().removeAllItems();
		view.getCbMoneda().removeAllItems();
		
		fillCombos();

		currentFiltro = new InteresadoFiltro();
		interesadoMapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public InteresadoFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		interesadoMapper.fillBean(currentFiltro);
		return currentFiltro;
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
