package model;

import com.google.inject.Inject;
import entities.Reserva;
import org.joda.time.DateTime;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

public class ReservaService {

    private ReservaDAO reservaDAO;

    @Inject
    private ReservaService(){}

    public List<Reserva> getAll(){
        throw new RuntimeException("No implementado aún");
    }

    public void saveReserva(Reserva reserva){
        reserva.setFecha(DateTime.now());
        //LLAMAR AL DAO
        throw new RuntimeException();
    }

    public Reserva getEmptyReserva() {
        Reserva toRet = new Reserva();
        toRet.setHabilitada(true);

        return toRet;
    }

}
