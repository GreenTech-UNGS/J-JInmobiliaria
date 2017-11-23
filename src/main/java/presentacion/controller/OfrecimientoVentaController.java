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
		
		this.view.getChckbxHabilitar().addActionListener(e -> habilitaCampos());
		
		fillCombos();
	
	}

	public void setEditMode(OfrecimientoVenta ofrecimiento) {
		
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
		
		habilitaCampos();
		
	}
	
	public void setViewMode(OfrecimientoVenta ofrecimiento) {
		this.currentOfrecimiento = ofrecimiento;
		mapper.fillFields(ofrecimiento);
		
		habilitaCampos();
	}
	
	public void save() {
		mapper.fillBean(currentOfrecimiento);
	}
	
	
	private void habilitaCampos() {
		
		boolean isHabilitado = view.getChckbxHabilitar().isSelected();
		
		view.getTfPrecio().setEnabled(isHabilitado);
		view.getSpinnerComprador().setEnabled(isHabilitado);
		view.getSpinnerVendedor().setEnabled(isHabilitado);
		view.getCbMoneda().setEnabled(isHabilitado);
		
	}
	
	private void fillCombos() {
		this.view.getMonedaCombo().actualize(Arrays.asList(Moneda.values()));
	}
	
	public boolean isSelected(){
		if(view.getChckbxHabilitar().isSelected()){
			return true;
		}
		return false;
	}
}
