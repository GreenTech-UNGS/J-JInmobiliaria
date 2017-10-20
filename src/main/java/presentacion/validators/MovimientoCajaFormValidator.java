package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.MovimientoCajaForm;

@Singleton
public class MovimientoCajaFormValidator implements ValidatorNew{

	@Inject MovimientoCajaForm view;
	
	@Override
	public boolean isValid() {
		return isMontoValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos: ";
		
		if(!isMontoValid())
			toRet += "\n- El monto debe ser un numero valido";
		
		return toRet;
	}
	
	private boolean isMontoValid() {
		if(view.getTextMonto().getText() == null)
			return false;
		return view.getTextMonto().getText().matches("[0-9]+(\\.[0-9]+)?") &&
				Double.parseDouble(view.getTextMonto().getText()) > 0;
	}

}
