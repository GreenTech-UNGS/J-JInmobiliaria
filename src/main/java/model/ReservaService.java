package model;

import com.google.inject.Inject;
import entities.Reserva;
import org.joda.time.DateTime;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

public class ReservaService {

    private ReservaDAO reservaDAO;

    @Inject
    private ReservaService(ReservaDAO reservaDAO){
        this.reservaDAO = reservaDAO;
    }

    public List<Reserva> getAll(){
        return reservaDAO.getAll();
    }

    public void saveReserva(Reserva reserva){
        reserva.setFecha(DateTime.now());
        reservaDAO.save(reserva);
    }

    public Reserva getEmptyReserva() {
        Reserva toRet = new Reserva();
        toRet.setHabilitada(true);

        return toRet;
    }

}
