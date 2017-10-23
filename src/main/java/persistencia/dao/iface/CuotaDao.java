package persistencia.dao.iface;

import java.util.List;

import org.joda.time.YearMonth;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;

public interface CuotaDao extends Dao<CuotaAlquiler>{

	public List<CuotaAlquiler> getAllOf(YearMonth anioMes);
	public List<CuotaAlquiler> getAllOfThisMonth();
	public InteresPunitorioCuota getInteresOf(CuotaAlquiler c);
	public void saveInteres(InteresPunitorioCuota interes);
	public List<CuotaAlquiler> getCuotasOf(ContratoAlquiler c);
	
}
