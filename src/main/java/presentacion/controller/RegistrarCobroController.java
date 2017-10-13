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
import presentacion.validators.CobroAlquilerValidator;
import presentacion.vista.RegistrarCobroForm;

@Singleton
public class RegistrarCobroController {

	RegistrarCobroForm view;
	CuotaAlquiler currentCuota;
	PagosCobrosService cobrosService;
	CobroAlquilerValidator cobroAlquilerValidator;

	boolean okWasPressed;
	
	
	@Inject
	private RegistrarCobroController(RegistrarCobroForm view,
			PagosCobrosService cobrosService,
			CobroAlquilerValidator ingresoValidator) {
		
		this.view = view;
		this.cobrosService = cobrosService;
		this.cobroAlquilerValidator = ingresoValidator;
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
		LocalDate inicioCuota = currentCuota.getAnioMes().toLocalDate(1);
		
		if(inicioCuota.isAfter(fechaPago.toLocalDate()) || LocalDate.now().isBefore(fechaPago.toLocalDate())) {
			JOptionPane.showMessageDialog(view, "La fecha de pago debe ser posterior al inicio de la cuota\n"
					+ "y anterior a hoy", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(cobroAlquilerValidator.isValid(currentCuota)){
			cobrosService.generarCobroAlquiler(currentCuota, fechaPago);
			this.view.setVisible(false);
		}
	}
	
}
