package presentacion.table;

import com.google.inject.Inject;

import entities.Propiedad;
import model.PropiedadService;

public class PropiedadesTableModel extends BaseTableModel<Propiedad>{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	PropiedadService propService;
	
	@Inject
	public PropiedadesTableModel() {
		super();
		super.addColumn("Codigo", false, 100);
		super.addColumn("Direccion", false, 400);
		super.addColumn("Precio", false, 100);
		super.addColumn("Estado", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		//FIXME Esto da error null pointer cuando el combo de provincia está vacío
		
		String precioVenta = "";
		String precioAlquiler = "";
		
		if(t.getOfrecimientoVenta().isHabilitada())
			precioVenta = "Venta: " + t.getOfrecimientoVenta().getPrecio() + 
			t.getOfrecimientoVenta().getPrecio().getMoneda().toString();
		
		if(t.getOfrecimientoAlquiler().isHabilitada())
			precioVenta = "Venta: " + t.getOfrecimientoAlquiler().getPrecio() + 
			t.getOfrecimientoAlquiler().getPrecio().getMoneda().toString();
		
		String precio = precioVenta + " " + precioAlquiler;
		String piso = "";
		String depto = "";
		if(!t.getPiso().equals("")){
			piso = " Piso:" + t.getPiso();}
		if(!t.getDpto().equals("")){
			depto = " Depto:" + t.getDpto();}
		String direccion = t.getCalle() + " " +
							t.getAltura() + piso + depto;
		
		Object[] fila = {t.getIdentificador(),
						direccion,
						precio,
						propService.getCurrentEstado(t).toString()};
		
		return fila;
	}
}