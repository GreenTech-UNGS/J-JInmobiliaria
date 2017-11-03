package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cita;
import entities.Usuario;
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

	@Override
	public List<Cita> getCitasOf(Usuario u) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class)
				.createAlias("asistentes", "asisit")
				.add(Restrictions.eq("asisit.ID", u.getID()));
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<Cita> getProximasOf(Usuario u) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cita.class)
				.createAlias("asistentes", "asisit")
				.add(Restrictions.eq("asisit.ID", u.getID())).
				add(Restrictions.ge("fechaHora", DateTime.now()));
		
		List<Cita> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
