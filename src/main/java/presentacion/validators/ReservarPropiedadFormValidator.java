package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ReservarPropiedadForm;

@Singleton
public class ReservarPropiedadFormValidator implements ValidatorNew{

	ReservarPropiedadForm view;
	
	@Inject
	private ReservarPropiedadFormValidator(ReservarPropiedadForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos";
		
		return toRet;
	}

}
