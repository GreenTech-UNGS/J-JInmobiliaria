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
		}
		return true;
	}
	
	private boolean hayCamposVacios(PersonaBasica t) {
		return t.getApellido().equals("") ||
				t.getNombre().equals("") ||
				t.getEmail().equals("");
	}

}
