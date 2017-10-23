package persistencia.dao.iface;

import java.util.List;

import entities.Propiedad;
import filtros.PropiedadFiltro;

public interface PropiedadDao extends Dao<Propiedad>{
	public void actualizePropiedad(Propiedad toActualize);
	boolean existePropiedadConIdentificador(String identificador);
	public List<Propiedad> getAllByFiltro(PropiedadFiltro filtro);
	

}
