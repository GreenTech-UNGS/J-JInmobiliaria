package presentacion.table;

import entities.Cita;

public class CitasTableModel extends BaseTableModel<Cita>{

	public CitasTableModel() {
		addColumn("Fecha y Hora", false, 200);
		addColumn("Tipo de cita", false, 100);
		addColumn("Lugar", false, 200);
	}
	
	@Override
	protected Object[] toRow(Cita t) {
		
		Object[] toRet = {
				
				t.getFechaHora().toString("dd-MM-YYYY HH:mm"),
				t.getTipo().toString(),
				t.getLocalidad().getNombre()
				
		};
		
		return toRet;
	}

}
