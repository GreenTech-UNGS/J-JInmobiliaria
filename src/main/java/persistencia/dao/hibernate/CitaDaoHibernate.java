package persistencia.dao.hibernate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import entities.Cita;
import entities.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CitaDao;

import java.util.List;

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

	@Override
	public List<Cita> getCitasOf(Usuario u) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class)
				.add(Restrictions.eq("asisitente.ID", u.getID()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<Cita> getProximasOf(Usuario u) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class)
				.add(Restrictions.eq("asisitente.ID", u.getID())).
				add(Restrictions.ge("fechaHora", LocalDateTime.now()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<Cita> getProximas() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class)
				.add(Restrictions.ge("fechaHora", LocalDateTime.now()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
