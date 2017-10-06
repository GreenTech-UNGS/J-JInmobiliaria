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
	
		super.addColumn("Identificador", false, 100);
		super.addColumn("Direccion", false, 400);
		super.addColumn("Precio", false, 100);
		super.addColumn("Estado", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		//FIXME Esto da error null pointer cuando el combo de provincia está vacío
		String precio = t.getPrecioTentativo().getMonto() + " " + t.getPrecioTentativo().getMoneda();
		String provincia = t.getLocalidad().getProvincia().toString().replaceAll("_", "");
		String direccion = t.getCalle() + " " +
							t.getAltura() + " " +
							(t.getPiso()==null? "":("Piso " + t.getPiso()+" "))+
							(t.getDpto()==null? "":("Dpto " + t.getDpto()+" "))+
							t.getLocalidad().getNombre()+ ", Pcia."+
							provincia;
		
		Object[] fila = {t.getIdentificador(),
						direccion,
						precio,
						propService.getCurrentEstado(t).toString()};
		
		return fila;
	}
}