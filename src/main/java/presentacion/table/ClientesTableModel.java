package presentacion.table;

import entities.Cliente;

@SuppressWarnings("serial")
public class ClientesTableModel extends BaseTableModel<Cliente> {
	
	public ClientesTableModel(){
		
	super.addColumn("Credencial", false, 100);
	super.addColumn("Nombre", false, 100);
	super.addColumn("Apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Cliente t) {
		
		String credencial = t.getPersona().getTipoCred().toString() + " " + t.getPersona().getCredencial();
		
		Object[] fila = {credencial,
				t.getPersona().getNombre(),
				t.getPersona().getApellido()};

		return fila;
	}

}
