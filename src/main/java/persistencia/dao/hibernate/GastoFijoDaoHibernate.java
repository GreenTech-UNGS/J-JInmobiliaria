package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.GastoFijo;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.GastoFijoDao;

@Singleton
public class GastoFijoDaoHibernate extends DaoHibernate<GastoFijo> implements GastoFijoDao{

	@Inject
	protected GastoFijoDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GastoFijo> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(GastoFijo.class);
		
		finishTransaction();
		
		return q.list();
	}

}
