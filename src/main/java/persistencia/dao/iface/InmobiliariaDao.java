package persistencia.dao.iface;

import java.util.List;

import entities.Inmobiliaria;
import entities.Telefono;

public interface InmobiliariaDao extends Dao<Inmobiliaria>{
	
	List<Telefono> getAllTelefonosOf(Inmobiliaria i);

}
