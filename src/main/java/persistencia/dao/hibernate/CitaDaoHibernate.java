package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CitaDao;

@Singleton
public class CitaDaoHibernate extends DaoHibernate<Cita> implements CitaDao{

	@Inject
	protected CitaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cita> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class);
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
