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

	
	
	@Inject
	private AddPropiedadController(AgregarPropiedad view, PropiedadService propiedadService){
		
		this.view = view;
		this.propiedadService = propiedadService;
		
		view.getBtnGuardar().addActionListener(e -> guardarPropiedad());
		
	}



	private Object guardarPropiedad() {
		binder.fillBean();
		//falta validador
		//falta para guardar propiedades en el service...
		
		return null;
	}
	
}
