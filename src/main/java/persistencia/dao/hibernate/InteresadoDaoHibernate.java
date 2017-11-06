package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Interesado;
import entities.Persona;
import filtros.ClienteFiltro;
import filtros.InteresadoFiltro;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.InteresadoDao;

@Singleton
public class InteresadoDaoHibernate extends DaoHibernate<Interesado> implements InteresadoDao{
	
	@Inject
	private InteresadoDaoHibernate(Conexion conexion) {
		super(conexion);
	}

	@Override
	public List<Interesado> getAll() {
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Interesado.class);
		
		List<Interesado> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}
	
	@Override
	public boolean existeInteresadoCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Interesado.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial()));
		
		List<Cliente> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);

		return ! (toRet.isEmpty());
	}
	
	@Override
	public List<Interesado> getAllByFiltro(InteresadoFiltro filtro) {
		initTransaction();
		Criteria q = sesion.createCriteria(Interesado.class)
				.createAlias("preferencia", "pref")
				.add(Restrictions.eqOrIsNull("pref.localidad", filtro.getLocalidad()))
				.add(Restrictions.ge("pref.precioDesde", filtro.getPrecioDesde()))
				.add(Restrictions.le("pref.precioHasta", filtro.getPrecioHasta()))
				.add(Restrictions.eqOrIsNull("pref.tipoOfrecimiento", filtro.getTipoOfrecimiento()));
		
		List<Interesado> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

}
