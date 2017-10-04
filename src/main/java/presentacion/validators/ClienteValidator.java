package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;

@Singleton
public class ClienteValidator implements Validator<Cliente>{

	PersonaValidator pValidator;
	
	@Inject
	private ClienteValidator(PersonaValidator pValidator, MessageShow msgShw) {
		this.pValidator = pValidator;
	}
	
	@Override
	public boolean isValid(Cliente t) {
		return pValidator.isValid(t.getPersona());
	}
	
}
