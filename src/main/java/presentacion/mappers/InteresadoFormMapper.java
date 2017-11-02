package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Localidad;
import entities.Persona.TipoCredencial;
import entities.TipoOfrecimiento;
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
		
		TipoCredencial tipoCred = TipoCredencial.valueOf((String) view.getCbCredencial().getSelectedItem());
		TipoOfrecimiento tipoOfrec = TipoOfrecimiento.valueOf((String) view.getCbTipoOfrec().getSelectedItem());
		
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		
		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setCredencial(credencial);
		t.getPersona().setEmail(email);
		t.getPreferencia().setMetrosCuadrados(Integer.parseInt(metrosCuadrados));
		t.getPreferencia().setCantidadAmbientes(Integer.parseInt(ambientes));
		t.getPreferencia().setPrecioDesde(Integer.parseInt(precioDesde));
		t.getPreferencia().setPrecioHasta(Integer.parseInt(precioHasta));
		
		t.getPersona().setTipoCred(tipoCred);
		t.getPreferencia().setTipoOfrecimiento(tipoOfrec);	
		t.getPreferencia().setLocalidad(localidad);
		

	}

	@Override
	public void fillFields(Interesado t) {
		
		String nombre = t.getPersona().getNombre();
		String apellido = t.getPersona().getApellido();
		String credencial = t.getPersona().getCredencial();
		String email = t.getPersona().getEmail();
		String metrosCuadrados = String.valueOf(t.getPreferencia().getMetrosCuadrados());
		String ambientes = String.valueOf(t.getPreferencia().getCantidadAmbientes());
		String precioDesde = String.valueOf(t.getPreferencia().getPrecioDesde());
		String precioHasta = String.valueOf(t.getPreferencia().getPrecioDesde());
		
		String tipoCred = String.valueOf(t.getPersona().getTipoCred());	
		TipoOfrecimiento tipoOfrec = t.getPreferencia().getTipoOfrecimiento();	
		Localidad loc = t.getPreferencia().getLocalidad();
		
		view.getTfNombre().setText(nombre);
		view.getTfApellido().setText(apellido);
		view.getTfCredencial().setText(credencial);
		view.getTfEmail().setText(email);
		view.getTfMetros().setText(metrosCuadrados);
		view.getTfAmbientes().setText(ambientes);
		view.getTfDesdePrecio().setText(precioDesde);
		view.getTfHastaPrecio().setText(precioHasta);
		
		view.getCbCredencial().setSelectedItem(tipoCred);
		view.getCbTipoOfrec().setSelectedItem(String.valueOf(tipoOfrec));
		view.getCbLocalidad().setSelectedItem(String.valueOf(loc));
	}

}
