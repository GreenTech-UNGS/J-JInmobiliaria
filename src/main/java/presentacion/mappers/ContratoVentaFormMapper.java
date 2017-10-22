package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoVenta;
import presentacion.vista.ContratoVentaForm;

@Singleton
public class ContratoVentaFormMapper implements Mapper<ContratoVenta> {
	
	ContratoVentaForm view;
	
	@Inject
	private ContratoVentaFormMapper(ContratoVentaForm view) {
		this.view = view;
	}

	@Override
	public void fillBean(ContratoVenta t) {
		String id = view.getTfIdContrato().getText();
		String garantia = view.getTfGarantia().getText();
		
		t.setIdentificador(id);
		t.setGarantia(garantia);
		
	}

	@Override
	public void fillFields(ContratoVenta t) {
		
		String id = t.getIdentificador();
		String garantia = t.getGarantia();
		
		view.getTfIdContrato().setText(id);
		view.getTfGarantia().setText(garantia);
	}

}
