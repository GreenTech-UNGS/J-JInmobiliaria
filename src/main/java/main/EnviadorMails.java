package main;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.mail.MessagingException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dto.Mail;
import entities.Cita;
import entities.NotificacionCita;
import entities.NotificacionCita.TipoNotificacion;
import misc.EnviadorMailsModule;
import model.CitaService;
import model.MailSenderService;
import model.NotificacionesService;

public class EnviadorMails {
	
	private static Injector injector;
	private static long cincoMinutos = 60000 * 5;
	
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
		        .appendSeparator(":")
		        .appendSeconds()
		        .minimumPrintedDigits(2)
		        .toFormatter();
	
	
	public static void main(String[] args){
		

    	DateTimeZone.setDefault(DateTimeZone.UTC);
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		injector = Guice.createInjector(new EnviadorMailsModule());
		
		Thread t = new Thread(() -> {
			try {
				while(true){
					enviaMailsCitas();
					Thread.sleep(cincoMinutos);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t.start();
		
		
		
	}
	
	private static void enviaMailsCitas(){
		
		CitaService citaService = injector.getInstance(CitaService.class);
		NotificacionesService notificacionesService= injector.getInstance(NotificacionesService.class);
		
		List <Cita> citas = citaService.getProximas();
		
		for (Cita cita : citas) for(NotificacionCita notificacion: cita.getAvisos()){
				
				if(seAvisaMail(cita, notificacion)){
					
					Period tiempo = new Period(DateTime.now(), cita.getFechaHora());
					
					Mail toSend = new Mail(notificacion.getPersona().getEmail(),"Cita" , 
							"Usted tiene una cita en " + 
							cita.getCalle() + " " + cita.getAltura() + ", " + cita.getLocalidad().getNombre()+
							", " + cita.getLocalidad().getProvincia().toString().replaceAll("_", " ") +
							" a las " + cita.getFechaHora().toString("hh:mm") + " del dia " + 
							cita.getFechaHora().toString("dd-MM-YYYY") + ".\n"+
							"Con el motivo de " + cita.getTipo().toString() + "\n"
							+"Observaciones: " + cita.getDescripcion()+"\n\n"
							+"Gracias. \n-Inmobiliaria");
					
					notificacion.setVisto(true);
					notificacionesService.save(notificacion);
					
					System.out.println(toSend.getBody());
					
					//new Thread(() -> sendMail(toSend)).start();
				}
				
		}
		
		
		
	}
	
	public static void sendMail(Mail m){
		
		MailSenderService mailSender = injector.getInstance(MailSenderService.class);
		try {
			mailSender.send(m);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	private static boolean seAvisaMail(Cita c, NotificacionCita n){
		DateTime momentoAvisar = c.getFechaHora().minus(n.getPeriodo()); 
		
		return n.getTipo() == TipoNotificacion.EMAIL 
				&& !DateTime.now().isBefore(momentoAvisar)
				&& !n.isVisto();
	}

}
