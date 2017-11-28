package presentacion.controller;

import java.text.DecimalFormat;
import java.util.Date;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;
import entities.Moneda;
import model.CuotaService;
import model.PagosCobrosService;
import presentacion.validators.MessageShow;
import presentacion.validators.RegistrarCobroFormValidator;
import presentacion.vista.RegistrarCobroForm;

@Singleton
public class RegistrarCobroController {

	RegistrarCobroForm view;
	CuotaAlquiler currentCuota;
	PagosCobrosService cobrosService;
	@Inject private CuotaService cuotaService;
	RegistrarCobroFormValidator cobroAlquilerValidator;
	MessageShow msgShw;

	boolean okWasPressed;
	private InteresPunitorioCuota currentInteres;
	private final DecimalFormat format = new DecimalFormat("#.##");
	
	
	@Inject
	private RegistrarCobroController(RegistrarCobroForm view,
			PagosCobrosService cobrosService,
			RegistrarCobroFormValidator ingresoValidator,
			MessageShow msgShw) {
		
		this.view = view;
		this.cobrosService = cobrosService;
		this.cobroAlquilerValidator = ingresoValidator;
		this.msgShw = msgShw;
		
		okWasPressed = false;
		
		view.getBtnOk().addActionListener(e -> okPressed());
		view.getDateChooser().addPropertyChangeListener("date", e -> actualizaInteres());
		
	}
	
	public void setCuota(CuotaAlquiler c) {
		currentCuota = c;
	}
	
	public void showView() {
		
		okWasPressed = false;
		view.getDateChooser().setDate(new Date());
		
		view.getTextCliente().setText(
				currentCuota.getContrato().getCliente().getPersona().getCredencial() + " "
				+currentCuota.getContrato().getCliente().getPersona().getApellido() + " "
				+currentCuota.getContrato().getCliente().getPersona().getNombre());
		
		view.getTextPropiedad().setText(
				currentCuota.getContrato().getPropiedad().getIdentificador() + " "
				+ currentCuota.getContrato().getPropiedad().getLocalidad().getNombre());
		
		actualizaInteres();
		view.setVisible(true);
		
	}
	
	private void actualizaInteres() {
		DateTime fecha = new DateTime(view.getDateChooser().getDate());
		InteresPunitorioCuota interes = cuotaService.getInteresCalculado(currentCuota, fecha);
		
		double monto = currentCuota.getMonto().getMonto();
		Moneda moneda = currentCuota.getMonto().getMoneda();
		
		if(interes != null) {
			currentInteres = interes;
			view.getTextInteres().setText(format.format(interes.getMonto().getMonto()) +
					" " + interes.getMonto().getMoneda().toString());
		
			monto += interes.getMonto().getMonto();
		}
		else {
			view.getTextInteres().setText("0");
		}
		
		view.getTextTotal().setText(format.format(monto)+ " " + moneda.toString());
	
	}
	
	private void okPressed() {
		okWasPressed = true;
		
		DateTime fechaPago = new DateTime(view.getDateChooser().getDate());
		
		if(cobroAlquilerValidator.isValid()){
			if(currentInteres != null) cuotaService.saveInteres(currentInteres);
			cobrosService.generarCobroAlquiler(currentCuota, fechaPago);
			this.view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(cobroAlquilerValidator.getErrorMessage(), "Error");
		}
		
	}
	
}
