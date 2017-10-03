package presentacion.table;

import entities.Telefono;

public class TelefonoTableModel extends BaseTableModel<Telefono>{

	
	
	public TelefonoTableModel() {
		addColumn("Numero", false, 100);
		addColumn("Tipo", false, 100);
		addColumn("Notas", false, 100);
	}
	
	@Override
	protected Object[] toRow(Telefono t) {
		
		String notas = t.getNotas() == null? "" : t.getNotas();
		
		Object[] toRet = {t.getNumero(),
						t.getTipo().toString(),
						notas};
		
		
		return toRet;
	}
	
	

}
