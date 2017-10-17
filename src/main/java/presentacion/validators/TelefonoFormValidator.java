package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.TelefonoForm;

@Singleton
public class TelefonoFormValidator implements ValidatorNew{
	
	TelefonoForm view;
	
	@Inject
	private TelefonoFormValidator(TelefonoForm view) {
		this.view = view;
	}

	@Override
	public boolean isValid() {
		return isTelefonoValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siuientes campos: ";
		if(!isTelefonoValid())
			toRet += "\n- El telefono no es valido";
		
		return toRet;
	}
	
	private boolean isTelefonoValid(){
		return view.getTextTelefono().getText().matches("[0-9]*-[0-9]*");
	}

}
