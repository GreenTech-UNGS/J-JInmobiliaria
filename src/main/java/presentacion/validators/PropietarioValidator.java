package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propietario;

@Singleton
public class PropietarioValidator implements Validator<Propietario>{

	PersonaValidator pValidator;
	
	@Inject
	private PropietarioValidator(PersonaValidator pValidator, MessageShow msgShw) {
		this.pValidator = pValidator;
	}
	
	@Override
	public boolean isValid(Propietario t) {
		return pValidator.isValid(t.getPersona());
	}
	
}
