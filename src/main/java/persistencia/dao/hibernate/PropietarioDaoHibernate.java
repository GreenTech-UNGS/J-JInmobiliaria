package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PagoPropietario;
import entities.Persona;
import entities.Propietario;
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
		
		finishTransaction();
		
		return q.list();
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
		
		finishTransaction();
		
		return q.list();
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
		
		finishTransaction();
		
		List<Propietario> res = q.list();
		
		return ! (res.isEmpty());
	}
	

}
