package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Propiedad;
import misc.Binder;
import model.PropiedadService;
import presentacion.vista.AgregarPropiedad;

@Singleton
public class AddPropiedadController {
	
	private AgregarPropiedad view;
	private PropiedadService propiedadService;
	private Binder<Propiedad> binder;
	private Propiedad currentPropiedad;

	
	
	@Inject
	private AddPropiedadController(AgregarPropiedad view, PropiedadService propiedadService){
		
		this.view = view;
		this.propiedadService = propiedadService;
		this.binder = new Binder<Propiedad>();
		view.getBtnGuardar().addActionListener(e -> saveCurrentPropiedad());
		
	}
	
	public void setModeNew() {
		currentPropiedad = propiedadService.getEmptyPropiedad();
		binder.setObjective(currentPropiedad);
		binder.fillFields();
	}

	private void saveCurrentPropiedad() {
		binder.fillBean();
		propiedadService.savePropiedad(currentPropiedad);
		view.setVisible(false);
	}
	
	public void showView(){
		
		view.setVisible(true);
	}
	
}
