package presentacion.validators;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import presentacion.vista.CitaForm;

@Singleton
public class CitaFormValidator implements ValidatorNew{

	private CitaForm view;
	
	@Inject
	private CitaFormValidator(CitaForm view) {
		
		this.view = view;
		
	}

	@Override
	public boolean isValid() {
		return isFechaValid() &&
				isDireccionValid() &&
				isDuracionValid()&&
				isMotivoValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siuientes campos: ";
		if(!isFechaValid())
			toRet += "\n- La fecha debe ser posterior a hoy";
		if(!isDuracionValid())
			toRet += "\n- La duracion debe ser mayor a cero";
		if(!isDireccionValid())
			toRet += "\n- La direccion no es valida";
		if(!isMotivoValid())
			toRet += "\n- Debe ingresar un motivo de cita";
		
		return toRet;
	}
	
	private boolean isFechaValid() {
		
		LocalDate fecha = new LocalDate(view.getDateChooser().getDate());
		LocalTime horaMomento = new LocalTime((int)view.getSpinnerHoraMomento().getValue(), (int)view.getSpinnerMinutoMomento().getValue());
		DateTime fechaHora = fecha.toDateTime(horaMomento);
		
		return fechaHora.isAfterNow();
		
	}
	
	private boolean isDuracionValid() {
		
		int hora = (int)view.getSpinnerHoraDuracion().getValue();
		int minuto = (int)view.getSpinnerMinutoDuracion().getValue();
		
		return hora > 0 || minuto > 0;
		
	}
	
	private boolean isDireccionValid() {
		
		String calle = convierteString(view.getTfCalle().getText());
		String altura = convierteString(view.getTfAltura().getText());
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		return calle != "" && altura != "" && localidad != null;

	}
	
	private boolean isMotivoValid() {
		
		return view.getComboModelTipoCita().getSelected() != null;
		
	}
	
	private String convierteString(String s) {
		if(s == null)
			return "";
		return s;
	}
	
	
}
