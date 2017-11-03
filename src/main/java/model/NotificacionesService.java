package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
	
	@Inject ContratoService contratoService;
	@Inject private CitaService citaService;
	@Inject NotificacionDao notificacionDao;
	
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
			for(NotificacionCita notificacion: cita.getAvisos()){
				
				if(notificacion.getTipo() == TipoNotificacion.SISTEMA 
						&& !notificacion.isVisto()){
					Notificacion toAdd = new Notificacion();
					toAdd.setAvisoNotif(notificacion);
					
					toRet.add(toAdd);
				}
				
			}
		}
		
		return toRet;
		
		
	}

	public void save(AvisoNotificacion notificacion) {
		notificacionDao.save(notificacion);
		
	}
	
	
	
}
