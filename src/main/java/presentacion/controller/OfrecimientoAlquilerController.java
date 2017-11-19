package presentacion.controller;

import java.text.DecimalFormat;
import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.Precio;
import model.LogicaNegocioException;
import model.OfrecimientoService;
import presentacion.mappers.OfrecimientoAlquilerMapper;
import presentacion.validators.MessageShow;
import presentacion.vista.PrecontratoAlquilerForm;

@Singleton
public class OfrecimientoAlquilerController {

	private PrecontratoAlquilerForm view;
	
	@Inject OfrecimientoAlquilerMapper mapper;
	@Inject private OfrecimientoService ofrecimientoService;
	@Inject private MessageShow msgShw;
	
	private OfrecimientoAlquiler currentOfrecimiento;

    private DecimalFormat df = new DecimalFormat("#.##");
	
	@Inject
	private OfrecimientoAlquilerController(PrecontratoAlquilerForm view) {
		this.view = view;
		
		view.getBtnVerValorEntrada().addActionListener(e -> muestraValorEntrada());
		
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
	
	public void actualizeSellado(float valor){
		
		this.view.getSpinnerSellado().setValue(valor);
		
	}
	
	private void muestraValorEntrada() {
		
		try {
			Precio valor = ofrecimientoService.getPrecioParaEntrar(currentOfrecimiento);
			Precio primerMes = ofrecimientoService.getPrimerMes(currentOfrecimiento);
			Precio deposito = ofrecimientoService.getDeposito(currentOfrecimiento);
			Precio sellado = ofrecimientoService.getSelladoPesos(currentOfrecimiento);
			Precio otros = ofrecimientoService.getOtrosGastos(currentOfrecimiento);
			
			
			String gastosStr = "Primer mes: " + df.format(primerMes.getMonto()) + " " + primerMes.getMoneda()+
					"\nDeposito: " + df.format(deposito.getMonto()) + " " + deposito.getMoneda()+
					"\nSellado: " + df.format(sellado.getMonto()) + " " + sellado.getMoneda()+
					"\nOtros: " + df.format(otros.getMonto()) + " " + otros.getMoneda()+
					"\n**Total**: " + df.format(valor.getMonto()) + " " + valor.getMoneda();
			
			msgShw.showInformationMessage(gastosStr, "Monto para entrar");
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error");
		}
		
		
		
	}
	
	private void fillCombos() {
		this.view.getMonedaBasico().actualize(Arrays.asList(Moneda.values()));
		this.view.getMonedaOtros().actualize(Arrays.asList(Moneda.values()));
	}
	
	
}

