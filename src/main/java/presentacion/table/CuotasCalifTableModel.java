package presentacion.table;

import java.text.DecimalFormat;

import com.google.inject.Inject;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;
import model.CuotaService;

@SuppressWarnings("serial")
public class CuotasCalifTableModel extends BaseTableModel<CuotaAlquiler> {
	
	@Inject CuotaService cuotaService;
	
	@Inject
	public CuotasCalifTableModel(){
		
		super.addColumn("N° de cuota", false, 100);
		super.addColumn("DNI Inquilino", false, 100);
		super.addColumn("Calificacion inquilino", false, 100);
		super.addColumn("Codigo Propiedad", false, 100);
		super.addColumn("Total", false, 100);
		super.addColumn("Estado", false, 100);
	}

	@Override
	protected Object[] toRow(CuotaAlquiler t) {
		
		double temp = t.getMonto().getMonto();
		String valor = t.getMonto().getMoneda().toString()+ " " + temp;
		
		String credencial = t.getContrato().getCliente().getPersona().getTipoCred().toString() + " " +
					t.getContrato().getCliente().getPersona().getCredencial();
		
		InteresPunitorioCuota interes = cuotaService.getInteresOf(t);
		
		DecimalFormat format = new DecimalFormat("#.##");
		
		String totalStr = interes==null? valor : interes.getMonto().getMoneda().toString() + " " +
						format.format(interes.getMonto().getMonto() + t.getMonto().getMonto());
		
		Object[] fila = {
				t.getAnioMes(),
				credencial,
				t.getContrato().getCliente().getCalificacion(),
				t.getContrato().getPropiedad().getIdentificador(),
				totalStr,
				cuotaService.getEstadoOf(t).toString()
		};

		return fila;
	}

}
