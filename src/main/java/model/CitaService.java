package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cita;
import entities.NotificacionCita;
import entities.NotificacionCita.TipoNotificacion;
import entities.Persona;
import entities.PersonaBasica;
import entities.UnidadTiempo;
import entities.Usuario;
import persistencia.dao.iface.CitaDao;
import persistencia.dao.iface.NotificacionDao;

@Singleton
public class CitaService {
	
	@Inject private CitaDao citaDao;
	@Inject private UsuarioService usuariosService;
	@Inject NotificacionDao notificacionDao;

	@Inject
	private CitaService() {
		
	}
	
	public void saveCita(Cita c) {
		
		c.getAvisos().forEach(aviso -> notificacionDao.save(aviso));
		
		citaDao.save(c);
	}
	
	public List<Cita> getAll(){
		return citaDao.getAll();
	}
	
	public List<Cita> getAllOfLogueado(){
		
		return citaDao.getCitasOf(usuariosService.getUsuarioLogeado());
	}
	
	public List<Cita> getProximasLogueado(){
		Usuario logueado = usuariosService.getUsuarioLogeado();
		if(logueado != null)return citaDao.getProximasOf(usuariosService.getUsuarioLogeado());
	
		return new ArrayList<>();
	
	}
	
	public List<Cita> getProximas(){
		return citaDao.getProximas();
	}
	
	public void crearNotificaciones(Cita c, int avisoCorto, UnidadTiempo unidadCorta, int avisoLargo, UnidadTiempo unidadLarga){
		
		Persona p = c.getAsistente().getPersona();
			
		NotificacionCita corto = new NotificacionCita();
		NotificacionCita largo = new NotificacionCita();
		
		corto.setPersona(p);
		largo.setPersona(p);
		
		corto.setPeriodo(getPeriod(avisoCorto, unidadCorta));
		largo.setPeriodo(getPeriod(avisoLargo, unidadLarga));
			
		if(p instanceof Persona && usuariosService.existeUsuarioCon((Persona)p)){
			System.out.println(p.getNombre());
			corto.setTipo(TipoNotificacion.SISTEMA);
			largo.setTipo(TipoNotificacion.SISTEMA);
		}
		else{

			corto.setTipo(TipoNotificacion.EMAIL);
			largo.setTipo(TipoNotificacion.EMAIL);
		}
		
		c.getAvisos().add(corto);
		c.getAvisos().add(largo);
		
		
		
	}
	
	private Period getPeriod(int cantidad, UnidadTiempo unidad){
		
		switch (unidad) {
		case DIA:return Period.days(cantidad);

		case HORA:return Period.hours(cantidad);
			
		case SEMANA:return Period.weeks(cantidad);
		
		default:return null;
	}
		
	}
	
	public String getMapaLink(Cita c) {
		
		String locationUnecoded = "https://www.google.com/maps/search/?api=1&query=+"+ c.getLat() + "," + c.getLng();
		
		
		
		return locationUnecoded;
	}
	
	public Cita getNuevaCita() {
		Cita toRet = new Cita();
		toRet.setDuracionEstimada(Period.ZERO.toString());
		toRet.setFechaHora(DateTime.now().plusDays(1)); //Ma�ana
		
		return toRet;
		
	}

	public void cancelarCita(Cita c) {
		
		c.setSeBorra(true);
		citaDao.save(c);
		
	}

	public void delete(Cita cita) {
		citaDao.remove(cita);
	}
}
