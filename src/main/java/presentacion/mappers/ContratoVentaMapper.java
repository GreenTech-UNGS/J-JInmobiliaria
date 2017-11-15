package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoVenta;
import entities.Moneda;
import presentacion.vista.ContratoVentaForm;

@Singleton
public class ContratoVentaMapper implements Mapper<ContratoVenta>{

	@Inject private ContratoVentaForm view;

	@Override
	public void fillBean(ContratoVenta t) {
		
		String identificador = view.getTfIdContrato().getText();
		float monto = Float.parseFloat(view.getTfMonto().getText());
		Moneda moneda = view.getMonedaCombo().getSelected();
		float comComprador = (float)view.getSpinnerComprador().getValue();
		float comVendedor = (float)view.getSpinnerVendedor().getValue();
		
		t.setIdentificador(identificador);
		t.getMonto().setMonto(monto);
		t.getMonto().setMoneda(moneda);
		t.setComisionComprador(comComprador);
		t.setComisionVendedor(comVendedor);
		
	}

	@Override
	public void fillFields(ContratoVenta t) {
		
		view.getTfIdContrato().setText(t.getIdentificador());
		view.getTfMonto().setText(t.getMonto().getMonto() + "");
		view.getMonedaCombo().setSelected(t.getMonto().getMoneda());
		view.getSpinnerComprador().setValue(t.getComisionComprador());
		view.getSpinnerVendedor().setValue(t.getComisionVendedor());
				
	}
	
}
