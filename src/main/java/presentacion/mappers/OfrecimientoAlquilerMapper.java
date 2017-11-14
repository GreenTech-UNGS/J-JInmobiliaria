package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import presentacion.vista.PrecontratoAlquilerForm;

@Singleton
public class OfrecimientoAlquilerMapper implements Mapper<OfrecimientoAlquiler>{

	@Inject private PrecontratoAlquilerForm view;
	
	@Override
	public void fillBean(OfrecimientoAlquiler t) {
		
		boolean habilitado = view.getChckbxHabilitar().isSelected();
		float precioBascio = Float.parseFloat(view.getTfPrecio().getText());
		float precioOtro = Float.parseFloat(view.getTfMonto().getText());
		Moneda monedaBasico = view.getMonedaBasico().getSelected();
		Moneda monedaOtro = view.getMonedaBasico().getSelected();
		int cantidadMeses = (int)view.getSpinnerMeses().getValue();
		int intervaloMeses = (int)view.getSpinnerIntervalo().getValue();
		float porcentaje = (float)view.getSpinnerPorcentaje().getValue();
		boolean acumulativo = view.getChckbxAcumulativo().isSelected();
		
		t.setHabilitada(habilitado);
		t.getPrecio().setMonto(precioBascio);
		t.getPrecio().setMoneda(monedaBasico);
		t.getOtrosGastos().setMonto(precioOtro);
		t.getOtrosGastos().setMoneda(monedaOtro);
		t.setCantidadMeses(cantidadMeses);
		t.setIntervaloActualizacion(intervaloMeses);
		t.setProcentajeActualizacion(porcentaje);
		t.setAcumulativo(acumulativo);
		
	}

	@Override
	public void fillFields(OfrecimientoAlquiler t) {
		
		view.getChckbxHabilitar().setSelected(t.isHabilitada());
		view.getTfPrecio().setText(t.getPrecio().getMonto() + "");
		view.getTfMonto().setText(t.getOtrosGastos().getMonto() + "");
		view.getMonedaBasico().setSelected(t.getPrecio().getMoneda());
		view.getMonedaBasico().setSelected(t.getOtrosGastos().getMoneda());
		view.getSpinnerMeses().setValue(t.getCantidadMeses());
		view.getSpinnerIntervalo().setValue(t.getIntervaloActualizacion());
		view.getSpinnerPorcentaje().setValue(t.getProcentajeActualizacion());
		view.getChckbxAcumulativo().setSelected(t.isAcumulativo());
		
	}

}
