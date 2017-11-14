package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoVenta;
import presentacion.vista.PrecontratoVentaForm;

@Singleton
public class OfrecimientoVentaMapper implements Mapper<OfrecimientoVenta>{

	@Inject private PrecontratoVentaForm view;
	
	@Override
	public void fillBean(OfrecimientoVenta t) {
		
		boolean habilitado = view.getChckbxHabilitar().isSelected();
		float precio = Float.parseFloat(view.getTfPrecio().getText());
		Moneda moneda = view.getMonedaCombo().getSelected();
		float comisionComprador = (float)view.getSpinnerComprador().getValue();
		float comisionVendedor = (float)view.getSpinnerVendedor().getValue();
		
		t.getPrecio().setMonto(precio);
		t.getPrecio().setMoneda(moneda);
		t.setComisionComprador(comisionComprador);
		t.setComisionVendedor(comisionVendedor);
		t.setHabilitada(habilitado);
	}

	
	@Override
	public void fillFields(OfrecimientoVenta t) {
		
		view.getChckbxHabilitar().setSelected(t.isHabilitada());
		view.getTfPrecio().setText(t.getPrecio().getMonto() + "");
		view.getMonedaCombo().setSelected(t.getPrecio().getMoneda());
		view.getSpinnerComprador().setValue(t.getComisionComprador());
		view.getSpinnerVendedor().setValue(t.getComisionVendedor());
		
		
	}

}
