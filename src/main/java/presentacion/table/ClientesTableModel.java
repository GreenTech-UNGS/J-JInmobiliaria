package presentacion.table;

import entities.Cliente;

@SuppressWarnings("serial")
public class ClientesTableModel extends BaseTableModel<Cliente> {
	
	public ClientesTableModel(){
		
	super.addColumn("identificador", false, 100);
	super.addColumn("nombre", false, 100);
	super.addColumn("apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Cliente t) {
		
		Object[] fila = {t.getID(),
				t.getPersona().getNombre(),
				t.getPersona().getApellido()};

return fila;
	}

}
