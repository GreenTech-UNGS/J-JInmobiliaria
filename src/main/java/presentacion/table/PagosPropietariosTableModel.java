package presentacion.table;

import java.text.DecimalFormat;

import entities.PagoPropietario;

public class PagosPropietariosTableModel extends BaseTableModel<PagoPropietario>{

	
	public PagosPropietariosTableModel() {
		super.addColumn("Propietario", false, 100);
		super.addColumn("Monto", false, 100);
		super.addColumn("Estado", false, 100);
	}
	
	@Override
	protected Object[] toRow(PagoPropietario t) {
		
		String propietarioStr = t.getPropietario().getPersona().getTipoCred().toString() + " " +
						t.getPropietario().getPersona().getCredencial();
		
		DecimalFormat format = new DecimalFormat("#.##");
		
		String monto = t.getMonto().getMoneda().toString() + " " + format.format(t.getMonto().getMonto());

		
		Object[] toRet = {propietarioStr,
				monto,
				t.getEstado().toString()};
		
		return toRet;
		
	}

}
