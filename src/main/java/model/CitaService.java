package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cita;
import persistencia.dao.iface.CitaDao;

@Singleton
public class CitaService {
	
	@Inject private CitaDao citaDao;

	@Inject
	private CitaService() {
		
	}
	
	public void saveCita(Cita c) {
		citaDao.save(c);
	}
	
	public List<Cita> getAll(){
		return citaDao.getAll();
	}
	
	public Cita getNuevaCita() {
		Cita toRet = new Cita();
		
		AvisoNotificacion corto = new AvisoNotificacion();
		AvisoNotificacion largo = new AvisoNotificacion();
		
		toRet.setAvisoCorto(corto);
		toRet.setAvisoLargo(largo);
		
		return toRet;
		
	}
	
	
}
