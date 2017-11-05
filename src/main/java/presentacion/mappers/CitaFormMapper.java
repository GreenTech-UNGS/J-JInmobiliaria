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
		String altura = convierteString(view.getTfAltura().getText());
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		String notas = convierteString(view.getTaNotas().getText());
		
		t.setAltura(altura);
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
		
		Period duracion = Period.parse(t.getDuracionEstimada());
		
		view.getChckbxAsistir().setSelected(t.isCreadorAsiste());
		view.getComboModelTipoCita().setSelected(t.getTipo());
		view.getDateChooser().setDate(t.getFechaHora().toDate());
		view.getSpinnerHoraMomento().setValue(t.getFechaHora().getHourOfDay());
		view.getSpinnerMinutoMomento().setValue(t.getFechaHora().getMinuteOfHour());
		
		view.getSpinnerHoraDuracion().setValue(duracion.getHours());
		view.getSpinnerMinutoDuracion().setValue(duracion.getMinutes());
		
		view.getTfCalle().setText(t.getCalle());
		view.getTfAltura().setText(t.getAltura());
		view.getComboModelLocalidad().setSelected(t.getLocalidad());
		if(t.getLocalidad() != null)
			view.getComboModelProvincia().setSelected(t.getLocalidad().getProvincia());
		
		view.getTaNotas().setText(t.getDescripcion());
		
		view.revalidate();
		
	}
	
	private String convierteString(String s) {
		if(s == null)
			return "";
		else return s;
	}

}
