package persistencia.dao.iface;

import java.util.List;

import entities.Interesado;
import entities.Persona;
import filtros.InteresadoFiltro;

public interface InteresadoDao extends Dao<Interesado> {
	boolean existeInteresadoCon(Persona t);
	public List<Interesado> getAllByFiltro(InteresadoFiltro filtro);

}
