package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;

import entities.Persona;
import entities.PersonaBasica;
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

}
