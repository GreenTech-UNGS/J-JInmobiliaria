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
		super.addColumn("Direccion", false, 350);
		super.addColumn("Precio Venta", false, 125);
		super.addColumn("Precio Alquiler", false, 125);
		super.addColumn("Estado", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		//FIXME Esto da error null pointer cuando el combo de provincia está vacío
		
		String precioVenta = "";
		String precioAlquiler = "";
		
		if(t.getOfrecimientoVenta().isHabilitada())
			precioVenta = t.getOfrecimientoVenta().getPrecio().getMonto() + 
			t.getOfrecimientoVenta().getPrecio().getMoneda().toString();
		
		if(t.getOfrecimientoAlquiler().isHabilitada())
			precioAlquiler = t.getOfrecimientoAlquiler().getPrecio().getMonto() + 
			t.getOfrecimientoAlquiler().getPrecio().getMoneda().toString();
		
		
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
						precioVenta,
						precioAlquiler,
						propService.getCurrentEstado(t).toString()};
		
		return fila;
	}
}