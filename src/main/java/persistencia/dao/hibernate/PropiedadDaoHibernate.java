package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class PropiedadDaoHibernate extends DaoHibernate<Propiedad> implements PropiedadDao{

	@Inject
	protected PropiedadDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Propiedad> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Propiedad.class);
		
		finishTransaction();
		
		return q.list();
	}
	
	@Override
	public boolean existePropiedadConIdentificador(String identificador) {
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Propiedad.class).
				add(Restrictions.eq("identificador", identificador));
		
		finishTransaction();
		
		return ! (q.list().isEmpty());
		
	}
	
	public void actualizePropiedad(Propiedad toActualize) {
		initTransaction();
		sesion.saveOrUpdate(toActualize);
		finishTransaction();
		
	}
}
