package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Persona;
import entities.Provincia;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.LocalidadDao;

@Singleton
public class LocalidadDaoHibernate extends DaoHibernate<Localidad> implements LocalidadDao{

	@Inject
	protected LocalidadDaoHibernate(Conexion conexion) {
		super(conexion);
		
		Localidad l = new Localidad();

	}

	@Override
	public List<Localidad> getAllOf(Provincia p) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Localidad.class).
				add(Restrictions.eq("provincia", p));
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public List<Localidad> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Localidad.class);
		
		finishTransaction();
		
		return q.list();
	}

}
