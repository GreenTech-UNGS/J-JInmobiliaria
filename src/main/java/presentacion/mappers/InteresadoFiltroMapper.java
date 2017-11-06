package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Moneda;
import entities.TipoOfrecimiento;
import filtros.InteresadoFiltro;
import presentacion.vista.filtros.InteresadoFiltroView;

@Singleton
public class InteresadoFiltroMapper implements Mapper<InteresadoFiltro>{
	
	InteresadoFiltroView view;
	
	@Inject
	private InteresadoFiltroMapper(InteresadoFiltroView view){
		this.view = view;
	}
	
	@Override
	public void fillBean(InteresadoFiltro t) {
		
		double precioDesde =  Double.parseDouble(getStringNumber(view.getTfPrecioDesde().getText()));
		double precioHasta =  Double.parseDouble(getStringNumber(view.getTfPrecioHasta().getText()));
		Moneda moneda = view.getMonedaCombo().getSelected();
		Localidad localidad = view.getLocalidadCombo().getSelected(); 
		TipoOfrecimiento ofrecimiento = view.getTipoOfrCombo().getSelected();
		
		t.setPrecioDesde(precioDesde);
		t.setPrecioHasta(precioHasta);
		t.setMoneda(moneda);
		t.setLocalidad(localidad);
		t.setTipoOfrecimiento(ofrecimiento);
	}

	@Override
	public void fillFields(InteresadoFiltro t) {
		
		String precioDesde = Double.toString(t.getPrecioDesde());
		String precioHasta = Double.toString(t.getPrecioDesde());
		Moneda moneda = t.getMoneda();
		Localidad localidad = t.getLocalidad();
		TipoOfrecimiento tipoOfrec = t.getTipoOfrecimiento();
		
		this.view.getTfPrecioDesde().setText(precioDesde);
		this.view.getTfPrecioHasta().setText(precioHasta);
		this.view.getMonedaCombo().setSelectedItem(moneda);
		view.getLocalidadCombo().setSelected(localidad);
		view.getTipoOfrCombo().setSelected(tipoOfrec);	
	}
	
	private String getStringNumber(String s) {
		if(s == null)
			return "0";
		if(s.matches("\\b*"))
			return "0";
		return s;
	}
}
