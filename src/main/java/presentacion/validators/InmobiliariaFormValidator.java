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
		return isCredencialValid() 
				&& isEmailValid()
				&& isNombreValid()
				&& isCalleValid()
				&& isAlturaValid()
				&& isLocalidadValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Errores en los siguientes campos";
		if(!isCredencialValid())
			toRet += "\n- El CUIT no es valido";
		if(!isEmailValid())
			toRet += "\n- El email no es valido";
		if(!isNombreValid())
			toRet += "\n- El nombre no es valido";
		if(!isCalleValid())
			toRet += "\n- La calle no es valida";
		if(!isAlturaValid())
			toRet += "\n- La altura no es valida";
		if(!isLocalidadValid())
			toRet += "\n- No ha seleccionado ninguna localidad";
		
		return toRet;
	}
	
	private boolean isCredencialValid(){
		String credencial = view.getTfCuit().getText();
		if(credencial == null || !(credencial.matches(Regex.CUIT()) || credencial.matches(Regex.onlyNumbersCUIT())))
			return false;
			
		return true;
	}
	
	private boolean isEmailValid(){
		String email = view.getTfEmail().getText();
		
		if(email == null || !email.matches(Regex.email()))
			return false;
		
		return true;
	}
	
	private boolean isNombreValid(){
		String nombre = view.getTfNombre().getText();
		
		if(nombre == null || nombre.equals("") || nombre.matches("\\b*"))
			return false;
		if( ! nombre.matches(Regex.onlyLetters()))
			return false;
		
		return true;
	}
	
	private boolean isCalleValid(){
		String calle = view.getTfCalle().getText();
		
		if(calle == null || calle.equals("") || calle.matches("\\b*"))
			return false;

		return true;
	}
	
	private boolean isAlturaValid(){
		String localidad = view.getTfAltura().getText();
		
		if(localidad == null || localidad.equals("") || localidad.matches("\\b*"))
			return false;
		if( ! localidad.matches(Regex.onlyNumbers()))
			return false;
		
		return true;
	}
	
	private boolean isLocalidadValid(){
		String localidad = (String) view.getCbLocalidad().getSelectedItem();
		
		if(localidad == null || localidad.equals("") || localidad.matches("\\b*"))
			return false;
		
		return true;
	}

}
