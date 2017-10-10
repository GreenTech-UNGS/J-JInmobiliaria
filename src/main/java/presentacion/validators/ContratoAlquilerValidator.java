package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;

@Singleton
public class ContratoAlquilerValidator implements Validator<ContratoAlquiler>{

	ContratoValidator cValidator;
	MessageShow msgShw;
	
	@Inject
	private ContratoAlquilerValidator(ContratoValidator cValidator, 
			MessageShow msgShw) {
		
		this.cValidator = cValidator;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(ContratoAlquiler t) {
		
		if(t == null){
			return false;
		}
		else if(cValidator.isValid(t) == false) {
			return false;
		} 
		else if(t.getCuotaMensual().getMonto() <= 0){		
			msgShw.showErrorMessage("Ingrese un precio valido", "Error");
			return false;
		}
		else if(t.getCantMeses() <= 0 || t.getCantMeses() > 100){ //TODO: Cantidades segun tipo		
			msgShw.showErrorMessage("No se puede dar de alta un alquiler por " 
			+ t.getCantMeses() + " meses", "Error");
			return false;
		}
		else if(t.getDatoPunitorio().getDiasDePago() == 0 ||
			t.getDatoActualizacion().getActualizacionMeses() == 0){
			msgShw.showErrorMessage("Faltan completar campos", "Error");
			return false;
		}
		
		return true;
	}
}
