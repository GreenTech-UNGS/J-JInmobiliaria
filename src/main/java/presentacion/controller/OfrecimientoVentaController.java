package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.OfrecimientoVenta;
import presentacion.mappers.OfrecimientoVentaMapper;
import presentacion.vista.PrecontratoVentaForm;

@Singleton
public class OfrecimientoVentaController {

	@Inject private PrecontratoVentaForm view;
	
	@Inject private OfrecimientoVentaMapper mapper;
	
	private OfrecimientoVenta currentOfrecimiento;
	
	@Inject
	private OfrecimientoVentaController(PrecontratoVentaForm view) {
		
		this.view = view;
	
	}
	
	public void setEditMode(OfrecimientoVenta ofrecimiento) {
		
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
		
	}
	
	public void setViewMode(OfrecimientoVenta ofrecimiento) {
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
	}
	
	public void save() {
		mapper.fillBean(currentOfrecimiento);
	}
	
	private void fillCombos() {
		this.view.getMonedaCombo().actualize(Arrays.asList(Moneda.values()));
	}
	
}
