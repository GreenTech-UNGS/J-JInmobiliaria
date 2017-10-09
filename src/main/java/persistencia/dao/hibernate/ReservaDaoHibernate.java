package persistencia.dao.hibernate;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Propiedad;
import entities.Reserva;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ReservaDaoHibernate extends DaoHibernate<Reserva> implements ReservaDAO {

    @Inject
    private ReservaDaoHibernate(Conexion conexion) {
        super(conexion);
    }

    @Override
    public List<Reserva> getAll() {
    	initTransaction();
		
		Criteria q = sesion.createCriteria(Reserva.class);
		
		finishTransaction();
		
		return q.list();
    }

	@Override
	public List<Reserva> getReservasOf(Propiedad p) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Reserva.class)
				.add(Restrictions.eq("propiedad", p));
		
		finishTransaction();
		
		return q.list();
	}
}
