package persistencia.dao.iface;

import java.util.List;

import entities.PagoPropietario;
import entities.Propiedad;
import entities.Propietario;

public interface PropietarioDao extends Dao<Propietario>{

	public void generaPago(PagoPropietario pago);
	public List<PagoPropietario> getAllPagosPropsPendientes();
}
