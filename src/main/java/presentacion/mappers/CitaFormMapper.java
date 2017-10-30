package presentacion.mappers;

import java.time.LocalDateTime;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cita;
import entities.Localidad;
import entities.TipoCita;
import presentacion.vista.CitaForm;

@Singleton
public class CitaFormMapper implements Mapper<Cita>{

	private CitaForm view;
	
	@Inject
	private CitaFormMapper(CitaForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(Cita t) {
		
		boolean asiste = view.getChckbxAsistir().isSelected();
		TipoCita motivo = view.getComboModelTipoCita().getSelected();
		LocalDate fecha = new LocalDate(view.getDateChooser().getDate());
		LocalTime horaMomento = new LocalTime((int)view.getSpinnerHoraMomento().getValue(), (int)view.getSpinnerMinutoMomento().getValue());
		DateTime fechaHora = fecha.toDateTime(horaMomento);
		Period duracion = new Period((int)view.getSpinnerHoraDuracion().getValue(), (int)view.getSpinnerMinutoDuracion().getValue(), 0, 0);
		
		String calle = convierteString(view.getTfCalle().getText());
		String altura = convierteString(view.getTfCalle().getText());
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		String notas = convierteString(view.getTaNotas().getText());
		
		Period avisoCorto = Period.hours((int)view.getSpinnerAvisoCorto().getValue());
		Period avisoLargo = Period.hours((int)view.getSpinnerAvisoLargo().getValue());
		
		AvisoNotificacion corto = new AvisoNotificacion();
		corto.setHabilitado(true);
		corto.setPeriodo(avisoCorto);
		
		AvisoNotificacion largo = new AvisoNotificacion();
		largo.setHabilitado(true);
		largo.setPeriodo(avisoLargo);
		
		t.setAltura(altura);
		t.setAvisoCorto(corto);
		t.setAvisoLargo(largo);
		t.setCalle(calle);
		t.setCreadorAsiste(asiste);
		t.setDescripcion(notas);
		t.setDuracionEstimada(duracion.toString());
		t.setFechaHora(fechaHora);
		t.setLocalidad(localidad);
		t.setTipo(motivo);
		
		
	}

	@Override
	public void fillFields(Cita t) {
		
		boolean asiste = t.isCreadorAsiste();
		TipoCita motivo = t.getTipo();
		DateTime fechaHora = t.getFechaHora();
		Period duracion = Period.parse(t.getDuracionEstimada());
	}
	
	private String convierteString(String s) {
		if(s == null)
			return "";
		else return s;
	}

}
