package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.RegistrarCobroForm;

@Singleton
public class RegistrarCobroFormValidator implements ValidatorNew{

	RegistrarCobroForm view;
	
	@Inject
	private RegistrarCobroFormValidator(RegistrarCobroForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		return isFechaValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos:";
		
		if(!isFechaValid())
			toRet += "\n- La fecha no es valida";
		
		return toRet;
		
	}

	private boolean isFechaValid(){
		//TODO: eliminar clase
		return true;
	}
	
}
