package presentacion.table;

import entities.Reserva;

public class ReservaTableModel extends BaseTableModel<Reserva>{
	
	public ReservaTableModel(){
		super.addColumn("Fecha", false, 100);
		super.addColumn("Id reservador", false, 100);
		super.addColumn("Nombre reservador", false, 100);
		super.addColumn("Apellido resrvador", false, 100);
		super.addColumn("Id propiedad", false, 100);
	}

	@Override
	protected Object[] toRow(Reserva t) {
		Object[] fila = {t.getFecha(),
				t.getReservador().getID(),
				t.getReservador().getNombre(),
				t.getReservador().getApellido(),
				t.getPropiedad().getIdentificador()};
		return fila;
	}

}
