package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.PersonaBasica;
import entities.Telefono;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PersonaDao;

public class PersonaDaoHibernate extends DaoHibernate<Persona> implements PersonaDao{
	
	@Inject
	private PersonaDaoHibernate(Conexion c) {
		super(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Persona.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public List<Telefono> getAllTelefonosOf(PersonaBasica pb) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(PersonaBasica.class).
							add(Restrictions.eq("id", pb.getID()));
		
		q.setFirstResult(0);
		q.setMaxResults(1);
		finishTransaction();
		
		if(q.list().isEmpty())
			return null;
		
		return ((PersonaBasica)(q.list().get(0))).getTelefonos();
	}

	@Override
	public boolean existePersonaConCredencial(String credencial, TipoCredencial tipo) {
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Persona.class).
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("credencial", credencial)).
				add(Restrictions.eq("tipoCred", tipo));
		
		finishTransaction();
		
		return !q.list().isEmpty();
		
	}

	@Override
	public Persona getPersonaWith(int ID) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Persona.class).
				add(Restrictions.eq("ID", ID));
		
		finishTransaction();
		
		List<Persona> res = q.list();
		
		if(res.isEmpty())
			return null;
		
		return res.get(0);
	}

}
