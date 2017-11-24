package presentacion.table;

import entities.Inmobiliaria;

@SuppressWarnings("serial")
public class InmobiliariaTableModel extends BaseTableModel<Inmobiliaria>{

	
	public InmobiliariaTableModel() {
		addColumn("CUIT", false, 100);
		addColumn("Nombre", false, 100);
		addColumn("Direccion", false, 300);
		addColumn("Localidad", false, 100);
		addColumn("Provincia", false, 100);
	}
	
	@Override
	protected Object[] toRow(Inmobiliaria t) {

		String direccion = t.getCalle() + " " +
				t.getAltura() + " " +
				(t.getPiso()==null? "":("Piso " + t.getPiso()+" "))+
				(t.getDepto()==null? "":("Dpto " + t.getDepto()+" "))
//				+t.getLocalidad().getNombre()
				;
		
		Object[] toRet = {t.getCUIT(),
						t.getNombre(),
						direccion, 
						t.getLocalidad().getNombre(),
						t.getLocalidad().getProvincia().getNombre()};
		
		return toRet;
		
	}

}
