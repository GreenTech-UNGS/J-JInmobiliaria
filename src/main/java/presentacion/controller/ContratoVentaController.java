package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;

import entities.Cliente;
import entities.ContratoVenta;
import entities.Moneda;
import entities.OfrecimientoVenta;
import entities.Propiedad;
import misc.Binder;
import model.ContratoService;
import model.LogicaNegocioException;
import model.ReservaService;
import presentacion.mappers.ContratoVentaMapper;
import presentacion.validators.ContratoVentaFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.ContratoVentaForm;

public class ContratoVentaController {
	
	private ContratoVentaForm view;
	@Inject private ElegirClienteController elegirCliente;
	@Inject private ElegirPropiedadController elegirProp;
	@Inject private ContratoService contratoService;
	@Inject private ReservaService reservaService;

	@Inject private ContratoVentaFormValidator contratoVentaValidator;
	@Inject private ContratoVentaMapper mapper;
	
	@Inject private MessageShow msgShw;

	private ContratoVenta currentContrato;
	
	@Inject
	private ContratoVentaController(ContratoVentaForm view){
		
		this.view = view;
		
		view.getBtnCancelarContVen().addActionListener(e -> view.setVisible(false));
		view.getBtnBuscarCliente().addActionListener(e -> elegirCliente());
		view.getBtnBuscarPropiedad().addActionListener(e -> elegirPropiedad());
		view.getBtnGuardarContVen().addActionListener(e -> guardarContrato());

		
	}
	
	public void showView(){
		fillCombos();	
		view.setVisible(true);
	}
	
	private void fillCombos() {
		view.getMonedaCombo().clearAndActualize(Arrays.asList(Moneda.values()));
		
	}

	private void elegirCliente(){
		
		elegirCliente.showView();
		Cliente cliente = elegirCliente.getCliente();
		if (cliente != null){
			view.getTfCliente().setText(cliente.getPersona().getNombre() + " " + cliente.getPersona().getApellido());
			currentContrato.setCliente(cliente);
			}
		}

	private void elegirPropiedad(){
		
		elegirProp.showViewVenta();
		Propiedad propiedad = elegirProp.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfPropiedad().setText(propiedad.getIdentificador());
			currentContrato.setPropiedad(propiedad);
			
			llenaDatosOfrecimiento();
		}	
	}
	
	private void llenaDatosOfrecimiento() {
		
		OfrecimientoVenta o = currentContrato.getPropiedad().getOfrecimientoVenta();
		
		view.getTfPrecio().setText(o.getPrecio().getMonto() + "");
		view.getMonedaCombo().setSelected(o.getPrecio().getMoneda());
		view.getSpinnerComprador().setValue(o.getComisionComprador());
		view.getSpinnerVendedor().setValue(o.getComisionVendedor());
		
	}

	public void guardarContrato(){
		
		//tendria que pasar por el validador
		if(!view.getTfIdContrato().equals("")){		
			currentContrato.setIdentificador(view.getTfIdContrato().getText());
			mapper.fillBean(currentContrato);
			
			try {
				contratoService.saveContratoVenta(currentContrato);
				view.setVisible(false);
				
			} catch (LogicaNegocioException e) {
				
				msgShw.showErrorMessage(e.getMessage(), "Error");
			}
			view.setVisible(false);
		}
		

	}
	
	public void setModeNew(){
		
		currentContrato = contratoService.getNewContratoVenta();
		
		mapper.fillFields(currentContrato);
		
		view.getTfCliente().setText("");
		view.getTfPropiedad().setText("");
	}
	
}
