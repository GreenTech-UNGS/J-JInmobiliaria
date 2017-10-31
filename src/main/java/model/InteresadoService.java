package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Interesado;
import entities.Persona;
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
		return toRet;
	}
	
	public boolean existeInteresadoCon(Persona t) {
		
		return interesadoDao.existeInteresadoCon(t);
		
	}
	
	public void saveInteresado(Interesado toSave) throws LogicaNegocioException {
		
		if(existeInteresadoCon(toSave.getPersona()))
			throw new LogicaNegocioException("Ya existe un interesado con la misma credencial.");
	
		interesadoDao.save(toSave);
	}
}
