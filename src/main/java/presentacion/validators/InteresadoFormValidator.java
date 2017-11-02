package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import presentacion.vista.InteresadoForm;

@Singleton
public class InteresadoFormValidator implements ValidatorNew {
	
	private InteresadoForm view;
	
	@Inject
	private InteresadoFormValidator(InteresadoForm view){
		this.view= view;
	}

	@Override
	public boolean isValid() {
		return isCredencialValid() 
				&& isEmailValid()
				&& isNombreValid()
				&& isApellidoValid();
	}	

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos: ";
		if(!isCredencialValid())
			toRet += "\n- La credencial no es valida";
		if(!isEmailValid())
			toRet += "\n- El email no es valido";
		if(!isNombreValid())
			toRet += "\n- El nombre no es valido";
		if(!isApellidoValid())
			toRet += "\n- El apellido no es valido";
		
		return toRet;
	}
	
	private boolean isCredencialValid(){
		
		TipoCredencial tipoCred = TipoCredencial.valueOf((String)view.getCbCredencial().getSelectedItem());
		String credencial = view.getTfCredencial().getText();
		if(tipoCred == TipoCredencial.DNI)
			if(credencial == null || (!credencial.matches(Regex.DNI()) && !credencial.matches(Regex.OnlyNumbersDNI())))
				return false;

		if(tipoCred == TipoCredencial.CUIT)
			if(credencial == null || (!credencial.matches(Regex.CUIT()) && !credencial.matches(Regex.onlyNumbersCUIT())))
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
	
	private boolean isApellidoValid(){
		String apellido = view.getTfApellido().getText();
		
		if(apellido == null || apellido.equals("") || apellido.matches("\\b*"))
			return false;
		if( ! apellido.matches(Regex.onlyLetters()))
			return false;
		
		return true;
	}

}
