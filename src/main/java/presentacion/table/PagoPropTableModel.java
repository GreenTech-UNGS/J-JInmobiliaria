package presentacion.table;

import entities.PagoPropietario;

@SuppressWarnings("serial")
public class PagoPropTableModel extends BaseTableModel<PagoPropietario>{
	
	public PagoPropTableModel(){
		super.addColumn("Propiedad", false, 100);
		super.addColumn("Monto", false, 100);
		super.addColumn("Estado", false, 100);
	}

	@Override
	protected Object[] toRow(PagoPropietario t) {
		Object[] fila = {t.getPropietario(),
				t.getMonto(),
				t.getEstado()};
		return fila;
	}
	
	

}
