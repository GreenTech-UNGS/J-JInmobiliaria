package model;

import java.util.List;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Persona;
import entities.Preferencia;
import filtros.InteresadoFiltro;
import persistencia.dao.iface.InteresadoDao;
import persistencia.dao.iface.PersonaDao;

@Singleton
public class InteresadoService {
	
	@Inject private InteresadoDao interesadoDao;
	@Inject private PersonaDao personaDao;
	
	@Inject
	public InteresadoService(){

	}
	
	public List<Interesado> getAll(){
		return interesadoDao.getAll();
	}
	
	public Interesado getEmptyInteresado() {
		
		Interesado toRet = new Interesado();
		Persona p = new Persona();
		p.setTipoCred(Persona.TipoCredencial.DNI);
		toRet.setPersona(p);
		Preferencia preferencia = new Preferencia();
		toRet.setPreferencia(preferencia);
		toRet.setFechaAlta(DateTime.now());		
		
		return toRet;
	}
	
	public void saveInteresado(Interesado toSave) throws LogicaNegocioException {
			
		interesadoDao.save(toSave);
	}
	
	public void editInteresado(Interesado toSave) throws LogicaNegocioException {
		
		interesadoDao.save(toSave);
	}

	public void removeInteresado(Interesado toRemove){
		
		interesadoDao.remove(toRemove);
	}

	public List<Interesado> getAllByFiltro(InteresadoFiltro filtro){
	
	return interesadoDao.getAllByFiltro(filtro);
	
}
}
