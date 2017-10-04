package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PersonaBasica;

@Singleton
public class PersonaBasicaValidator implements Validator<PersonaBasica>{

	MessageShow msgShw;
	
	@Inject
	public PersonaBasicaValidator(MessageShow msgShw) {
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(PersonaBasica t) {
		if(hayCamposVacios(t)) {
			msgShw.showErrorMessage("Hay Campos Vacios", "Error");
			return false;
		} else if(isNameValid(t)) {
			msgShw.showErrorMessage("El nombre y el apellido solo pueden contener letras", "Error");
			return false;
		} else if(isEmailValid(t)) {
			msgShw.showErrorMessage("La direccion de mail es invalida", "Error");
			return false;
		}
		return true;
	}
	
	private boolean isNameValid(PersonaBasica t) {		
		return t.getNombre().matches(Regex.onlyLetters()) && 
				t.getApellido().matches(Regex.onlyLetters());
	}
	
	private boolean isEmailValid(PersonaBasica t) {		
		return t.getEmail().matches(Regex.email());
	}
	
	private boolean hayCamposVacios(PersonaBasica t) {
		return t.getApellido().equals("") ||
				t.getNombre().equals("") ||
				t.getEmail().equals("");
	}

}
