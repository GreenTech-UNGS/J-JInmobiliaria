package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PagoPropietario;
import entities.Persona;
import entities.Propietario;
import filtros.PropietarioFiltro;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PropietarioDao;

@Singleton
public class PropietarioDaoHibernate extends DaoHibernate<Propietario> implements PropietarioDao{

	@Inject
	protected PropietarioDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Propietario> getAll() {
		initTransaction();
		Criteria q = sesion.createCriteria(Propietario.class);
		
		List<Propietario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public void generaPago(PagoPropietario pago) {
		initTransaction();

		sesion.saveOrUpdate(pago);
		
		finishTransaction();	
	}

	@Override
	public List<PagoPropietario> getAllPagosPropsPendientes() {
		initTransaction();
		Criteria q = sesion.createCriteria(PagoPropietario.class).add(Restrictions.eq("estado", PagoPropietario.EstadoPago.PENDIENTE));
		
		List<PagoPropietario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public void savePago(PagoPropietario p) {
		initTransaction();
		
		sesion.saveOrUpdate(p);
		
		finishTransaction();
		
	}
	
	@Override
	public boolean existePropietarioCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Propietario.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial()));
		
		List<Propietario> toRet = q.list();
		
		finishTransaction();
				
		actualizeList(toRet);
		return ! (toRet.isEmpty());
	}

	@Override
	public List<Propietario> getAllByFiltro(PropietarioFiltro filtro) {
		initTransaction();
		Criteria q = sesion.createCriteria(Propietario.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.like("persona.nombre", filtro.getNombre(), MatchMode.ANYWHERE)).
				add(Restrictions.like("persona.apellido", filtro.getApellido(), MatchMode.ANYWHERE)).
				add(Restrictions.like("persona.credencial", filtro.getCredencial(), MatchMode.ANYWHERE)).
				add(Restrictions.eq("persona.tipoCred", filtro.getTipoCredencial()));
		
		List<Propietario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public Propietario getPropietarioOf(Persona p) {
		initTransaction();
		Criteria q = sesion.createCriteria(Propietario.class).
				add(Restrictions.eq("persona", p));
		
		Propietario toRet = (Propietario) q.list().get(0);
		
		finishTransaction();
		
		return toRet;
	}
	

}
