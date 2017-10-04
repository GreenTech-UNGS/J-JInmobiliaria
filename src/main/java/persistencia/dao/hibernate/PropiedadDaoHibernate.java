package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona;
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

}
