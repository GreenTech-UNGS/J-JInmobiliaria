package persistencia.dao.hibernate;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Reserva;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

import org.hibernate.Criteria;

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
}
