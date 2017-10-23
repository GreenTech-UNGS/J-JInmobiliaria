package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Habitacion;
import entities.TipoHabitacion;
import presentacion.vista.HabitacionForm;

@Singleton
public class HabitacionController {

	private HabitacionForm view;
	
	@Inject
	private HabitacionController(HabitacionForm view) {
		this.view = view;
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public Habitacion getHabitacion() {
		Habitacion toRet = new Habitacion();
		toRet.setAncho(10);
		toRet.setLargo(20);
		toRet.setTipo(TipoHabitacion.Cocina);
		toRet.setDescripcion("Cocina piola");
		
		return toRet;
	}

	public void setModeNew() {
		
		
	}
	
}
