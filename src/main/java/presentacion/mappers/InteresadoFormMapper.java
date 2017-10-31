package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import presentacion.vista.InteresadoForm;

@Singleton
public class InteresadoFormMapper implements Mapper<Interesado>{
	
	private InteresadoForm view;
	
	@Inject
	private InteresadoFormMapper(InteresadoForm view){
		this.view = view;
	}

	@Override
	public void fillBean(Interesado t) {
		String nombre = view.getTfNombre().getText();
		String apellido = view.getTfApellido().getText();
		String credencial = view.getTfCredencial().getText();
		String email = view.getTfEmail().getText();
		String metrosCuadrados= view.getTfMetros().getText();
		String ambientes = view.getTfAmbientes().getText();
		String precioDesde = view.getTfDesdePrecio().getText();
		String precioHasta = view.getTfHastaPrecio().getText();

		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setCredencial(credencial);
		t.getPersona().setEmail(email);
		//t.getPreferencia().setCantidadAmbientes(cantidadAmbientes);
	}

	@Override
	public void fillFields(Interesado t) {
		
		String nombre = t.getPersona().getNombre();
		String apellido = t.getPersona().getApellido();
		String credencial = t.getPersona().getCredencial();
		String email = t.getPersona().getEmail();
		
		view.getTfNombre().setText(nombre);
		view.getTfApellido().setText(apellido);
		view.getTfCredencial().setText(credencial);
		view.getTfEmail().setText(email);
	}

}
