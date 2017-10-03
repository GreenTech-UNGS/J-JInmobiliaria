package presentacion.table;

import entities.Propiedad;

public class PropiedadesTableModel extends BaseTableModel<Propiedad>{

	private static final long serialVersionUID = 1L;
	
	public PropiedadesTableModel() {
		
		super.addColumn("identificador", false, 100);
		super.addColumn("calle", false, 100);
		super.addColumn("altura", false, 100);
		super.addColumn("precio", false, 100);
		
	}

	@Override
	protected Object[] toRow(Propiedad t) {
		
		Object[] fila = {t.getIdentificador(),
						t.getCalle(),
						t.getAltura(),
						t.getPrecioTentativo()};
		
		return fila;
	}
}