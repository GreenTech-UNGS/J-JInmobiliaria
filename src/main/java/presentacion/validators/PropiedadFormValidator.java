package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.PropiedadForm;

@Singleton
public class PropiedadFormValidator implements ValidatorNew{

	
	PropiedadForm view;
	
	@Inject
	private PropiedadFormValidator(PropiedadForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return isPrecioValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos: ";
		
		if(!isPrecioValid())
			toRet += "\n- El precio no es valido";
		
		return toRet;
	}
	
	private boolean isPrecioValid(){
		return view.getTfPrecio().getText().matches("([0-9]*[\\.])?[0-9]+");
	}

}
