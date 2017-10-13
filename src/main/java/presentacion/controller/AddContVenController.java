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
import model.ReservaService;
import presentacion.validators.ContratoVentaValidator;
import presentacion.vista.ContratoVentaForm;

public class AddContVenController {
	
	public static AddContVenController instance;
	private ContratoVentaForm view;
	ElegirClienteController elegirCliente;
	ElegirPropiedadController elegirProp;
	ContratoVenta currentContrato;
	ContratoService contratoService;
	ReservaService reservaService;
	ContratoVentaValidator contratoVentaValidator;
	
	Binder<ContratoVenta> binder;
	
	@Inject
	private AddContVenController(ContratoVentaForm view,
			ElegirClienteController elegirCliente,
			ElegirPropiedadController elegirProp, 
			ContratoService contratoService,
			ReservaService reservaService,
			ContratoVentaValidator contratoVentaValidator){
		
		this.view = view;
		this.elegirCliente = elegirCliente;
		this.elegirProp = elegirProp;
		this.contratoService = contratoService;
		this.reservaService = reservaService;
		this.contratoVentaValidator = contratoVentaValidator;
		
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
			view.getTfCliente().setText("DNI " + cliente.getPersona().getCredencial());
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
		
		currentContrato.setIdentificador(view.getTfIdContrato().getText());
		binder.setObjective(currentContrato);
		binder.fillBean();
		
		Reserva r = reservaService.getReservaOf(currentContrato.getPropiedad());
		if( r != null) {
			if(r.getReservador().getID() != currentContrato.getCliente().getPersona().getID()) {
				JOptionPane.showMessageDialog(view, "La propiedad esta reservada. El cliente debe ser el reservador", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		if(contratoVentaValidator.isValid(currentContrato)){
			contratoService.SaveContratoVenta(currentContrato);
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
