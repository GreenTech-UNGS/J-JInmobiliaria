package presentacion.controller;

import java.time.Period;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cliente;
import entities.Contrato;
import entities.ContratoAlquiler;
import entities.Moneda;
import entities.Propiedad;
import entities.Reserva;
import entities.TipoContratoAlquiler;
import misc.Binder;
import model.ContratoService;
import model.PropiedadService;
import model.ReservaService;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;
import presentacion.validators.ContratoAlquilerValidator;
import presentacion.vista.AddContratoAlq;

@Singleton
public class AddContAlqController {
	
	ContratoService contratoService;
	ReservaService reservaService;
	@Inject
	AddContratoAlq view;
	ElegirClienteController eligeCliente;
	ElegirPropiedadController elegirPropiedadController;
	
	Binder<ContratoAlquiler> binder;
	ContratoAlquiler currentContrato;
	ContratoAlquilerValidator contratoAlquilerValidator;
	
	TipoContratoAlqComboBoxModel tipoCombo;
	MonedaComboBoxModel monedaCombo;
	
	@Inject
	private AddContAlqController(ContratoService contratoService,
								AddContratoAlq view,
								ReservaService reservaService,
								ElegirClienteController eligeCliente,
								ContratoAlquilerValidator contratoAlquilerValidator,
								ElegirPropiedadController elegirPropiedadController) {
		
		this.contratoService = contratoService;
		this.view = view;
		this.eligeCliente = eligeCliente;
		this.contratoAlquilerValidator = contratoAlquilerValidator;
		this.reservaService = reservaService;
		this.elegirPropiedadController = elegirPropiedadController;
		
		tipoCombo = new TipoContratoAlqComboBoxModel();
		monedaCombo = new MonedaComboBoxModel();
		
		this.binder = new Binder<>();
		initBinder();
		
		view.getBtnGuardarContrato().addActionListener(e -> guardaContrato());
		view.getBtnLupaCliente().addActionListener(e -> seleccionaCliente());
		view.getBtnLupaPropiedad().addActionListener(e -> seleccionaPropiedad());
		view.getBtnCancelarContrato().addActionListener(e -> view.setVisible(false));
		view.getBtnRenovarContrato().addActionListener(e -> renovarContrato());
		

		fillCombos();
	}

	private void initBinder() {
		
		binder.bind("identificador", view.getTextIdContrato());
		
		binder.bind("garantia",
				view.getTextGarantia()::getText,
				t -> view.getTextGarantia().setText((String)t));
		
		binder.bind("tipoContratoAlquiler",
				tipoCombo::getSelected,
				t -> tipoCombo.setSelected((TipoContratoAlquiler)t));
		
		binder.bind("cantMeses",
				view.getSpinnerDuracionContrato()::getValue,
				i -> view.getSpinnerDuracionContrato().setValue(i));
		
		binder.bind("gastosAdmin",
				view.getSpinnerGastosAdmin()::getValue,
				f -> view.getSpinnerGastosAdmin().setValue(f));
		
		binder.bind("cuotaMensual.monto",
				() -> Float.parseFloat(view.getTextPrecio().getText()),
				f -> view.getTextPrecio().setText(f.toString()));
		
		binder.bind("cuotaMensual.moneda",
				monedaCombo::getSelected,
				m -> monedaCombo.setSelected((Moneda)m));
		
		binder.bind("datoActualizacion.porcentaje",
				view.getSpinnerPorcenajeActualiza()::getValue,
				f -> view.getSpinnerPorcenajeActualiza().setValue(f));
		
		binder.bind("datoActualizacion.actualizacionMeses",
				view.getSpinnerActualizaContrato()::getValue,
				f -> view.getSpinnerActualizaContrato().setValue(f));
		
		binder.bind("datoActualizacion.isAcumulativo",
				view.getChckbxAcumulativoActualiza()::isSelected,
				b -> view.getChckbxAcumulativoActualiza().setSelected((Boolean)b));
		
		binder.bind("datoPunitorio.porcentaje",
				view.getSpinnerPorcentajePunitorio()::getValue,
				f -> view.getSpinnerPorcentajePunitorio().setValue(f));
		
		binder.bind("datoPunitorio.diasDePago",
				view.getSpinnerTiempoPago()::getValue,
				f -> view.getSpinnerTiempoPago().setValue(f));
		
		binder.bind("datoPunitorio.isAcumulativo",
				view.getChkbxAcumulativoPunitorio()::isSelected,
				b -> view.getChkbxAcumulativoPunitorio().setSelected((Boolean)b));
		
	}
	
	private void bindAvisos() {
		
		AvisoNotificacion intimacion = new AvisoNotificacion();
		AvisoNotificacion vencimiento = new AvisoNotificacion();
		
		intimacion.setHabilitado(view.getChckbxIntimacion().isSelected());
		vencimiento.setHabilitado(view.getChckbxIntimacion().isSelected());
		
		String intimacionDiasStr = view.getSpinnerIntimacionEmail().getValue().toString();
		String vencimientoMesesStr = view.getSpinnerVencimientoEmail().getValue().toString();
		
		intimacion.setPeriodo(Period.ofDays(Integer.parseInt(intimacionDiasStr)));
		vencimiento.setPeriodo(Period.ofMonths(Integer.parseInt(vencimientoMesesStr)));
		
		currentContrato.setAvisoIntimacion(intimacion);
		currentContrato.setAvisoProxVencer(vencimiento);
		
	}
	
	private void seleccionaCliente() {
		eligeCliente.showView();
		Cliente cliente = eligeCliente.getCliente();
		
		if(cliente != null) {
			String credencial = cliente.getPersona().getTipoCred().toString() + " " +
								cliente.getPersona().getCredencial();
			
			view.getTfDniInquilino().setText(credencial);
			
			currentContrato.setCliente(cliente);
		}
	}
	
	private void seleccionaPropiedad() {
		elegirPropiedadController.showViewProp();
		Propiedad propiedad = elegirPropiedadController.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfIdPropiedad().setText(propiedad.getIdentificador());
			
			currentContrato.setPropiedad(propiedad);
			
			view.getTextPrecio().setText(propiedad.getPrecioTentativo().getMonto() + "");
			
		}
	}
	
	private void guardaContrato() {
		
		binder.fillBean();
		bindAvisos();
		Reserva r = reservaService.getReservaOf(currentContrato.getPropiedad());
		if( r != null) {
			if(r.getReservador().getID() != currentContrato.getCliente().getPersona().getID()) {
				JOptionPane.showMessageDialog(view, "La propiedad esta reservada. El cliente debe ser el reservador", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(contratoAlquilerValidator.isValid(currentContrato)){

			contratoService.saveContratoAlquiler(currentContrato);
			closeView();
		}
		closeView();		
	}
	
	public void renovarContrato() {
		
		binder.fillBean();
		bindAvisos();
		
		contratoService.saveContratoAlquiler(currentContrato);
		closeView();
		
	}
	
	private void fillCombos() {
		
		this.view.getComboTipoContrato().setModel(tipoCombo);
		tipoCombo.actualize(Arrays.asList(TipoContratoAlquiler.values()));
		
		this.view.getComboMoneda().setModel(monedaCombo);
		monedaCombo.actualize(Arrays.asList(Moneda.values()));
		
	}

	public void setModeNew() {
		
		view.getTfIdPropiedad().setText("");
		view.getTfIdPropiedad().setText("");
		
		view.getBtnLupaPropiedad().setEnabled(true);
		view.getBtnLupaCliente().setEnabled(true);
		
		view.getBtnGuardarContrato().setVisible(true);
		view.getBtnCancelarContrato().setVisible(true);
		view.getBtnRenovarContrato().setVisible(false);
		
		currentContrato = contratoService.getNewContratoAlquiler();
		binder.setObjective(currentContrato);
		binder.fillFields();
		
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public void closeView() {
		this.view.setVisible(false);
	}

	
	public void setRenovarMode(ContratoAlquiler c){
		
		view.getBtnLupaPropiedad().setEnabled(false);
		view.getBtnLupaCliente().setEnabled(false);
		
		view.getBtnGuardarContrato().setVisible(false);
		view.getBtnCancelarContrato().setVisible(false);
		view.getBtnRenovarContrato().setVisible(true);
		
		currentContrato = contratoService.getActualizacionOf(c);
		
		binder.setObjective(currentContrato);
		
		binder.fillFields();

		showView();
		
		}
}
