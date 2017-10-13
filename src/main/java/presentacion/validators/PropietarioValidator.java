package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propietario;
import model.PropietarioService;

@Singleton
public class PropietarioValidator implements Validator<Propietario>{

	PersonaValidator pValidator;
	PropietarioService propietarioService;
	MessageShow msgShw;
	
	@Inject
	private PropietarioValidator(PersonaValidator pValidator, 
			PropietarioService propietarioService,
			MessageShow msgShw) {
		this.pValidator = pValidator;
		this.propietarioService = propietarioService;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Propietario t) {
		

		if(propietarioService.existePropietarioCon(t.getPersona())) {
			msgShw.showErrorMessage("El propietario ya esta agregado", "Error");
			return false;
		}
		else{
			return t != null && pValidator.isValid(t.getPersona());
		}
	}
	
}
