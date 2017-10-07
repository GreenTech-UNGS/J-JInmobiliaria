package presentacion.validators;


import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoVenta;

@Singleton
public class ContratoVentaValidator implements Validator<ContratoVenta>{

	ContratoValidator cValidator;
	MessageShow msgShw;
	
	@Inject
	private ContratoVentaValidator(ContratoValidator cValidator, 
			MessageShow msgShw) {
		
		this.cValidator = cValidator;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(ContratoVenta t) {
		
		//TODO: DIFERENCIAR TIPOS
		
		if(t == null){
			return false;
		}
		else if(cValidator.isValid(t) == false) {
			return false;
		} 
		else if(t.getMonto().getMonto() <= 0){		
			msgShw.showErrorMessage("Ingrese un precio valido", "Error");
			return false;
		}

		return true;
	}
	
}
