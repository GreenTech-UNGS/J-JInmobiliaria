package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Notificacion;
import entities.AvisoNotificacion;
import persistencia.dao.iface.NotificacionDao;

@Singleton
public class NotificacionesService {

	private List<Consumer<Notificacion>> callbacks;
	
	@Inject ContratoService contratoService;
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
		return null;
	}

	public void save(AvisoNotificacion notificacion) {
		notificacionDao.save(notificacion);
		
	}
	
	
	
}
