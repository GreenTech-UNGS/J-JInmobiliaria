package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Localidad;
import entities.Moneda;
import entities.Persona.TipoCredencial;
import entities.Provincia;
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
		String credencial = view.getTfCredencial().getText();
		String email = view.getTfEmail().getText();
		String metrosCuadradosDesde = view.getTfDesdeMetros().getText();
		String metrosCuadradosHasta = view.getTfHastaMetros().getText();
		String ambientesDesde = view.getTfDesdeAmbientes().getText();
		String ambientesHasta = view.getTfHastaAmbientes().getText();
		String precioDesdeVenta = view.getTfDesdePrecioVenta().getText();
		String precioHastaVenta = view.getTfHastaPrecioVenta().getText();
		String precioDesdeAlquiler = view.getTfDesdePrecioAlquiler().getText();
		String precioHastaAlquiler = view.getTfHastaPrecioAlquiler().getText();
		
		TipoCredencial tipoCred = TipoCredencial.valueOf((String) view.getCbCredencial().getSelectedItem());
		TipoOfrecimiento tipoOfrec = view.getComboModelOfrecimiento().getSelected();
		Moneda monedaVenta = view.getComboModelMonedaVenta().getSelected();
		Moneda monedaAlquiler = view.getComboModelMonedaAlquiler().getSelected();

		Localidad localidad = view.getComboModelLocalidad().getSelected();
		Provincia provincia = view.getComboModelProvincia().getSelected();
		
		
		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setCredencial(credencial);
		t.getPersona().setEmail(email);
		t.getPreferencia().setMetrosCuadradosDesde(Integer.parseInt(metrosCuadradosDesde));
		t.getPreferencia().setMetrosCuadradosHasta(Integer.parseInt(metrosCuadradosHasta));
		t.getPreferencia().setCantidadAmbientesDesde(Integer.parseInt(ambientesDesde));
		t.getPreferencia().setCantidadAmbientesHasta(Integer.parseInt(ambientesHasta));
		t.getPreferencia().setPrecioVentaDesde(Integer.parseInt(precioDesdeVenta));
		t.getPreferencia().setPrecioVentaHasta(Integer.parseInt(precioHastaVenta));
		t.getPreferencia().setPrecioAlquilerDesde(Integer.parseInt(precioDesdeAlquiler));
		t.getPreferencia().setPrecioAlquilerHasta(Integer.parseInt(precioHastaAlquiler));

		
		t.getPersona().setTipoCred(tipoCred);
		t.getPreferencia().setTipoOfrecimiento(tipoOfrec);	
		t.getPreferencia().setMonedaVenta(monedaVenta);
		t.getPreferencia().setMonedaAlquiler(monedaAlquiler);
		t.getPreferencia().setLocalidad(localidad);
		t.setFechaAlta(DateTime.now());
//		t.getPreferencia().getLocalidad().setProvincia(provincia);
		

	}

	@Override
	public void fillFields(Interesado t) {
		
		String nombre = t.getPersona().getNombre();
		String apellido = t.getPersona().getApellido();
		String credencial = t.getPersona().getCredencial();
		String email = t.getPersona().getEmail();
		String metrosCuadradosDesde = String.valueOf(t.getPreferencia().getMetrosCuadradosDesde());
		String metrosCuadradosHasta = String.valueOf(t.getPreferencia().getMetrosCuadradosHasta());
		String ambientesDesde = String.valueOf(t.getPreferencia().getCantidadAmbientesDesde());
		String ambientesHasta = String.valueOf(t.getPreferencia().getCantidadAmbientesHasta());
		String precioDesdeVenta = String.valueOf(t.getPreferencia().getPrecioVentaDesde());
		String precioHastaVenta = String.valueOf(t.getPreferencia().getPrecioVentaHasta());
		String precioDesdeAlquiler = String.valueOf(t.getPreferencia().getPrecioAlquilerDesde());
		String precioHastaAlquiler = String.valueOf(t.getPreferencia().getPrecioAlquilerHasta());
		
		String tipoCred = String.valueOf(t.getPersona().getTipoCred());	
		TipoOfrecimiento tipoOfrec = t.getPreferencia().getTipoOfrecimiento();	
		Moneda monedaVenta = t.getPreferencia().getMonedaVenta();
		Moneda monedaAlquiler = t.getPreferencia().getMonedaAlquiler();
		Localidad localidad = t.getPreferencia().getLocalidad();
		
		view.getTfNombre().setText(nombre);
		view.getTfApellido().setText(apellido);
		view.getTfCredencial().setText(credencial);
		view.getTfEmail().setText(email);
		view.getTfDesdeMetros().setText(metrosCuadradosDesde);
		view.getTfHastaMetros().setText(metrosCuadradosHasta);
		view.getTfDesdeAmbientes().setText(ambientesDesde);
		view.getTfHastaAmbientes().setText(ambientesHasta);
		view.getTfDesdePrecioVenta().setText(precioDesdeVenta);
		view.getTfHastaPrecioVenta().setText(precioHastaVenta);
		view.getTfDesdePrecioAlquiler().setText(precioDesdeAlquiler);
		view.getTfHastaPrecioAlquiler().setText(precioHastaAlquiler);
		
		view.getCbCredencial().setSelectedItem(tipoCred);
		view.getCbTipoOfrec().setSelectedItem(String.valueOf(tipoOfrec));
		view.getCbMonedaVenta().setSelectedItem(String.valueOf(monedaVenta));
		view.getCbMonedaAlquiler().setSelectedItem(String.valueOf(monedaAlquiler));
		view.getCbLocalidad().setSelectedItem(String.valueOf(localidad));
//		if(localidad != null){
//			view.getCbProvincia().setSelectedItem(String.valueOf(localidad.getProvincia()));
//		}
	}

}
