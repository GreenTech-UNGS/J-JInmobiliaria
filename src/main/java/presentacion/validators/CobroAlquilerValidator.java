package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;

@Singleton
public class CobroAlquilerValidator implements Validator<CuotaAlquiler>{

	MessageShow msgShw;
	
	@Inject
	public CobroAlquilerValidator(MessageShow msgShw) {
		
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(CuotaAlquiler t) {
		
		if(t == null){
			return false;
		}else if(t.getMonto().getMonto() <= 0){		
			msgShw.showErrorMessage("Ingrese un monto valido", "Error");
			return false;
		} 
		
		return true;
	}
	
}
