package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import entities.TipoHabitacion;
import filtros.PropiedadFiltro;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class PropiedadDaoHibernate extends DaoHibernate<Propiedad> implements PropiedadDao{

	@Inject
	protected PropiedadDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Propiedad> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Propiedad.class);
		
		finishTransaction();
		
		return q.list();
	}
	
	@Override
	public boolean existePropiedadConIdentificador(String identificador) {
		
		initTransaction();
		
		Criteria q = sesion.createCriteria(Propiedad.class).
				add(Restrictions.eq("identificador", identificador));
		
		finishTransaction();
		
		return ! (q.list().isEmpty());
		
	}
	
	public void actualizePropiedad(Propiedad toActualize) {
		initTransaction();
		sesion.saveOrUpdate(toActualize);
		finishTransaction();
		
	}
	
	@Override
	public List<Propiedad> getAllByFiltro(PropiedadFiltro filtro){
		initTransaction();
		System.out.println(filtro.getPrecioHasta());
		Criteria q = sesion.createCriteria(Propiedad.class)
				.createAlias("precioTentativo", "precio")
				.add(Restrictions.eqOrIsNull("localidad", filtro.getLocalidad()))
				.add(Restrictions.eqOrIsNull("precio.moneda", filtro.getMoneda()))
				.add(Restrictions.ge("precio.monto", filtro.getPrecioDesde()))
				.add(Restrictions.le("precio.monto", filtro.getPrecioHasta()))
				.add(Restrictions.eqOrIsNull("tipoOfrecimiento", filtro.getTipoOfrecimiento()));
		
		finishTransaction();
		
		return q.list();		
	}

	@Override
	public List<TipoHabitacion> getAllTipoHabitacion() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(TipoHabitacion.class);
		
		finishTransaction();
		
		return q.list();
	}
}
