package persistencia.dao.iface;

import java.util.List;

import org.joda.time.YearMonth;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;

public interface CuotaDao extends Dao<CuotaAlquiler>{

	public List<CuotaAlquiler> getAllOf(YearMonth anioMes);
	List<CuotaAlquiler> getAllOfThisMonth();
	InteresPunitorioCuota getInteresOf(CuotaAlquiler c);
	
}
