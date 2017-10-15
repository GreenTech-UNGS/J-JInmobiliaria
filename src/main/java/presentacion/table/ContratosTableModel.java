package presentacion.table;

import entities.Contrato;

@SuppressWarnings("serial")
public class ContratosTableModel extends BaseTableModel<Contrato>{
	
	public ContratosTableModel(){
		
		super.addColumn("Codigo contrato", false, 100);
		super.addColumn("Nombre cliente", false, 100);
		super.addColumn("Apellido cliente", false, 100);
		super.addColumn("Dni cliente", false, 100);
		super.addColumn("Codigo propiedad", false, 100);
	}

	@Override
	protected Object[] toRow(Contrato t) {
		Object[] fila = {t.getIdentificador(),
				t.getCliente().getPersona().getNombre(),
				t.getCliente().getPersona().getApellido(),
				t.getCliente().getPersona().getCredencial(),
				t.getPropiedad().getIdentificador()};
		return fila;
	}

}
