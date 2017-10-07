package model;

import com.google.inject.Inject;
import entities.Reserva;
import org.joda.time.DateTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ReservaService {

    @Inject
    private ReservaService(){}

    public List<Reserva> getAll(){
        throw new NotImplementedException();
    }

    public void saveReserva(Reserva reserva){
        reserva.setFecha(DateTime.now());
        //LLAMAR AL DAO
        throw new NotImplementedException();
    }

    public Reserva getEmptyReserva() {
        Reserva toRet = new Reserva();
        toRet.setHabilitada(true);

        return toRet;
    }

}
