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
		
		super.addColumn("Credencial", false, 100);
		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Propietario t) {
		
		String credencial = t.getPersona().getTipoCred().toString() + " " + t.getPersona().getCredencial();
		
		Object[] fila = {credencial,
				t.getPersona().getNombre(),
				t.getPersona().getApellido()};

		return fila;
	}

}
