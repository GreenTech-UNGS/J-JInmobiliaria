package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Moneda;
import entities.TipoOfrecimiento;
import filtros.PropiedadFiltro;
import presentacion.vista.filtros.PropiedadFiltroView;

@Singleton
public class PropiedadFiltroMapper implements Mapper<PropiedadFiltro> {
	
	private PropiedadFiltroView view;
	
	@Inject
	private PropiedadFiltroMapper( PropiedadFiltroView view){
		this.view = view;
	}

	@Override
	public void fillBean(PropiedadFiltro t) {
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
	public void fillFields(PropiedadFiltro t) {
		String precioDesde = Double.toString(t.getPrecioDesde());
		String precioHasta = Double.toString(t.getPrecioHasta());
		Moneda moneda = t.getMoneda();
		Localidad localidad = t.getLocalidad(); //eeeeeeeehm
		TipoOfrecimiento ofrecimiento = t.getTipoOfrecimiento();
	
		
		view.getTfPrecioDesde().setText(precioDesde);
		view.getTfPrecioHasta().setText(precioHasta);
		view.getMonedaCombo().setSelected(moneda);
		view.getLocalidadCombo().setSelected(localidad);
		view.getTipoOfrCombo().setSelected(ofrecimiento);
	}
	
	private String getStringNumber(String s) {
		if(s == null)
			return "0";
		if(s.matches("\\b*"))
			return "0";
		return s;
	}
}
