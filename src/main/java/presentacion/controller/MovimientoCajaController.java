package presentacion.controller;

import java.util.Arrays;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Egreso;
import entities.GastoFijo;
import entities.Ingreso;
import entities.Moneda;
import entities.Precio;
import model.LogicaNegocioException;
import model.MovimientoCajaService;
import presentacion.mappers.EgresoMapper;
import presentacion.mappers.IngresoMapper;
import presentacion.validators.MessageShow;
import presentacion.validators.MovimientoCajaFormValidator;
import presentacion.vista.MovimientoCajaForm;

@Singleton
public class MovimientoCajaController {

	private MovimientoCajaForm view;
	private boolean ingreso;
	
	@Inject	private IngresoMapper ingresoMapper;
	@Inject private EgresoMapper egresoMapper;
	@Inject	private MovimientoCajaService movCajaService;
	@Inject private MovimientoCajaFormValidator validator;
	@Inject private ElegirGastoFijoController elegirGastoFijo;
	@Inject private MessageShow msgShw;
	
	private Ingreso currentIngreso;
	private Egreso currentEgreso;
	
	@Inject
	private MovimientoCajaController(MovimientoCajaForm view) {
		this.view = view;
		
		view.getBtnGuardar().addActionListener(e -> saveMovimiento());
		view.getBtnGastoFijo().addActionListener(e -> desdeGastoFijjo());
		
		fillCombos();
	}
	
	private void desdeGastoFijjo() {
		
		elegirGastoFijo.showView();
		GastoFijo gastoFijo = elegirGastoFijo.getGastoFijo();
		
		currentEgreso.setFecha(DateTime.now());
		currentEgreso.setMonto(new Precio(gastoFijo.getMonto(), Moneda.PESOS));
		currentEgreso.setDetalle("Pago del servicio " + gastoFijo.getNombre());
		
		
	}

	private void fillCombos() {
		view.getMonedaModel().actualize(Arrays.asList(Moneda.values()));
		
	}

	private void saveMovimiento() {
		if(validator.isValid()) {
				ingresoMapper.fillBean(currentIngreso);
				
		
				try {
					if(ingreso)
						movCajaService.saveIngreso(currentIngreso);
					else 
						movCajaService.saveEgreso(currentEgreso);
				} catch (LogicaNegocioException e) {

					msgShw.showErrorMessage(e.getMessage(), "Error");
				}
						
			hideView();
		}
		
		else {
			msgShw.showErrorMessage(validator.getErrorMessage(), "Error");
		}
	}
	
	public void setModeNewEgreso(){
		view.setTitle("Registrar Egreso de Capital");
		view.getBtnGastoFijo().setVisible(false);
		ingreso = false;

		currentEgreso = movCajaService.getNewEgreso();
		egresoMapper.fillFields(currentEgreso);
	}
	
	public void setModeNewIngreso(){
		view.setTitle("Registrar Ingreso de Capital");
		view.getBtnGastoFijo().setVisible(true);
		ingreso = true;
		
		currentIngreso = movCajaService.getNewIngreso();
		ingresoMapper.fillFields(currentIngreso);
	}	
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	public void hideView(){
		this.view.setVisible(false);
	}
	
}
