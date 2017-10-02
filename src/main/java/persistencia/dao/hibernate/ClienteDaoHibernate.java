package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;

import entities.Cliente;
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
	
	

}
