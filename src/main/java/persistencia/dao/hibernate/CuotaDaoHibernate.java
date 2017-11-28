package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
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
		
		List<CuotaAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
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

		List<InteresPunitorioCuota> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		
		if(toRet.isEmpty())
			return null;
		
		return toRet.get(0);
	}
	
	@Override
	public List<CuotaAlquiler> getAllOf(YearMonth anioMes) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.add(Restrictions.eq("anioMes", anioMes.toString()));
		
		List<CuotaAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public void saveInteres(InteresPunitorioCuota interes) {
		initTransaction();
		
		sesion.saveOrUpdate(interes);
		
		finishTransaction();
		
	}

	@Override
	public List<CuotaAlquiler> getCuotasOf(ContratoAlquiler c) {initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.add(Restrictions.eq("contrato", c));
		
		List<CuotaAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;

		
	}

	@Override
	public List<CuotaAlquiler> getAllCuotasOf(Cliente c) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.createAlias("contrato", "contr")
				.add(Restrictions.eq("contr.cliente", c))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<CuotaAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public int getCantidadCuotasOf(ContratoAlquiler c) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class)
				.createAlias("contrato", "contr")
				.add(Restrictions.eq("contr.ID", c.getID()))
				.setProjection(Projections.rowCount())
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		int toRet = Integer.parseInt(q.uniqueResult() + "");
		finishTransaction();
		
		return toRet;
	}


	
}
