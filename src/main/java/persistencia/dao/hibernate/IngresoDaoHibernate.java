package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.Ingreso;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.IngresoDao;

@Singleton
public class IngresoDaoHibernate extends DaoHibernate<Ingreso> implements IngresoDao{

	@Inject
	protected IngresoDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Ingreso> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Ingreso.class);
		
		finishTransaction();
		
		return q.list();
	}

}
