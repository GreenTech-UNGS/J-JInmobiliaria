package persistencia.dao.iface;

import java.util.List;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;

public interface CuotaDao extends Dao<CuotaAlquiler>{

	List<CuotaAlquiler> getAllOfThisMonth();
	InteresPunitorioCuota getInteresOf(CuotaAlquiler c);
	
}
