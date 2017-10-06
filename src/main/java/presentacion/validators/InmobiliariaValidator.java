package presentacion.validators;

import java.util.Objects;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import entities.PersonaBasica;
import model.PersonaService;

@Singleton
public class InmobiliariaValidator implements Validator<Inmobiliaria>{

	PersonaBasicaValidator pbValidator;
	MessageShow msgShw;
	PersonaService personaService;
	
	@Inject
	private InmobiliariaValidator(PersonaBasicaValidator pbValidator, 
			MessageShow msgShw, 
			PersonaService personaService) {
		
		this.pbValidator = pbValidator;
		this.msgShw = msgShw;
		this.personaService = personaService;
	}
	
	@Override
	public boolean isValid(Inmobiliaria t) {
		
		boolean acumulado = true;
		for (PersonaBasica pb : t.getContactos()){
			acumulado &= pbValidator.isValid(pb);
		}
		if(acumulado == false) {
			return false;
		}
		
		else if(isCuitValid(t.getCUIT()) == false) {
			msgShw.showErrorMessage("El CUIT es invalido", "Error");
			return false;
		}
		
		else if(t.getEmail().matches(Regex.email()) == false) {
			msgShw.showErrorMessage("La direccion de mail es invalida", "Error");
			return false;
		}
		
		return true;
	}
	
	private boolean isCuitValid(String cuit) {
		boolean checkSintaxis = cuit.matches(Regex.CUIT()) ||
								cuit.matches(Regex.onlyNumbersCUIT());
				
	    cuit = cuit.replaceAll("[^\\d]", "");
	    if (cuit.length() != 11){
	        return false;
	    }
	    char[] cuitArray = cuit.toCharArray();
	    Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
	    Integer aux = 0;
	    for (int i=0; i<10; i++){
	        aux += Character.getNumericValue(cuitArray[i]) * serie[i];
	    }
	    aux = 11 - (aux % 11);
	    if (aux == 11){
	        aux = 0;
	    }
	    return Objects.equals(Character.getNumericValue(cuitArray[10]), aux) && checkSintaxis;
	}

}
