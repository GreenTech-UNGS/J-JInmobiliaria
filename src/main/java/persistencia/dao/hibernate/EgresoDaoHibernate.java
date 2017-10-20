package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Egreso;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.EgresoDao;

@Singleton
public class EgresoDaoHibernate extends DaoHibernate<Egreso> implements EgresoDao{

	@Inject
	protected EgresoDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Egreso> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Egreso.class);
		
		finishTransaction();
		
		return q.list();
	}

}
