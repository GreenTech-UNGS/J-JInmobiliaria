package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import presentacion.mappers.OfrecimientoAlquilerMapper;
import presentacion.vista.PrecontratoAlquilerForm;

@Singleton
public class OfrecimientoAlquilerController {

	private PrecontratoAlquilerForm view;
	
	@Inject OfrecimientoAlquilerMapper mapper;
	
	private OfrecimientoAlquiler currentOfrecimiento;
	
	@Inject
	private OfrecimientoAlquilerController(PrecontratoAlquilerForm view) {
		this.view = view;
		
		fillCombos();
	}
	
	public void setEditMode(OfrecimientoAlquiler ofrecimiento) {
		
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
		
	}
	
	public void setViewMode(OfrecimientoAlquiler ofrecimiento) {
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
	}
	
	public void save() {
		mapper.fillBean(currentOfrecimiento);
	}
	
	private void fillCombos() {
		this.view.getMonedaBasico().actualize(Arrays.asList(Moneda.values()));
		this.view.getMonedaOtros().actualize(Arrays.asList(Moneda.values()));
	}
	
	
}

