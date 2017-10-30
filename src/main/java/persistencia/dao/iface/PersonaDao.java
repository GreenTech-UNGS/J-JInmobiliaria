package persistencia.dao.iface;

import java.util.List;

import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.PersonaBasica;
import entities.Telefono;

public interface PersonaDao extends Dao<Persona>{
	
	List<Telefono> getAllTelefonosOf(PersonaBasica pb);
	public List<PersonaBasica> getAllBasicas();
	boolean existePersonaConCredencial (String credencial, TipoCredencial tipo);
	Persona getPersonaWith(int ID);
	
}
