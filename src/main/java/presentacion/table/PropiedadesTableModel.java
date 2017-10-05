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
		
		super.addColumn("identificador", false, 100);
		super.addColumn("calle", false, 100);
		super.addColumn("altura", false, 100);
		super.addColumn("precio", false, 100);
		super.addColumn("estado", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		
		String precio = t.getPrecioTentativo().getMonto() + " " + t.getPrecioTentativo().getMoneda();
		
		Object[] fila = {t.getIdentificador(),
						t.getCalle(),
						t.getAltura(),
						precio,
						propService.getCurrentEstado(t).toString()};
		
		return fila;
	}
}