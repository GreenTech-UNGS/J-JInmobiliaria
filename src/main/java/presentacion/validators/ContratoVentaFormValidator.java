package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ContratoVentaForm;

@Singleton
public class ContratoVentaFormValidator implements ValidatorNew{

	ContratoVentaForm view;
	
	@Inject
	private ContratoVentaFormValidator(ContratoVentaForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Errores en los siguientes campos";
		
		return toRet;
		
	}

}
