package persistencia.dao.iface;

import java.util.List;

import entities.PagoPropietario;
import entities.Persona;
import entities.Propietario;
import filtros.PropietarioFiltro;

public interface PropietarioDao extends Dao<Propietario>{

	public void generaPago(PagoPropietario pago);
	public Propietario getPropietarioOf(Persona p);
	public List<PagoPropietario> getAllPagosPropsPendientes();
	public List<Propietario> getAllByFiltro(PropietarioFiltro filtro);
	public void savePago(PagoPropietario p);
	public boolean existePropietarioCon(Persona t);
}
