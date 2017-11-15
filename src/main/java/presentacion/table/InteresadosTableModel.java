package presentacion.table;

import entities.Interesado;

@SuppressWarnings("serial")
public class InteresadosTableModel extends BaseTableModel<Interesado> {
	
	public InteresadosTableModel(){
		
		super.addColumn("Fecha", false, 100);
		super.addColumn("Nombre", false, 100);
		super.addColumn("Apellido", false, 100);
		super.addColumn("Operacion", false, 100);
	}

	@Override
	protected Object[] toRow(Interesado t) {
		
		String credencial = t.getPersona().getTipoCred().toString() + " " + t.getPersona().getCredencial();
		
		Object[] fila = {"Fecha de alta",
				t.getPersona().getNombre(),
				t.getPersona().getApellido(),
				t.getPreferencia().getTipoOfrecimiento().toString(),
				"yolo"};

		return fila;
	}
}
