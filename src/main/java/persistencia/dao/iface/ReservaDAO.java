package persistencia.dao.iface;

import entities.Propiedad;
import entities.Reserva;

import java.util.List;

public interface ReservaDAO extends Dao<Reserva>{

    List<Reserva> getReservasOf(Propiedad p);

}
