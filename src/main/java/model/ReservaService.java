package model;

import com.google.inject.Inject;

import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Propiedad;
import entities.Reserva;
import org.joda.time.DateTime;
import persistencia.dao.iface.ReservaDAO;

import java.util.List;
import java.util.stream.Collectors;

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
    
    public List<Reserva> getAllCurrent(){
    	List<Reserva> all = getAll();
    	
    	return all.stream().
    			filter(r -> propiedadService.getCurrentEstado(r.getPropiedad()).equals(EstadoProp.RESERVADA)).
    			collect(Collectors.toList());
    	
    }

    public void saveReserva(Reserva reserva){
        reserva.setFecha(DateTime.now());
        reservaDAO.save(reserva);
        
        HistoriaEstadoProp estado = new HistoriaEstadoProp();
		estado.setEstado(EstadoProp.RESERVADA);
		estado.setFecha(DateTime.now());
		
		reserva.getPropiedad().getEstados().add(estado);
		propiedadService.actualizarPropiedad(reserva.getPropiedad());
        
    }
    
    public Reserva getReservaOf(Propiedad p) {
    	
    	if(p == null)
    		return null;
    	
    	EstadoProp estado = propiedadService.getCurrentEstado(p);
    	
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
