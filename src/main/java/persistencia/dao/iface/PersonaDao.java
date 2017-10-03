package persistencia.dao.iface;

import java.util.Collection;
import java.util.List;

import entities.Persona;
import entities.PersonaBasica;
import entities.Telefono;

public interface PersonaDao extends Dao<Persona>{
	
	List<Telefono> getAllTelefonosOf(PersonaBasica pb);
	
}
