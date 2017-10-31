package persistencia.dao.hibernate;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.NotificacionDao;

@Singleton
public class NotificacionDaoHibernate extends DaoHibernate<AvisoNotificacion> implements NotificacionDao {

	@Inject
	protected NotificacionDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AvisoNotificacion> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
