package presentacion.mappers;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Egreso;
import entities.Moneda;
import presentacion.vista.MovimientoCajaForm;

@Singleton
public class EgresoMapper implements Mapper<Egreso>{


	@Inject
	private MovimientoCajaForm view;
	
	@Override
	public void fillBean(Egreso t) {
		double monto = Double.parseDouble(view.getTextMonto().getText());
		Moneda moneda = view.getMonedaModel().getSelected();
		String descripcion = view.getTextDetalle().getText();
		
		t.setFecha(DateTime.now());
		t.setDetalle(descripcion);
		t.getMonto().setMoneda(moneda);
		t.getMonto().setMonto(monto);
		
	}

	@Override
	public void fillFields(Egreso t) {
		double monto = t.getMonto().getMonto();
		Moneda moneda = t.getMonto().getMoneda();
		String descripcion = t.getDetalle();
		DateTime fecha = t.getFecha();
		
		view.getTextDetalle().setText(descripcion);
		view.getTextMonto().setText(monto + "");
		view.getMonedaModel().setSelected(moneda);
		view.getDateChooser().setDate(fecha.toDate());
		
	}

}
