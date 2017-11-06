package persistencia.dao.iface;

import entities.Cartel;
public interface CartelDao extends Dao<Cartel>{

	boolean existeCartelCon(String identificador);
	
}
