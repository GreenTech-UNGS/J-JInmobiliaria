package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Provincia;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.LocalidadDao;

@Singleton
public class LocalidadDaoHibernate extends DaoHibernate<Localidad> implements LocalidadDao{

	@Inject
	protected LocalidadDaoHibernate(Conexion conexion) {
		super(conexion);
	}

	@Override
	public List<Localidad> getAllOf(Provincia p) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Localidad.class).
				add(Restrictions.eq("provincia", p));
		
		List<Localidad> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<Provincia> getProvincias(){
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Provincia.class);
		
		List<Provincia> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
		
	}

	@Override
	public List<Localidad> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Localidad.class);
		
		List<Localidad> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
