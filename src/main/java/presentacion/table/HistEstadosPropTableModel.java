package presentacion.table;

import entities.HistoriaEstadoProp;

@SuppressWarnings("serial")
public class HistEstadosPropTableModel extends BaseTableModel<HistoriaEstadoProp>{
	
	public HistEstadosPropTableModel(){
		super.addColumn("Fecha", false, 100);
		super.addColumn("Estado", false, 100);
	}

	@Override
	protected Object[] toRow(HistoriaEstadoProp t) {
		Object[] fila = {
				t.getFecha().toString("dd-MM-YYYY HH:mm"),
				t.getEstado(),
		};

		return fila;
	}
	

}
