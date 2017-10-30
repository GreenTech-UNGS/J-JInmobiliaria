package presentacion.table;

import entities.Usuario;

@SuppressWarnings("serial")
public class UsuariosTableModel extends BaseTableModel<Usuario>{
	
	public UsuariosTableModel(){
		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
		super.addColumn("Email", false, 100);
		super.addColumn("Rol", false, 100);
		super.addColumn("Estado", false, 100);
	}

	@Override
	protected Object[] toRow(Usuario t) {
	
		Object[] fila = {t.getPersona().getNombre(),
				t.getPersona().getApellido(),
				t.getPersona().getEmail(),
				t.getRoles(),
				t.getEstado()};

		return fila;
	}

}
