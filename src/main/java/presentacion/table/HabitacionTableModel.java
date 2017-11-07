package presentacion.table;

import entities.Habitacion;

public class HabitacionTableModel extends BaseTableModel<Habitacion>{

	
	public HabitacionTableModel() {
		super.addColumn("Tipo", false, 100);
		super.addColumn("Medidas", false, 100);
		super.addColumn("Observaciones", false, 100);
	}
	
	@Override
	protected Object[] toRow(Habitacion t) {
		
		String medidas = t.getLargo() + " x " +t.getAncho() + " mts.";
		
		Object[] toRet = {t.getTipo().getNombre(),
				medidas,
				t.getDescripcion()};
		
		return toRet;
		
	}

}
