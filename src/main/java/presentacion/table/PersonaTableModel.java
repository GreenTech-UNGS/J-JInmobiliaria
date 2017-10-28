package presentacion.table;

import entities.Persona;

@SuppressWarnings("serial")
public class PersonaTableModel extends BaseTableModel<Persona>{

	public PersonaTableModel(){
		
	super.addColumn("Credencial", false, 100);
	super.addColumn("Nombre", false, 100);
	super.addColumn("Apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Persona t) {
		
		String credencial = t.getTipoCred().toString() + " " + t.getCredencial();
		
		Object[] fila = {credencial,
				t.getNombre(),
				t.getApellido()};

		return fila;
	}

}
