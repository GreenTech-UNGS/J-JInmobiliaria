package presentacion.controller;

import com.google.inject.Inject;

import entities.Propiedad;
import misc.Binder;
import presentacion.vista.DetallePropiedadView;

public class DetallePropiedadController {
	
	private DetallePropiedadView view;
	private Binder<Propiedad> binder;
	
	@Inject
	private DetallePropiedadController(DetallePropiedadView view){
		this.view = view;
		this.binder = new Binder<Propiedad>();
		
	}
	
	public void ShowView(){
		view.setVisible(true);
	}

}
