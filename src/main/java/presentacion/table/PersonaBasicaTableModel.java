package presentacion.table;

import entities.PersonaBasica;

public class PersonaBasicaTableModel extends BaseTableModel<PersonaBasica>{

	public PersonaBasicaTableModel() {

		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
	}
	
	@Override
	protected Object[] toRow(PersonaBasica t) {
		
		Object[] toRet = {t.getNombre(), t.getApellido()};
		
		return toRet;
	}

}
