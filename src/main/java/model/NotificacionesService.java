package model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Notificacion;
import entities.AvisoNotificacion;
import entities.Cita;
import entities.NotificacionCita;
import entities.NotificacionCita.TipoNotificacion;
import persistencia.dao.iface.NotificacionDao;

@Singleton
public class NotificacionesService {

	private List<Consumer<Notificacion>> callbacks;
	
	@Inject private ContratoService contratoService;
	@Inject private CitaService citaService;
	@Inject private NotificacionDao notificacionDao;
	
	private static final PeriodFormatter dateFormat =
		    new PeriodFormatterBuilder()
		        .appendDays()
		        .appendSuffix(" dia", " dias")
		        .appendSeparator(" ")
		        .printZeroIfSupported()
		        .minimumPrintedDigits(2)
		        .appendHours()
		        .appendSeparator(":")
		        .appendMinutes()
		        .printZeroIfSupported()
		        .minimumPrintedDigits(2)
		        .toFormatter();
	
	@Inject
	private NotificacionesService() {
		callbacks = new ArrayList<>();
	}
	
	public void addCallback(Consumer<Notificacion> r) {
		callbacks.add(r);
	}
	
	public void fetch() {
		
		List<Notificacion> notificaciones = new ArrayList<>();
		notificaciones.addAll(fetchContratos());
		notificaciones.addAll(fetchCitas());
		
		callbacks.forEach(c -> 
			notificaciones.forEach(n -> c.accept(n))
			);
		
	}
	
	private List<Notificacion> fetchContratos(){
		List<Notificacion> toRet = new ArrayList<>();
		
		contratoService.getProximosVencer().forEach(c ->{
			if(!c.getAvisoProxVencer().isVisto()){
				Notificacion toAdd = new Notificacion();
				toAdd.setTitulo("Contrato a vencer " + c.getIdentificador());
				toAdd.setAvisoNotif(c.getAvisoProxVencer());
			
				toRet.add(toAdd);
			}
		});
		
		return toRet;
		
	}
	
	private List<Notificacion> fetchCitas(){
		List<Notificacion> toRet = new ArrayList<>();
		
		List <Cita> citas = citaService.getProximasLogueado();
		
		for (Cita cita : citas) {
			
			Period tiempo = new Period(DateTime.now(), cita.getFechaHora());
			
			for(NotificacionCita notificacion: cita.getAvisos()){
				
				if(seAvisaSistema(cita, notificacion)){
					
					Notificacion toAdd = new Notificacion();
					toAdd.setTitulo("Tiene una cita en :");
					toAdd.setDescripcion(
							"<html><body>"+tiempo.toString(dateFormat)+"<br>Para " + cita.getTipo().toString()+ "</body></html>");
					toAdd.setAvisoNotif(notificacion);
					
					toRet.add(toAdd);
				}
				
			}
		}
		
		return toRet;
		
		
	}
	
	private boolean seAvisaSistema(Cita c, NotificacionCita n){
		DateTime momentoAvisar = c.getFechaHora().minus(n.getPeriodo()); 
		
		return n.getTipo() == TipoNotificacion.SISTEMA 
				//&& !DateTime.now().isBefore(momentoAvisar)
				&& !n.isVisto();
	}

	public void save(AvisoNotificacion notificacion) {
		notificacionDao.save(notificacion);
		
	}
	
	
	
}
