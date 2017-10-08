package persistencia.dao.hibernate;

import com.google.inject.Inject;
import entities.Reserva;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

public class ReservaDaoHibernate extends DaoHibernate<Reserva> implements ReservaDAO {

    @Inject
    private ReservaDaoHibernate(Conexion conexion) {
        super(conexion);
    }

    @Override
    public List<Reserva> getAll() {
        throw new RuntimeException("No implementado aún");
    }
}
