package presentacion.controller;

import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import presentacion.vista.RegistrarCobroView;

@Singleton
public class RegistrarCobroController {

	RegistrarCobroView view;
	boolean okWasPressed;
	CuotaAlquiler currentCuota;
	
	
	@Inject
	private RegistrarCobroController(RegistrarCobroView view) {
		
		this.view = view;
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
	
	public DateTime getDate() {
		if(!okWasPressed)
			return null;
		
		DateTime fechaPago = new DateTime(view.getDateChooser().getDate());
		
		return fechaPago;
	}
	
	private void okPressed() {
		okWasPressed = true;
		
		DateTime fechaPago = new DateTime(view.getDateChooser().getDate());
		LocalDate inicioCuota = currentCuota.getAnioMes().toLocalDate(1);
		
		if(inicioCuota.isAfter(fechaPago.toLocalDate()) || LocalDate.now().isBefore(fechaPago.toLocalDate())) {
			JOptionPane.showMessageDialog(view, "La fecha de pago debe ser posterior al inicio de la cuota\n"
					+ "y anterior a hoy", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			this.view.setVisible(false);
		}
	}
	
}
