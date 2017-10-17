package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ContratoAlquilerForm;

@Singleton
public class ContratoAlquilerFormValidator implements ValidatorNew{

	ContratoAlquilerForm view;
	
	@Inject
	private ContratoAlquilerFormValidator(ContratoAlquilerForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return "Errores en los siguientes campos: ";
	}

}
