package presentacion.controller;

import javax.swing.JOptionPane;

import com.google.inject.Inject;

import entities.Cliente;
import entities.ContratoVenta;
import entities.Moneda;
import entities.Propiedad;
import entities.Reserva;
import misc.Binder;
import model.ContratoService;
import model.LogicaNegocioException;
import model.ReservaService;
import presentacion.validators.ContratoVentaFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.ContratoVentaForm;

public class ContratoVentaController {
	
	public static ContratoVentaController instance;
	private ContratoVentaForm view;
	ElegirClienteController elegirCliente;
	ElegirPropiedadController elegirProp;
	ContratoVenta currentContrato;
	ContratoService contratoService;
	ReservaService reservaService;
	
	@Inject
	ContratoVentaFormValidator contratoVentaValidator;
	
	Binder<ContratoVenta> binder;
	
	MessageShow msgShw;
	
	@Inject
	private ContratoVentaController(ContratoVentaForm view,
			ElegirClienteController elegirCliente,
			ElegirPropiedadController elegirProp, 
			ContratoService contratoService,
			ReservaService reservaService,
			MessageShow msgShw){
		
		this.view = view;
		this.elegirCliente = elegirCliente;
		this.elegirProp = elegirProp;
		this.contratoService = contratoService;
		this.reservaService = reservaService;
		this.msgShw = msgShw;
		
		this.binder = new Binder<>();
		
		view.getBtnCancelarContVen().addActionListener(e -> view.setVisible(false));
		view.getBtnBuscarCliente().addActionListener(e -> elegirCliente());
		view.getBtnBuscarPropiedad().addActionListener(e -> elegirPropiedad());
		view.getBtnGuardarContVen().addActionListener(e -> guardarContrato());

		binder.bind("monto.monto", () -> Double.parseDouble(view.getTfMonto().getText()),
				v -> view.getTfMonto().setText(v.toString()));
		binder.bind("monto.moneda", () -> Moneda.valueOf(view.getTfMoneda().getText()),
				t -> view.getTfMoneda().setText(t.toString()));
		binder.bind("garantia", view.getTfGarantia()::getText,
				t -> view.getTfGarantia().setText((String)t));
		
		binder.bind("identificador", view.getTfIdContrato());
		binder.bind("gastosAdmin",
				view.getSpinnerPorcentaje()::getValue,
				f -> view.getSpinnerPorcentaje().setValue(f));
		
	}
	
	public void showView(){
			
			view.setVisible(true);
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
			view.getTfPrecio().setText(String.valueOf(propiedad.getPrecioTentativo().getMonto()));
			view.getTfMoneda().setText(propiedad.getPrecioTentativo().getMoneda().toString());
			currentContrato.setPropiedad(propiedad);
		}	
	}
	
	public void guardarContrato(){
		
		//tendria que pasar por el validador
		if(!view.getTfIdContrato().equals("")){		
			currentContrato.setIdentificador(view.getTfIdContrato().getText());
			binder.setObjective(currentContrato);
			binder.fillBean();
			
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
		binder.setObjective(currentContrato);
		binder.fillFields();
		
		view.getTfCliente().setText("");
		view.getTfPropiedad().setText("");
	}
	
}
