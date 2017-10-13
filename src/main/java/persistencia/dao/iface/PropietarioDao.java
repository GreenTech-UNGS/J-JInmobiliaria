package persistencia.dao.iface;

import java.util.List;

import entities.PagoPropietario;
import entities.Persona;
import entities.Propietario;

public interface PropietarioDao extends Dao<Propietario>{

	public void generaPago(PagoPropietario pago);
	public List<PagoPropietario> getAllPagosPropsPendientes();
	public void savePago(PagoPropietario p);
	public boolean existePropietarioCon(Persona t);
}
