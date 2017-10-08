package presentacion.table;

import com.google.inject.Inject;

import entities.Inmobiliaria;
import model.InmobiliariaService;

@SuppressWarnings("serial")
public class InmobiliariaTableModel extends BaseTableModel<Inmobiliaria> {
	
	@Inject
	InmobiliariaService inmobiliariaService;
	
	@Inject
	public InmobiliariaTableModel(){
		super.addColumn("CUIT", false, 100);
		super.addColumn("Nombre", false, 100);
	}

	@Override
	protected Object[] toRow(Inmobiliaria t) {
		Object[] fila = {t.getCUIT(),
				t.getNombre()};
		return fila;
	}

}
