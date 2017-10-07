package persistencia.dao.hibernate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
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
		throw new RuntimeException("NO implementado");
	}

	@Override
	public InteresPunitorioCuota getInteresOf(CuotaAlquiler c) {
		throw new RuntimeException("NO implementado");
	}
	
	@Override
	public List<CuotaAlquiler> getAllOf(YearMonth anioMes) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.add(Restrictions.eq("anioMes", anioMes.toString()));
		
		finishTransaction();
		return q.list();
	}
	
}
