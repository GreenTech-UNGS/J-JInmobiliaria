package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CuotaDao;

@Singleton
public class CuotaDaoHibernate extends DaoHibernate<CuotaAlquiler> implements CuotaDao{

	@Inject
	protected CuotaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuotaAlquiler> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public List<CuotaAlquiler> getAllOfThisMonth() {
		return getAllOf(YearMonth.now());
	}

	@Override
	public InteresPunitorioCuota getInteresOf(CuotaAlquiler c) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(InteresPunitorioCuota.class)
				.add(Restrictions.eq("cuota", c));
		
		finishTransaction();
		
		List<InteresPunitorioCuota> res = q.list();
		
		if(res.isEmpty())
			return null;
		
		return res.get(0);
	}
	
	@Override
	public List<CuotaAlquiler> getAllOf(YearMonth anioMes) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.add(Restrictions.eq("anioMes", anioMes.toString()));
		
		finishTransaction();
		return q.list();
	}

	@Override
	public void saveInteres(InteresPunitorioCuota interes) {
		initTransaction();
		
		sesion.saveOrUpdate(interes);
		
		finishTransaction();
		
	}

	@Override
	public List<CuotaAlquiler> getCuotasOf(ContratoAlquiler c) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.add(Restrictions.eq("contrato", c));
		
		finishTransaction();
		
		return q.list();
		
	}


	
}
