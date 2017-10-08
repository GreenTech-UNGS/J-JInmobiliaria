package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.Inmobiliaria;
import persistencia.conexion.Conexion;
import persistencia.iface.InmobiliariaDao;

@Singleton
public class InmobiliariaDaoHibernate extends DaoHibernate<Inmobiliaria> implements InmobiliariaDao {

	@Inject
	protected InmobiliariaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Inmobiliaria> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Inmobiliaria.class);
		
		finishTransaction();
		
		return q.list();
	}

}
