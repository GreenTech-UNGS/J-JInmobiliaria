package persistencia.dao.iface;

import java.util.List;

import entities.Propiedad;
import entities.Reserva;

public interface ReservaDAO extends Dao<Reserva>{

    List<Reserva> getReservasOf(Propiedad p);

}
