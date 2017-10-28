package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Contrato;
import entities.ContratoAlquiler;
import entities.ContratoVenta;
import filtros.ContratoAlquilerFiltro;
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
		
		List<Contrato> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public boolean existeContratoConIdentificador(String identificador) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class).
				add(Restrictions.eq("identificador", identificador));
		
		List<Contrato> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		
		return ! (toRet.isEmpty());
	}

	@Override
	public List<ContratoAlquiler> getAllAlquiler() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(ContratoAlquiler.class);
		
		List<ContratoAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<ContratoVenta> getAllVenta() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(ContratoVenta.class);

		List<ContratoVenta> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public List<ContratoAlquiler> getAllBy(ContratoAlquilerFiltro filtro) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class)
				.add(Restrictions.eqOrIsNull("propiedad", filtro.getPropiedad()));
		
		List<ContratoAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}
}
