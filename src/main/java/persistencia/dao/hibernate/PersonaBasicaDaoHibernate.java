package persistencia.dao.hibernate;

import com.google.inject.Inject;
import entities.PersonaBasica;
import org.hibernate.Criteria;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PersonaBasicaDao;

import java.util.List;

public class PersonaBasicaDaoHibernate extends DaoHibernate<PersonaBasica> implements PersonaBasicaDao{

	@Inject
	private PersonaBasicaDaoHibernate(Conexion c) {
		super(c);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaBasica> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(PersonaBasica.class);
		
		finishTransaction();
		
		return q.list();
	}
}
