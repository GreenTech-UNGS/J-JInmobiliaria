package persistencia.dao.iface;

import java.util.List;

import entities.Inmobiliaria;
import entities.Telefono;
import filtros.InmobiliariaFiltro;

public interface InmobiliariaDao extends Dao<Inmobiliaria>{
	
	List<Telefono> getAllTelefonosOf(Inmobiliaria i);
	public List<Inmobiliaria> getAllByFiltro(InmobiliariaFiltro filtro);

}
