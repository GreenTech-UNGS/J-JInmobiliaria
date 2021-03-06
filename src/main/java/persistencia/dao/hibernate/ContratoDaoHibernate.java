package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Contrato;
import entities.ContratoAlquiler;
import entities.ContratoVenta;
import entities.EstadoContrato;
import entities.HistoriaEstadoProp;
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
	public synchronized List<Contrato> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class);
		
		List<Contrato> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public synchronized boolean existeContratoConIdentificador(String identificador) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class).
				add(Restrictions.eq("identificador", identificador));
		
		List<Contrato> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		
		return ! (toRet.isEmpty());
	}

	@Override
	public synchronized List<ContratoAlquiler> getAllAlquiler() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(ContratoAlquiler.class);
		
		List<ContratoAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public synchronized List<ContratoVenta> getAllVenta() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(ContratoVenta.class);

		List<ContratoVenta> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public synchronized List<ContratoAlquiler> getAllBy(ContratoAlquilerFiltro filtro) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Contrato.class)
				.add(Restrictions.eqOrIsNull("propiedad", filtro.getPropiedad()));
		
		List<ContratoAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public synchronized List<ContratoAlquiler> getAlquilerVigentes() {
		initTransaction();
		
		
		Criteria q = sesion.createCriteria(ContratoAlquiler.class, "contr1")
				.createAlias("estados", "e")
				.add(Restrictions.eq("e.estado", EstadoContrato.DEFINITIVO))
				.add(Subqueries.propertyGeAll("e.fecha", DetachedCriteria
						.forClass(ContratoAlquiler.class, "contr2")
						.createAlias("estados", "e2")
						.add(Restrictions.eqProperty("contr1.ID", "contr2.ID"))
						.setProjection(Projections.property("e2.fecha"))));
		
		List<ContratoAlquiler> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}
}
