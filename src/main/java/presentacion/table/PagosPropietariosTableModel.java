package presentacion.table;

import entities.PagoPropietario;

import java.text.DecimalFormat;

public class PagosPropietariosTableModel extends BaseTableModel<PagoPropietario>{

	
	public PagosPropietariosTableModel() {
		super.addColumn("Propietario", false, 100);
		super.addColumn("Inmobiliaria", false, 100);
		super.addColumn("Monto", false, 100);
		super.addColumn("Estado", false, 100);
	}
	
	@Override
	protected Object[] toRow(PagoPropietario t) {

		String propietarioStr = "";
		
		if(t.getPropietario() != null)
			propietarioStr = getString(t.getPropietario().getPersona().getTipoCred().toString() + " " +
						t.getPropietario().getPersona().getCredencial());

		String inmobiliariaStr = "";
		if(t.getInmobiliaria() != null)
			inmobiliariaStr = getString(t.getInmobiliaria().getNombre());
		
		DecimalFormat format = new DecimalFormat("#.##");
		
		String monto = t.getMonto().getMoneda().toString() + " " + format.format(t.getMonto().getMonto());

		
		Object[] toRet = {propietarioStr,
				inmobiliariaStr,
				monto,
				t.getEstado().toString()};
		
		return toRet;
		
	}
	
	private String getString(String string){
		
		if(string == null)
			return "";
		
		return string;
	}

}
