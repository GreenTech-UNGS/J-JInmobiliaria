package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import entities.Reserva;

@Singleton
public class ReservaValidator implements Validator<Reserva>{

    @Inject
    public ReservaValidator() {

    }

    @Override
    public boolean isValid(Reserva reserva) {
        return false;
    }
}
