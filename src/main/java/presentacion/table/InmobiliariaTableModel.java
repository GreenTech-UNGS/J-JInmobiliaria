<<<<<<< HEAD
package presentacion.table;

import com.google.inject.Inject;

import entities.Inmobiliaria;
import model.InmobiliariaService;

@SuppressWarnings("serial")
public class InmobiliariaTableModel extends BaseTableModel<Inmobiliaria> {
	
	@Inject
	InmobiliariaService inmobiliariaService;
	
	@Inject
	public InmobiliariaTableModel(){
		super.addColumn("CUIT", false, 100);
		super.addColumn("Nombre", false, 100);
	}

	@Override
	protected Object[] toRow(Inmobiliaria t) {
		Object[] fila = {t.getCUIT(),
				t.getNombre()};
		return fila;
	}

}
=======
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
>>>>>>> branch 'master' of https://github.com/GreenTech-UNGS/J-JInmobiliaria.git
