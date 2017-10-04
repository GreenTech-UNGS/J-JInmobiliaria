package persistencia.dao.iface;

import java.util.List;

import entities.Localidad;
import entities.Provincia;

public interface LocalidadDao extends Dao<Localidad>{

	List<Localidad> getAllOf(Provincia p);
	
}
