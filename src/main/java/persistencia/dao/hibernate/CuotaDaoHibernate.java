package persistencia.dao.hibernate;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;
import entities.Localidad;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CuotaDao;

@Singleton
public class CuotaDaoHibernate extends DaoHibernate<CuotaAlquiler> implements CuotaDao{

	@Inject
	protected CuotaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

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
	
	

	
	
}
