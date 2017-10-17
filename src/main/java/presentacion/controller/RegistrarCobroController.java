package presentacion.controller;

import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import model.PagosCobrosService;
import presentacion.validators.MessageShow;
import presentacion.validators.RegistrarCobroFormValidator;
import presentacion.vista.RegistrarCobroForm;

@Singleton
public class RegistrarCobroController {

	RegistrarCobroForm view;
	CuotaAlquiler currentCuota;
	PagosCobrosService cobrosService;
	RegistrarCobroFormValidator cobroAlquilerValidator;
	MessageShow msgShw;

	boolean okWasPressed;
	
	
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
		
	}
	
	public void setCuota(CuotaAlquiler c) {
		currentCuota = c;
	}
	
	public void showView() {
		
		okWasPressed = false;
		view.getDateChooser().setDate(new Date());
		view.setVisible(true);
		
	}
	
	private void okPressed() {
		okWasPressed = true;
		
		DateTime fechaPago = new DateTime(view.getDateChooser().getDate());
		
		if(cobroAlquilerValidator.isValid()){
			cobrosService.generarCobroAlquiler(currentCuota, fechaPago);
			this.view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(cobroAlquilerValidator.getErrorMessage(), "Error");
		}
		
	}
	
}
