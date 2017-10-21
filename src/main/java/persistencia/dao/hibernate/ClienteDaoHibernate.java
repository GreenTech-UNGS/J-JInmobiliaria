package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import entities.PersonaBasica;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ClienteDao;

public class ClienteDaoHibernate extends DaoHibernate<Cliente> implements ClienteDao{

	@Inject
	private ClienteDaoHibernate(Conexion c) {
		super(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cliente.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public boolean existeClienteCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cliente.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial()));
		
		finishTransaction();
				
		List<Cliente> res = q.list();
		
		return ! (res.isEmpty());
	}

	@Override
	public void actualizeCliente(Cliente toActualize) {
		initTransaction();
		sesion.saveOrUpdate(toActualize);
		finishTransaction();
		
	}
}
