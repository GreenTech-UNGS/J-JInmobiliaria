package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import filtros.ClienteFiltro;
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
		
		List<Cliente> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public boolean existeClienteCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Cliente.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial()));
		
		List<Cliente> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);

		return ! (toRet.isEmpty());
	}
	
	@Override
	public List<Cliente> getAllByFiltro(ClienteFiltro filtro) {
		initTransaction();
		Criteria q = sesion.createCriteria(Cliente.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.like("persona.nombre", filtro.getNombre(), MatchMode.ANYWHERE)).
				add(Restrictions.like("persona.apellido", filtro.getApellido(), MatchMode.ANYWHERE)).
				add(Restrictions.like("persona.credencial", filtro.getCredencial(), MatchMode.ANYWHERE)).
				add(Restrictions.eq("persona.tipoCred", filtro.getTipoCredencial()));
		
		List<Cliente> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public void actualizeCliente(Cliente toActualize) {
		initTransaction();
		sesion.saveOrUpdate(toActualize);
		finishTransaction();
		
	}
}
