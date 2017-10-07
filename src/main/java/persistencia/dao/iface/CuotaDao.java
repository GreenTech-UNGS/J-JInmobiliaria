package persistencia.dao.iface;

import java.util.List;

import entities.CuotaAlquiler;

public interface CuotaDao extends Dao<CuotaAlquiler>{

	public List<CuotaAlquiler> getPendientes();
}
