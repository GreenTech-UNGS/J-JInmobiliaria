package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Contrato;
import entities.Persona;
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

	@Override
	public boolean existeIDContrato(Contrato t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class).
				createAlias("contrato", "contrato").
				setFetchMode("contrato", FetchMode.JOIN).
				add(Restrictions.eq("contrato.ID", t.getID()));
		
		finishTransaction();
		
		List<Contrato> res = q.list();
		
		return !res.isEmpty();
	}
}
