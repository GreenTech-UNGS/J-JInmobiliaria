package presentacion.table;

import entities.CuotaAlquiler;

@SuppressWarnings("serial")
public class CuotasTableModel extends BaseTableModel<CuotaAlquiler> {
	
	public CuotasTableModel(){
		
	super.addColumn("DNI Inquilino", false, 100);
	super.addColumn("ID Propiedad", false, 100);
	super.addColumn("ID Contrato", false, 100);
	super.addColumn("Valor", false, 100);
	}

	@Override
	protected Object[] toRow(CuotaAlquiler t) {
		
		double temp = t.getMonto().getMonto();
		String valor = t.getMonto().getMoneda().toString() + temp;
		
		Object[] fila = {
				t.getContrato().getCliente().getPersona().getCredencial(),
				t.getContrato().getPropiedad().getIdentificador(),
				t.getContrato().getID(),
				valor,
		};

		return fila;
	}

}
