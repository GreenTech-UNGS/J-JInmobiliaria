package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import entities.Propiedad;
import entities.Reserva;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ReservaDAO;

public class ReservaDaoHibernate extends DaoHibernate<Reserva> implements ReservaDAO {

    @Inject
    private ReservaDaoHibernate(Conexion conexion) {
        super(conexion);
    }

    @Override
    public List<Reserva> getAll() {
    	initTransaction();
		
		Criteria q = sesion.createCriteria(Reserva.class);
		
		List<Reserva> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
    }

	@Override
	public List<Reserva> getReservasOf(Propiedad p) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Reserva.class)
				.add(Restrictions.eq("propiedad", p));
		
		List<Reserva> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}
}
