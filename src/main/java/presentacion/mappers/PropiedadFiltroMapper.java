package presentacion.mappers;

import com.google.inject.Singleton;

import entities.Localidad;
import entities.Moneda;
import entities.Precio;
import filtros.PropiedadFiltro;
import presentacion.vista.filtros.PropiedadFiltroView;

@Singleton
public class PropiedadFiltroMapper implements Mapper<PropiedadFiltro> {
	
	private PropiedadFiltroView view;
	
	private PropiedadFiltroMapper( PropiedadFiltroView view){
		this.view = view;
	}

	@Override
	public void fillBean(PropiedadFiltro t) {
		double precioDesde =  Double.parseDouble(view.getTfPrecioDesde().getText());
		double precioHasta =  Double.parseDouble(view.getTfPrecioDesde().getText());
		Moneda moneda = (Moneda) view.getCbMoneda().getSelectedItem();  //cambiar raw type
		Localidad localidad = (Localidad) view.getCbLocalidad().getSelectedItem(); //same
		
		Precio desde = new Precio();
		desde.setMonto(precioDesde);
		desde.setMoneda(moneda);
		
		Precio hasta = new Precio();
		hasta.setMonto(precioHasta);
		hasta.setMoneda(moneda);
		
		t.setPrecioDesde(desde);
		t.setPrecioHasta(hasta);
		t.setLocalidad(localidad);
	}

	@Override
	public void fillFields(PropiedadFiltro t) {
		String precioDesde = Double.toString(t.getPrecioDesde().getMonto());
		String precioHasta = Double.toString(t.getPrecioHasta().getMonto());
		Moneda moneda = t.getPrecioDesde().getMoneda();
		Localidad localidad = t.getLocalidad();
		
		view.getTfPrecioDesde().setText(precioDesde);
		view.getTfPrecioHasta().setText(precioHasta);
		view.getCbMoneda().setSelectedItem(moneda);
		view.getCbLocalidad().setSelectedItem(localidad);
	}

}
