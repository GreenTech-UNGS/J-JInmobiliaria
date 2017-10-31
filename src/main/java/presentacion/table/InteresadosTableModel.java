package presentacion.table;

import entities.Interesado;

@SuppressWarnings("serial")
public class InteresadosTableModel extends BaseTableModel<Interesado> {
	
	public InteresadosTableModel(){
		
		super.addColumn("Credencial", false, 100);
		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
	}

	@Override
	protected Object[] toRow(Interesado t) {
		
		String credencial = t.getPersona().getTipoCred().toString() + " " + t.getPersona().getCredencial();
		
		Object[] fila = {credencial,
				t.getPersona().getNombre(),
				t.getPersona().getApellido(),
				"yolo"};

		return fila;
	}
}
