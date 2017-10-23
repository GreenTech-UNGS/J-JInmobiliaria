package persistencia.dao.iface;

import entities.Propiedad;

public interface PropiedadDao extends Dao<Propiedad>{
	public void actualizePropiedad(Propiedad toActualize);
	boolean existePropiedadConIdentificador(String identificador);
	

}
