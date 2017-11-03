package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Period;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cita;
import entities.NotificacionCita;
import entities.NotificacionCita.TipoNotificacion;
import entities.Persona;
import entities.PersonaBasica;
import entities.Usuario;
import persistencia.dao.iface.CitaDao;

@Singleton
public class CitaService {
	
	@Inject private CitaDao citaDao;
	@Inject private UsuarioService usuariosService;

	@Inject
	private CitaService() {
		
	}
	
	public void saveCita(Cita c) {
		
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
	
	public void crearNotificaciones(Cita c, int avisoCorto, int avisoLargo){
		
		for(PersonaBasica p: c.getAsistentes()){
			
			NotificacionCita corto = new NotificacionCita();
			NotificacionCita largo = new NotificacionCita();
			
			corto.setPersona(p);
			largo.setPersona(p);
			
			corto.setPeriodo(Period.hours(avisoCorto));
			largo.setPeriodo(Period.days(avisoLargo));
			
			if(p instanceof Persona && usuariosService.existeUsuarioCon((Persona)p)){

				corto.setTipo(TipoNotificacion.SISTEMA);
				largo.setTipo(TipoNotificacion.SISTEMA);
			}
			else{

				corto.setTipo(TipoNotificacion.EMAIL);
				largo.setTipo(TipoNotificacion.EMAIL);
			}
			
			c.getAvisoCorto().add(corto);
			c.getAvisoLargo().add(largo);
			
		}
		
	}
	
	public Cita getNuevaCita() {
		Cita toRet = new Cita();
		
		return toRet;
		
	}
	
	
}
