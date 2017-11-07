package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import entities.Cartel;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CartelDao;

public class CartelDaoHibernate extends DaoHibernate<Cartel> implements CartelDao{

	@Inject
	private CartelDaoHibernate(Conexion c) {
		super(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cartel> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cartel.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public boolean existeCartelCon(String identificador) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cartel.class).
				add(Restrictions.eq("identificador", identificador));
		
		finishTransaction();
				
		List<Cartel> res = q.list();
		
		return ! (res.isEmpty());
	}

}
