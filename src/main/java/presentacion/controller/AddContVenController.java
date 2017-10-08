package presentacion.controller;

import com.google.inject.Inject;

import entities.Cliente;
import entities.ContratoVenta;
import entities.Propiedad;
import model.ContratoService;
import presentacion.vista.AddContratoVen;

public class AddContVenController {
	
	public static AddContVenController instance;
	private AddContratoVen view;
	ElegirClienteController elegirCliente;
	ElegirPropiedadController elegirProp;
	ContratoVenta currentContrato;
	ContratoService contratoService;
	
	@Inject
	private AddContVenController(AddContratoVen view,
			ElegirClienteController elegirCliente,
			ElegirPropiedadController elegirProp, 
			ContratoService contratoService){
		
		this.view = view;
		this.elegirCliente = elegirCliente;
		this.elegirProp = elegirProp;
		this.contratoService = contratoService;
		
		view.getBtnCancelarContVen().addActionListener(e -> view.setVisible(false));
		view.getBtnBuscarCliente().addActionListener(e -> elegirCliente());
		view.getBtnBuscarPropiedad().addActionListener(e -> elegirPropiedad());
		view.getBtnGuardarContVen().addActionListener(e -> guardarContrato());
		
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
	
	private void elegirCliente(){
		
		elegirCliente.showView();
		Cliente cliente = elegirCliente.getCliente();
		if (cliente != null){
			view.getTfCliente().setText("DNI " + cliente.getPersona().getCredencial());
			currentContrato.setCliente(cliente);
			}
		}

	private void elegirPropiedad(){
		
		elegirProp.showView();
		Propiedad propiedad = elegirProp.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfPropiedad().setText(propiedad.getIdentificador());
			view.getTfPrecio().setText(String.valueOf(propiedad.getPrecioTentativo().getMonto()));
			view.getTfMoneda().setText(propiedad.getPrecioTentativo().getMoneda().toString());
			currentContrato.setPropiedad(propiedad);
		}	
	}
	
	public void guardarContrato(){
		
		//falta validador
		currentContrato.setIdentificador(view.getTfIdContrato().getText());
		contratoService.SaveContratoVenta(currentContrato);
		view.setVisible(false);
	}
	
	public void setModeNew(){
		
		currentContrato = contratoService.getNewContratoVenta();
	}
	
}
