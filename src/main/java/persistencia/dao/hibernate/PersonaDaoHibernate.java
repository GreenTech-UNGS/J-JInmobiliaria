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
		
		List<Persona> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<Telefono> getAllTelefonosOf(PersonaBasica pb) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(PersonaBasica.class).
							add(Restrictions.eq("id", pb.getID()));
		
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<PersonaBasica> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		
		if(toRet.isEmpty())
			return null;
		
		return ((toRet.get(0))).getTelefonos();
	}

	@Override
	public boolean existePersonaConCredencial(String credencial, TipoCredencial tipo) {
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Persona.class).
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("credencial", credencial)).
				add(Restrictions.eq("tipoCred", tipo));
		
		List<Persona> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return ! (toRet.isEmpty());
		
	}

	@Override
	public Persona getPersonaWith(int ID) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Persona.class).
				add(Restrictions.eq("ID", ID));
		
		List<Persona> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		
		if(toRet.isEmpty())
			return null;
		
		return toRet.get(0);
	}

	@Override
	public List<PersonaBasica> getAllBasicas() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(PersonaBasica.class);
		
		List<PersonaBasica> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
