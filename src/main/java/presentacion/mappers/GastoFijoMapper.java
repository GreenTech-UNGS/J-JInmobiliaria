package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.GastoFijo;
import presentacion.vista.GastoFijoForm;

@Singleton
public class GastoFijoMapper implements Mapper<GastoFijo>{

	private GastoFijoForm view;
	
	@Inject
	private GastoFijoMapper(GastoFijoForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(GastoFijo t) {
		
		float monto = (float) view.getSpinnerMonto().getValue();
		String nombre = view.getTextNombre().getText();
		String descripcion = view.getTextDescripcion().getText();
		
		t.setMonto(monto);
		t.setNombre(nombre);
		t.setDescripcion(descripcion);
		
	}

	@Override
	public void fillFields(GastoFijo t) {
		
		float monto = t.getMonto() == 0? 1 : t.getMonto();
		String nombre = t.getNombre();
		String descripcion = t.getDescripcion();
		
		view.getSpinnerMonto().setValue(monto);
		view.getTextNombre().setText(nombre);
		view.getTextDescripcion().setText(descripcion);
		
	}

}
