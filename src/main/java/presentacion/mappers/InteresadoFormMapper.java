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
		Moneda monedaVenta = Moneda.valueOf((String) view.getCbMonedaVenta().getSelectedItem());
		Moneda monedaAlquiler = Moneda.valueOf((String) view.getCbMonedaAlquiler().getSelectedItem());

		Localidad localidad = view.getComboModelLocalidad().getSelected();
//		Provincia provincia = TipoOfrecimiento.valueOf((String) view.getCbTipoOfrec().getSelectedItem());
		
		
		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setCredencial(credencial);
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
		
//		view.getCbCredencial().setSelectedItem(tipoCred);
//		view.getComboModelOfrecimiento().setSelected((tipoOfrec));
//		view.getComboModelMonedaVenta().setSelectedItem((monedaVenta));
//		view.getComboModelMonedaAlquiler().setSelected(monedaAlquiler);	
		view.getCbCredencial().setSelectedItem(tipoCred);
		view.getComboModelOfrecimiento().setSelected(tipoOfrec);
		view.getCbTipoOfrec().setSelectedItem(tipoOfrec.toString());
		System.out.println(view.getComboModelOfrecimiento().getSelected());
		view.getComboModelMonedaVenta().setSelectedItem((monedaVenta));
		view.getCbMonedaAlquiler().setSelectedItem(monedaAlquiler);		
		if(localidad != null){
			view.getComboModelProvincia().setSelected(localidad.getProvincia());
		}
		view.getComboModelLocalidad().setSelected(localidad);

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
