package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cartel;
import presentacion.vista.CartelForm;

@Singleton
public class CartelMapper implements Mapper<Cartel>{

	private CartelForm view;
	
	@Inject
	private CartelMapper(CartelForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(Cartel t) {
		
		int alto = (int) view.getSpinnerAlto().getValue();
		int ancho = (int) view.getSpinnerAncho().getValue();
		String identificador = view.getTextIdentificador().getText();
		String descripcion = view.getTextDescripcion().getText();
		
		t.setAncho(ancho);
		t.setAlto(alto);
		t.setIdentificador(identificador);
		t.setDescripcion(descripcion);
		
	}

	@Override
	public void fillFields(Cartel t) {
		
		int alto = t.getAlto() == 0? 1 : t.getAlto();
		int ancho = t.getAncho() == 0? 1 : t.getAncho();
		String identificador = t.getIdentificador();
		String descripcion = t.getDescripcion();
		
		view.getSpinnerAncho().setValue(ancho);
		view.getSpinnerAlto().setValue(alto);
		view.getTextIdentificador().setText(identificador);
		view.getTextDescripcion().setText(descripcion);
		
	}

}
