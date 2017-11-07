package presentacion.table;

import entities.Cartel;

public class CartelesTableModel extends BaseTableModel<Cartel>{

	public CartelesTableModel() {

		super.addColumn("Codigo", false, 100);
		super.addColumn("Monto", false, 100);
		super.addColumn("Medidas", false, 100);
		super.addColumn("Descripcion", false, 100);
	}
	
	@Override
	protected Object[] toRow(Cartel t) {

		String medidas = t.getAlto() + " cm. x " + t.getAncho() + "cm.";

		Object[] toRet = {
				t.getIdentificador(),
				t.getMonto(),
				medidas,
				t.getDescripcion()
				
		};
		
		return toRet;
		
	}

}
