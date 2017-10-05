package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Persona;
import entities.PersonaBasica;
import entities.Telefono;
import persistencia.dao.iface.PersonaDao;

@Singleton
public class PersonaService {

	PersonaDao personaDao;
	
	@Inject
	private PersonaService(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}
	

	public boolean existePersonaConCredencial(Persona p) {
		
		return personaDao.existePersonaConCredencial(p.getCredencial(), p.getTipoCred());
		
	}
	
	public List<Telefono> getAllTelefonosOf(PersonaBasica pb) {
		
		return personaDao.getAllTelefonosOf(pb);
		
	}
}
