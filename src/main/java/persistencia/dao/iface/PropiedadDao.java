package persistencia.dao.iface;

import java.util.List;

import entities.Foto;
import entities.Propiedad;
import entities.TipoHabitacion;
import filtros.PropiedadFiltro;

public interface PropiedadDao extends Dao<Propiedad>{
	
	public void actualizePropiedad(Propiedad toActualize);
	boolean existePropiedadConIdentificador(int IdExcluir, String identificador);
	public List<Propiedad> getAllByFiltro(PropiedadFiltro filtro);
	public List<TipoHabitacion> getAllTipoHabitacion();

}
