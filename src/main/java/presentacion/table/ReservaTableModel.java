package presentacion.table;

import entities.Reserva;

public class ReservaTableModel extends BaseTableModel<Reserva>{
	
	public ReservaTableModel(){
		super.addColumn("Fecha", false, 100);
		super.addColumn("Reservador", false, 100);
		super.addColumn("Código propiedad", false, 100);
		super.addColumn("Direccion", false, 100);
	}

	@Override
	protected Object[] toRow(Reserva t) {
		String direccion = t.getPropiedad().getCalle() + " " +  t.getPropiedad().getAltura();
		String piso = "";
		String depto = "";
		if(!t.getPropiedad().getPiso().equals("")){
			piso = " Piso:" + t.getPropiedad().getPiso();}
		if(!t.getPropiedad().getDpto().equals("")){
			depto = " Depto:" + t.getPropiedad().getDpto();}
		
		Object[] fila = {t.getFecha().toString("dd/MM/YYYY   HH:mm"),
				t.getReservador().getNombre() + " " + t.getReservador().getApellido(),
				t.getPropiedad().getIdentificador(),
				direccion+piso+depto};
		return fila;
	}

}
