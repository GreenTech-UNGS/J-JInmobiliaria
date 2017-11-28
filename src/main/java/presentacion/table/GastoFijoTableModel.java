package presentacion.table;

import entities.GastoFijo;

public class GastoFijoTableModel extends BaseTableModel<GastoFijo>{

	public GastoFijoTableModel() {

		super.addColumn("Nombre", false, 300);
		super.addColumn("Monto", false, 300);
		super.addColumn("Dia Vto.", false, 300);
		super.addColumn("Descripcion", false, 300);
	}
	
	@Override
	protected Object[] toRow(GastoFijo t) {
		
		Object[] toRet = {
				t.getNombre(),
				t.getMonto(),
				t.getDia(),
				t.getDescripcion()
				
		};
		
		return toRet;
	}

}
