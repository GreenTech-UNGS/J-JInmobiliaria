package presentacion.table;

import com.google.inject.Inject;

import entities.Contrato;
import model.ContratoService;

@SuppressWarnings("serial")
public class ContratosEscritorioTableModel extends BaseTableModel<Contrato>{
	
	@Inject ContratoService contratoService;
	
	public ContratosEscritorioTableModel(){
		
		super.addColumn("Codigo contrato", false, 100);
		super.addColumn("Cliente ", false, 100);
		super.addColumn("Codigo propiedad", false, 100);
		
	}

	@Override
	protected Object[] toRow(Contrato t) {
		
		String cliente = "";
		if(t.getCliente() != null)
			cliente += t.getCliente().getPersona().getApellido() + 
						" " + t.getCliente().getPersona().getNombre() +
						" " + t.getCliente().getPersona().getTipoCred().toString() + 
						" " + t.getCliente().getPersona().getCredencial();
		
		String propiedad = "";	

	
		
		if(t.getPropiedad() != null)
			propiedad += t.getPropiedad().getIdentificador();
		
		Object[] fila = {t.getIdentificador(),
				cliente,
				propiedad};
		return fila;
	}

}
