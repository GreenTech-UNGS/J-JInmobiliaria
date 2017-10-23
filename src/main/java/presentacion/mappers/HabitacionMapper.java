package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Habitacion;
import entities.TipoHabitacion;
import presentacion.vista.HabitacionForm;

@Singleton
public class HabitacionMapper implements Mapper<Habitacion>{

	private HabitacionForm view;
	
	@Inject
	private HabitacionMapper(HabitacionForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(Habitacion t) {
		
		int largo = (int) view.getSpinnerLargo().getValue();
		int ancho = (int) view.getSpinnerAncho().getValue();
		String observaciones = view.getTextObservaciones().getText();
		TipoHabitacion tipo = view.getComboModel().getSelected();
		
		t.setAncho(ancho);
		t.setLargo(largo);
		t.setDescripcion(observaciones);
		t.setTipo(tipo);
		
	}

	@Override
	public void fillFields(Habitacion t) {
		
		int largo = t.getLargo() == 0? 1 : t.getLargo();
		int ancho = t.getAncho() == 0? 1 : t.getAncho();
		String observaciones = t.getDescripcion();
		TipoHabitacion tipo = t.getTipo();
		
		view.getSpinnerAncho().setValue(ancho);
		view.getSpinnerLargo().setValue(largo);
		view.getComboModel().setSelected(tipo);
		view.getTextObservaciones().setText(observaciones);
		
	}

}
