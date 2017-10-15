package presentacion.table;

import com.google.inject.Guice;
import com.google.inject.Inject;

import entities.Propiedad;
import model.PropiedadService;

public class PropiedadesTableModel extends BaseTableModel<Propiedad>{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	PropiedadService propService;
	
	@Inject
	private PropiedadesTableModel() {
		super();
		super.addColumn("Codigo", false, 100);
		super.addColumn("Direccion", false, 400);
		super.addColumn("Precio", false, 100);
		super.addColumn("Estado", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		//FIXME Esto da error null pointer cuando el combo de provincia está vacío
		String precio = t.getPrecioTentativo().getMonto() + " " + t.getPrecioTentativo().getMoneda();
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