package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;

import entities.PersonaBasica;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PersonaBasicaDao;

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
		
		List<PersonaBasica> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}
}
