package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Ingreso;

@Singleton
public class IngresoValidator implements Validator<Ingreso>{

	MessageShow msgShw;
	
	@Inject
	public IngresoValidator(MessageShow msgShw) {
		
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Ingreso t) {
		
		if(t == null){
			return false;
		}else if(t.getMonto().getMonto() <= 0){		
			msgShw.showErrorMessage("Ingrese un monto valido", "Error");
			return false;
		} 
		
		return true;
	}
	
}
