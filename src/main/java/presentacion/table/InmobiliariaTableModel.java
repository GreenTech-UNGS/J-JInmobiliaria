package presentacion.table;

import entities.Inmobiliaria;

public class InmobiliariaTableModel extends BaseTableModel<Inmobiliaria>{

	
	public InmobiliariaTableModel() {
		addColumn("Nombre", false, 100);
		addColumn("CUIT", false, 100);
		addColumn("Direccion", false, 300);
	}
	
	@Override
	protected Object[] toRow(Inmobiliaria t) {
		
		String provincia = t.getLocalidad().getProvincia().toString().replaceAll("_", "");

		String direccion = t.getCalle() + " " +
				t.getAltura() + " " +
				(t.getPiso()==null? "":("Piso " + t.getPiso()+" "))+
				(t.getDepto()==null? "":("Dpto " + t.getDepto()+" "))+
				t.getLocalidad().getNombre()+ ", Pcia."+
				provincia;
		
		Object[] toRet = {t.getNombre(),
						t.getCUIT(),
						direccion};
		
		return toRet;
		
	}

}
