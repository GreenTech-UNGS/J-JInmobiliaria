package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Notificacion;

@Singleton
public class NotificacionesService {

	private List<Consumer<Notificacion>> callbacks;
	
	@Inject
	private NotificacionesService() {
		callbacks = new ArrayList<>();
	}
	
	public void addCallback(Consumer<Notificacion> r) {
		callbacks.add(r);
	}
	
	public void fetch() {
		
		Notificacion n = new Notificacion();
		n.setTitulo("wesa");
		
		callbacks.forEach(c -> c.accept(n));
		
	}
	
	
	
}
