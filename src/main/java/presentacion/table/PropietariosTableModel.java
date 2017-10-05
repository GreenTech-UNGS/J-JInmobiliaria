package presentacion.table;

import com.google.inject.Inject;

import entities.Propietario;
import model.PropietarioService;

@SuppressWarnings("serial")
public class PropietariosTableModel extends BaseTableModel<Propietario>{
	
	@Inject 
	PropietarioService propietarioService;
	
	@Inject
	public PropietariosTableModel() {
		
		super.addColumn("Identificador", false, 100);
		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Propietario t) {
		Object[] fila = {t.getID(),
				t.getPersona().getNombre(),
				t.getPersona().getApellido()};

		return fila;
	}

}
