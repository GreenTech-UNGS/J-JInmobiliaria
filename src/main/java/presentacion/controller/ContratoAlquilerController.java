package presentacion.controller;

import java.util.Arrays;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.ContratoAlquiler;
import entities.EstadoContrato;
import entities.HistoriaEstadoContrato;
import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.Propiedad;
import entities.TipoContratoAlquiler;
import model.ContratoService;
import model.LogicaNegocioException;
import presentacion.mappers.ContratoAlquilerFormMapper;
import presentacion.validators.ContratoAlquilerFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.ContratoAlquilerForm;

@Singleton
public class ContratoAlquilerController {

	private ContratoAlquilerForm view;
	@Inject private ContratoService contratoService;
	@Inject private ElegirClienteController eligeCliente;
	@Inject private ElegirPropiedadController elegirPropiedadController;
	@Inject private ContratoAlquilerFormMapper mapper;
	@Inject private VerCuotasContratoController verCuotasController;
	
	private ContratoAlquiler currentContrato;
	@Inject private ContratoAlquilerFormValidator contratoAlquilerValidator;
	
	@Inject private MessageShow msgShw;
	
	@Inject
	private ContratoAlquilerController(ContratoAlquilerForm view) {
		
		this.view = view;
		
		view.getBtnGuardarContrato().addActionListener(e -> guardaContratoDefinitivo());
		view.getBtnLupaCliente().addActionListener(e -> seleccionaCliente());
		view.getBtnLupaPropiedad().addActionListener(e -> seleccionaPropiedad());
		view.getBtnCancelarContrato().addActionListener(e -> view.setVisible(false));
		view.getBtnRenovarContrato().addActionListener(e -> renovarContrato());
		view.getBtnBorrador().addActionListener(e -> guardarEnBorrador());
		view.getComboTipoContrato().addActionListener(e -> setearMeses());
		view.getBtnVerCuotas().addActionListener(e -> verCuotas());
		fillCombos();
		
	}
	
	private void setearMeses() {
		if(view.getComboTipoContrato().getSelectedItem().equals("Vivienda")){
			view.getSpinnerDuracionContrato().setValue(24);
		}
		else{
			view.getSpinnerDuracionContrato().setValue(36);
		}
	}

	private void seleccionaCliente() {
		eligeCliente.showView();
		Cliente cliente = eligeCliente.getCliente();
		
		if(cliente != null) {	
			view.getTfCliente().setText(cliente.getPersona().getNombre() + " " + cliente.getPersona().getApellido());	
			currentContrato.setCliente(cliente);
		}
	}
	
	private void seleccionaPropiedad() {
		elegirPropiedadController.showViewAlquiler();
		Propiedad propiedad = elegirPropiedadController.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfIdPropiedad().setText(propiedad.getIdentificador());
			currentContrato.setPropiedad(propiedad);
			view.getTextPrecio().setText(propiedad.getOfrecimientoAlquiler().getPrecio().getMonto() + "");
			view.getMonedaComboModel().setSelected(propiedad.getOfrecimientoAlquiler().getPrecio().getMoneda());

			llenaDatosOfrecimiento();
		}
		
	}
	
	private void llenaDatosOfrecimiento(){
		
		OfrecimientoAlquiler o = currentContrato.getPropiedad().getOfrecimientoAlquiler();
		
		view.getTextPrecio().setText(o.getPrecio().getMonto() + "");
		view.getMonedaComboModel().setSelected(o.getPrecio().getMoneda());
		
		view.getSpinnerDuracionContrato().setValue(o.getCantidadMeses());
		view.getSpinnerActualizaContrato().setValue(o.getIntervaloActualizacion());
		view.getSpinnerPorcenajeActualiza().setValue(o.getProcentajeActualizacion());
		view.getChckbxAcumulativoActualiza().setSelected(o.isAcumulativo());
		view.getBtnVerCuotas().addActionListener(e -> verCuotas());
	}
	
	private void verCuotas(){
		verCuotasController.setModeView(currentContrato);
		verCuotasController.showView();
	}
	
	private void guardaContratoDefinitivo() {
		if(contratoAlquilerValidator.isValid()){
			mapper.fillBean(currentContrato);
			HistoriaEstadoContrato nuevo = new HistoriaEstadoContrato();
			nuevo.setEstado(EstadoContrato.DEFINITIVO);
			nuevo.setFecha(DateTime.now());
			currentContrato.getEstados().add(nuevo);
			guardaCurrentContrato();			
			closeView();
		}
		else{
			msgShw.showErrorMessage(contratoAlquilerValidator.getErrorMessage(), "Error");
		}
	}
	
	public void renovarContrato() {
		setEnabled(true);
		mapper.fillBean(currentContrato);
		guardaCurrentContrato();
		closeView();
		
	}
	
	private void guardaCurrentContrato(){
		try {
			mapper.fillBean(currentContrato);
			contratoService.saveContratoAlquiler(currentContrato);
			this.view.setVisible(false);
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
		}
	}
	
	private void guardarEnBorrador(){
		
		try {
		
			mapper.fillBean(currentContrato);
			contratoService.saveContratoAlquilerBorrador(currentContrato);
			this.view.setVisible(false);
		
		}catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
		}
	}
	
	private void fillCombos() {
		
		this.view.getComboTipoContratoModel().actualize(Arrays.asList(TipoContratoAlquiler.values()));
		
		this.view.getMonedaComboModel().actualize(Arrays.asList(Moneda.values()));
		
	}

	public void setModeNew() {
		
		view.setTitle("Agregar contrato de alquiler");
		view.getTfIdPropiedad().setText("");
		view.getTfIdPropiedad().setText("");
		view.getBtnLupaPropiedad().setEnabled(true);
		view.getBtnLupaCliente().setEnabled(true);
		
		view.getBtnGuardarContrato().setVisible(true);
		view.getBtnCancelarContrato().setVisible(true);
		view.getBtnRenovarContrato().setVisible(false);
		view.getBtnVerCuotas().setVisible(false);
		
		currentContrato = contratoService.getNewContratoAlquiler();
		mapper.fillFields(currentContrato);
		setEnabled(true);
		
	}
	
	public void setModeView(ContratoAlquiler c){
		view.setTitle("Ver contrato de alquier");
		currentContrato = c;
		mapper.fillFields(c);
		setEnabled(false);
		view.getBtnVerCuotas().setVisible(true);
	}

	public void editarContrato(ContratoAlquiler contrato){
		view.setTitle("Editar Contrato de alquier");
		view.getBtnRenovarContrato().setVisible(false);
		view.getBtnBorrador().setVisible(true);
		view.getBtnGuardarContrato().setVisible(true);
		view.getBtnCancelarContrato().setVisible(true);
		view.getBtnVerCuotas().setVisible(false);
		fillCombos();

		currentContrato = contrato;
		setEnabled(true);
		mapper.fillFields(currentContrato);
		
	}

	public void showView() {
		this.view.setVisible(true);
	}
	
	public void closeView() {
		this.view.setVisible(false);
	}

	
	public void setRenovarMode(ContratoAlquiler c){
		
		view.setTitle("Renovar contrato de alquier");
		view.getBtnLupaPropiedad().setEnabled(false);
		view.getBtnLupaCliente().setEnabled(false);
		
		view.getBtnGuardarContrato().setVisible(false);
		view.getBtnCancelarContrato().setVisible(false);
		view.getBtnRenovarContrato().setVisible(true);
		view.getBtnBorrador().setVisible(false);
		view.getBtnVerCuotas().setVisible(false);
		
		currentContrato = contratoService.getActualizacionOf(c);
		
		mapper.fillFields(currentContrato);

		showView();
		
		}
	
	public void setEnabled(boolean bool){
		this.view.getBtnBorrador().setVisible(bool);
		this.view.getBtnCancelarContrato().setVisible(bool);
		this.view.getBtnGuardarContrato().setVisible(bool);
		this.view.getBtnLupaCliente().setVisible(bool);
		this.view.getBtnLupaPropiedad().setVisible(bool);
		
		this.view.getSpinnerActualizaContrato().setEnabled(bool);
		this.view.getSpinnerDuracionContrato().setEnabled(bool);
		this.view.getSpinnerGastosAdmin().setEnabled(bool);
		this.view.getSpinnerIntimacionEmail().setEnabled(bool);
		this.view.getSpinnerPorcenajeActualiza().setEnabled(bool);
		this.view.getSpinnerPorcentajePunitorio().setEnabled(bool);
		this.view.getSpinnerTiempoPago().setEnabled(bool);
		this.view.getSpinnerVencimientoEmail().setEnabled(bool);
		
		this.view.getTextGarantia().setEnabled(bool);
		this.view.getTextIdContrato().setEnabled(bool);
		this.view.getTextPrecio().setEnabled(bool);
		
		this.view.getChckbxAcumulativoActualiza().setEnabled(bool);
		this.view.getChckbxIntimacion().setEnabled(bool);
		this.view.getChckbxVencimiento().setEnabled(bool);
		this.view.getChkbxAcumulativoPunitorio().setEnabled(bool);
		
		this.view.getComboTipoContrato().setEnabled(bool);
	}
}
