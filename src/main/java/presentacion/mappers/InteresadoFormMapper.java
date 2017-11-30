package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Localidad;
import entities.Moneda;
import entities.TipoOfrecimiento;
import org.joda.time.DateTime;
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
		String email = view.getTfEmail().getText();
		String metrosCuadradosDesde = view.getTfDesdeMetros().getText();
		String metrosCuadradosHasta = view.getTfHastaMetros().getText();
		String ambientesDesde = view.getTfDesdeAmbientes().getText();
		String ambientesHasta = view.getTfHastaAmbientes().getText();
		String precioDesdeVenta = view.getTfDesdePrecioVenta().getText();
		String precioHastaVenta = view.getTfHastaPrecioVenta().getText();
		String precioDesdeAlquiler = view.getTfDesdePrecioAlquiler().getText();
		String precioHastaAlquiler = view.getTfHastaPrecioAlquiler().getText();
		
		TipoOfrecimiento tipoOfrec = view.getComboModelOfrecimiento().getSelected();
		Moneda monedaVenta = Moneda.valueOf((String) view.getCbMonedaVenta().getSelectedItem());
		Moneda monedaAlquiler = Moneda.valueOf((String) view.getCbMonedaAlquiler().getSelectedItem());
		Localidad localidad = view.getComboModelLocalidad().getSelected();
	
		
		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setEmail(email);

		t.getPreferencia().setMetrosCuadradosDesde(getIntegerValue(metrosCuadradosDesde));
		t.getPreferencia().setMetrosCuadradosDesde(getIntegerValue(metrosCuadradosDesde));
		t.getPreferencia().setMetrosCuadradosHasta(getIntegerValue(metrosCuadradosHasta));
		t.getPreferencia().setCantidadAmbientesDesde(getIntegerValue(ambientesDesde));
		t.getPreferencia().setCantidadAmbientesHasta(getIntegerValue(ambientesHasta));
		t.getPreferencia().setPrecioVentaDesde(getIntegerValue(precioDesdeVenta));
		t.getPreferencia().setPrecioVentaHasta(getIntegerValue(precioHastaVenta));
		t.getPreferencia().setPrecioAlquilerDesde(getIntegerValue(precioDesdeAlquiler));
		t.getPreferencia().setPrecioAlquilerHasta(getIntegerValue(precioHastaAlquiler));
		
		t.getPreferencia().setTipoOfrecimiento(tipoOfrec);	
		t.getPreferencia().setMonedaVenta(monedaVenta);
		t.getPreferencia().setMonedaAlquiler(monedaAlquiler);
		t.getPreferencia().setLocalidad(localidad);
		t.setFechaAlta(DateTime.now());

	}

	@Override
	public void fillFields(Interesado t) {
		
		String nombre = t.getPersona().getNombre();
		String apellido = t.getPersona().getApellido();
		String email = t.getPersona().getEmail();
		String metrosCuadradosDesde = String.valueOf(t.getPreferencia().getMetrosCuadradosDesde());
		String metrosCuadradosHasta = String.valueOf(t.getPreferencia().getMetrosCuadradosHasta());
		String ambientesDesde = String.valueOf(t.getPreferencia().getCantidadAmbientesDesde());
		String ambientesHasta = String.valueOf(t.getPreferencia().getCantidadAmbientesHasta());
		String precioDesdeVenta = String.valueOf(t.getPreferencia().getPrecioVentaDesde());
		String precioHastaVenta = String.valueOf(t.getPreferencia().getPrecioVentaHasta());
		String precioDesdeAlquiler = String.valueOf(t.getPreferencia().getPrecioAlquilerDesde());
		String precioHastaAlquiler = String.valueOf(t.getPreferencia().getPrecioAlquilerHasta());
		
		Moneda monedaVenta = t.getPreferencia().getMonedaVenta();
		Moneda monedaAlquiler = t.getPreferencia().getMonedaAlquiler();
		
		view.getTfNombre().setText(nombre);
		view.getTfApellido().setText(apellido);
		view.getTfEmail().setText(email);
		view.getTfDesdeMetros().setText(metrosCuadradosDesde);
		view.getTfHastaMetros().setText(metrosCuadradosHasta);
		view.getTfDesdeAmbientes().setText(ambientesDesde);
		view.getTfHastaAmbientes().setText(ambientesHasta);
		view.getTfDesdePrecioVenta().setText(precioDesdeVenta);
		view.getTfHastaPrecioVenta().setText(precioHastaVenta);
		view.getTfDesdePrecioAlquiler().setText(precioDesdeAlquiler);
		view.getTfHastaPrecioAlquiler().setText(precioHastaAlquiler);
	
		view.getComboModelOfrecimiento().setSelected(t.getPreferencia().getTipoOfrecimiento());
		view.getComboModelMonedaVenta().setSelectedItem(monedaVenta);
		view.getComboModelMonedaAlquiler().setSelectedItem(monedaAlquiler);
		if(t.getPreferencia().getLocalidad() != null)
			view.getComboModelProvincia().setSelected(t.getPreferencia().getLocalidad().getProvincia());
		view.getComboModelLocalidad().setSelected(t.getPreferencia().getLocalidad());
		

	}

	public Integer getIntegerValue(String s){
		
		try{
			Integer i = Integer.parseInt(s);
			return i;
		} catch(Exception e){
			return null;
		}
	}

}
