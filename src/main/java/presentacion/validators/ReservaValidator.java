package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.Reserva;
import model.PropiedadService;

@Singleton
public class ReservaValidator implements Validator<Reserva>{

	PropiedadService propiedadService;
	MessageShow msgShw;
	
    @Inject
    public ReservaValidator(PropiedadService propiedadService,
    		MessageShow msgShw) {
    	this.propiedadService = propiedadService;
    	this.msgShw = msgShw;
    }

    @Override
    public boolean isValid(Reserva reserva) {
       
    	if(propiedadService.getCurrentEstado(reserva.getPropiedad()).equals(EstadoProp.DISPONIBLE) == false){
    		msgShw.showErrorMessage("La propiedad seleccionada no esta disponible", "Error");
			return false;
    	}
    		
    	return false;
    }
}
