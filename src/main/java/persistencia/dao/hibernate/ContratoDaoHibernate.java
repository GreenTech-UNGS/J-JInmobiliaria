package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Contrato;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ContratoDao;

@Singleton
public class ContratoDaoHibernate extends DaoHibernate<Contrato> implements ContratoDao{

	@Inject
	protected ContratoDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Contrato> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class);
		
		finishTransaction();
		
		return q.list();
	}

}
