package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.UsuarioForm;

@Singleton
public class UsuarioFormValidator implements ValidatorNew{
	
	private UsuarioForm view;
	
	@Inject
	private UsuarioFormValidator( UsuarioForm view){
		this.view = view;
	}

	@Override
	public boolean isValid() {
		return isEmailValid()
				&& isNombreValid()
				&& isApellidoValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siuientes campos: ";
		if(!isEmailValid())
			toRet += "\n- El email no es valido";
		if(!isNombreValid())
			toRet += "\n- El nombre no es valido";
		if(!isApellidoValid())
			toRet += "\n- El apellido no es valido";
		
		return toRet;
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
