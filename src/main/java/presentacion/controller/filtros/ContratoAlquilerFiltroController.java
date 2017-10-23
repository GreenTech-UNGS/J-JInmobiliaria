package presentacion.controller.filtros;


import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import filtros.ContratoAlquilerFiltro;
import presentacion.controller.ElegirPropiedadController;
import presentacion.vista.filtros.ContratoAlquilerFiltroView;

@Singleton
public class ContratoAlquilerFiltroController {

	private ContratoAlquilerFiltroView view;
	@Inject ElegirPropiedadController elegirPropiedad;
	
	private boolean wasOkPressed;
	private ContratoAlquilerFiltro currentFiltro;
	
	@Inject
	private ContratoAlquilerFiltroController(ContratoAlquilerFiltroView view) {
		this.view = view;
		
		this.view.getBtnAceptar().addActionListener(e -> aceptar());
		this.view.getBtnLupa().addActionListener(e -> eligepropiedad());
	}
	
	private void eligepropiedad() {
		elegirPropiedad.showViewAll();
		Propiedad propiedad = elegirPropiedad.getPropiedad();
		
		this.view.getTextPropiedad().setText(propiedad.getIdentificador() + ". "
				+ propiedad.getLocalidad().getNombre() + ", " + propiedad.getCalle());
		
		currentFiltro.setPropiedad(propiedad);
	}

	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void setModeNew() {
		view.getTextPropiedad().setText("");
		currentFiltro = new ContratoAlquilerFiltro();
		wasOkPressed = false;
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public ContratoAlquilerFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		return currentFiltro;
	}
}
