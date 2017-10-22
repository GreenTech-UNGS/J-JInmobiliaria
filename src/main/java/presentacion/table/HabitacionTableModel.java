package presentacion.table;

import entities.Habitacion;

public class HabitacionTableModel extends BaseTableModel<Habitacion>{

	
	public HabitacionTableModel() {
		super.addColumn("Tipo", false, 100);
		super.addColumn("Medidas", false, 100);
	}
	
	@Override
	protected Object[] toRow(Habitacion t) {
		throw new RuntimeException("No implementado");
	}

}
