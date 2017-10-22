package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import entities.*;
import model.ContratoService;
import model.LogicaNegocioException;
import model.ReservaService;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;
import presentacion.mappers.ContratoAlquilerFormMapper;
import presentacion.validators.ContratoAlquilerFormValidator;
import presentacion.validators.MessageShow;
import presentacion.vista.ContratoAlquilerForm;

import java.util.Arrays;

import org.joda.time.DateTime;

@Singleton
public class ContratoAlquilerController {

	ContratoService contratoService;
	ReservaService reservaService;
	ContratoAlquilerForm view;
	ElegirClienteController eligeCliente;
	ElegirPropiedadController elegirPropiedadController;
	ContratoAlquilerFormMapper mapper;
	
	ContratoAlquiler currentContrato;
	ContratoAlquilerFormValidator contratoAlquilerValidator;
	
	MessageShow msgShw;
	
	@Inject
	private ContratoAlquilerController(ContratoService contratoService,
								ContratoAlquilerForm view,
								ReservaService reservaService,
								ElegirClienteController eligeCliente,
								ContratoAlquilerFormValidator contratoAlquilerValidator,
								ElegirPropiedadController elegirPropiedadController,
								ContratoAlquilerFormMapper mapper,
								MessageShow msgShw) {
		
		this.contratoService = contratoService;
		this.view = view;
		this.eligeCliente = eligeCliente;
		this.contratoAlquilerValidator = contratoAlquilerValidator;
		this.reservaService = reservaService;
		this.elegirPropiedadController = elegirPropiedadController;
		this.mapper = mapper;
		this.msgShw = msgShw;
		
		view.getBtnGuardarContrato().addActionListener(e -> guardaContratoDefinitivo());
		view.getBtnLupaCliente().addActionListener(e -> seleccionaCliente());
		view.getBtnLupaPropiedad().addActionListener(e -> seleccionaPropiedad());
		view.getBtnCancelarContrato().addActionListener(e -> view.setVisible(false));
		view.getBtnRenovarContrato().addActionListener(e -> renovarContrato());
		view.getBtnBorrador().addActionListener(e -> guardarEnBorrador());
//		view.getBtnGuardarCambios().addActionListener(e -> guardaContrato);
		

		fillCombos();
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
		elegirPropiedadController.showViewProp();
		Propiedad propiedad = elegirPropiedadController.getPropiedad();
		
		if(propiedad != null) {
		
			view.getTfIdPropiedad().setText(propiedad.getIdentificador());
			
			currentContrato.setPropiedad(propiedad);
			
			view.getTextPrecio().setText(propiedad.getPrecioTentativo().getMonto() + "");
			
		}
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
		
		view.getTfIdPropiedad().setText("");
		view.getTfIdPropiedad().setText("");
		
		view.getBtnLupaPropiedad().setEnabled(true);
		view.getBtnLupaCliente().setEnabled(true);
		
		view.getBtnGuardarContrato().setVisible(true);
		view.getBtnCancelarContrato().setVisible(true);
		view.getBtnRenovarContrato().setVisible(false);
		
		currentContrato = contratoService.getNewContratoAlquiler();
		mapper.fillFields(currentContrato);
		
	}

	public void editarContrato(ContratoAlquiler contrato){
		view.setTitle("Editar Contrato");
		fillCombos();

		currentContrato = contrato;
		mapper.fillFields(currentContrato);
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
		view.getBtnBorrador().setVisible(false);
		
		currentContrato = contratoService.getActualizacionOf(c);
		
		mapper.fillFields(currentContrato);

		showView();
		
		}
}
