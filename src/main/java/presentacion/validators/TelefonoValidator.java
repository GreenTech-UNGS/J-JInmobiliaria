package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Telefono;

@Singleton
public class TelefonoValidator implements Validator<Telefono>{

	MessageShow msgShw;
	
	@Inject
	public TelefonoValidator(MessageShow msgShw) {
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Telefono t) {
		if(t.getNumero().matches(Regex.onlyNumbers()) == false) {
			msgShw.showErrorMessage("El numero de teléfono es invalido", "Error");
			return false;
		}
		return true;
	}

}
