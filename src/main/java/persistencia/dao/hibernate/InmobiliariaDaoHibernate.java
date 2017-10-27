
package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import entities.PersonaBasica;
import entities.Telefono;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.InmobiliariaDao;

@Singleton
public class InmobiliariaDaoHibernate extends DaoHibernate<Inmobiliaria> implements InmobiliariaDao{
	
	@Inject
	protected InmobiliariaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Inmobiliaria> getAll() {
		initTransaction();
		Criteria q = sesion.createCriteria(Inmobiliaria.class);
		
		List<Inmobiliaria> toRet = q.list();
		
		finishTransaction();
		
		return toRet;
	}

	@Override
	public List<Telefono> getAllTelefonosOf(Inmobiliaria i) {
initTransaction();
		
		Criteria q = sesion.createCriteria(Inmobiliaria.class).
							add(Restrictions.eq("id", i.getID()));
		
		q.setFirstResult(0);
		q.setMaxResults(1);
		finishTransaction();
		
		if(q.list().isEmpty())
			return null;
		
		return ((PersonaBasica)(q.list().get(0))).getTelefonos();
	}
}

