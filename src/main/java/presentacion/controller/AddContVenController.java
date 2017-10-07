package presentacion.controller;

import com.google.inject.Inject;

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
			ElegirPropiedadController elegirProp){
		
		this.view = view;
		this.elegirCliente = elegirCliente;
		this.elegirProp = elegirProp;
		
		view.getBtnCancelarContVen().addActionListener(e -> view.setVisible(false));
		view.getBtnBuscarCliente().addActionListener(e -> elegirCliente());
		view.getBtnBuscarPropiedad().addActionListener(e -> elegirPropiedad());
	}
	
	public void showView(){
			
			view.setVisible(true);
		}
	
	private void elegirCliente(){
		elegirCliente.showView();
		//poner el id del cliente en el tf cuando se pueda agregar clientes
	}
	
	private void elegirPropiedad(){
		elegirProp.showView();
		
		Propiedad propiedad = elegirProp.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfPropiedad().setText(propiedad.getIdentificador());
			//llenar tf de precio o se pone a mano o qué
			currentContrato.setPropiedad(propiedad);
		}	
	}
	
	public void guardarContrato(){
		
		//falta validador
		contratoService.SaveContratoVenta(currentContrato);
	}
	
	public void setModeNew(){
		currentContrato = contratoService.getNewContratoVenta();
	}
}
