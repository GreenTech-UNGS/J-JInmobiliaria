package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import entities.Propietario;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PropietarioDao;

@Singleton
public class PropietarioDaoHibernate extends DaoHibernate<Propietario> implements PropietarioDao{

	@Inject
	protected PropietarioDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Propietario> getAll() {
		initTransaction();
		Criteria q = sesion.createCriteria(Propietario.class);
		
		finishTransaction();
		
		return q.list();
	}
	

}
