package model;

import com.google.inject.Inject;

import entities.EstadoProp;
import entities.Propiedad;
import entities.Reserva;
import org.joda.time.DateTime;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;

public class ReservaService {

    private ReservaDAO reservaDAO;
    private PropiedadService propiedadService;

    @Inject
    private ReservaService(ReservaDAO reservaDAO, PropiedadService propiedadService){
        this.reservaDAO = reservaDAO;
        this.propiedadService = propiedadService;
    }

    public List<Reserva> getAll(){
        return reservaDAO.getAll();
    }

    public void saveReserva(Reserva reserva){
        reserva.setFecha(DateTime.now());
        reservaDAO.save(reserva);
    }
    
    public Reserva getReservaOf(Propiedad p) {
    	
    	EstadoProp estado =propiedadService.getCurrentEstado(p);
    	
    	if(!estado.equals(EstadoProp.RESERVADA)) {
    		return null;
    	}
    	
    	List<Reserva> reservas = reservaDAO.getReservasOf(p);
    	
    	reservas.sort((r1, r2) -> r2.getFecha().compareTo(r1.getFecha()));
    	
    	return reservas.get(0);
    	
    }

    public Reserva getEmptyReserva() {
        Reserva toRet = new Reserva();
        toRet.setHabilitada(true);

        return toRet;
    }
    public void remove(Reserva r){
    	reservaDAO.remove(r);
    }

}
