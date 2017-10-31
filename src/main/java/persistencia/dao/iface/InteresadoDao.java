package persistencia.dao.iface;

import entities.Interesado;
import entities.Persona;

public interface InteresadoDao extends Dao<Interesado> {
	boolean existeInteresadoCon(Persona t);

}
