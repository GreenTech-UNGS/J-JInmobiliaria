package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.InmobiliariaForm;

@Singleton
public class InmobiliariaFormValidator implements ValidatorNew {
	
	InmobiliariaForm view;
	
	@Inject
	private InmobiliariaFormValidator(InmobiliariaForm view){
		this.view = view;
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Errores en los siguientes campos";
		return toRet;
	}

}
