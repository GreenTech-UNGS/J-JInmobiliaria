package presentacion.validators;

import java.util.Objects;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona;
import entities.Persona.TipoCredencial;
import model.ClienteService;
import model.PersonaService;

@Singleton
public class PersonaValidator implements Validator<Persona>{

	PersonaBasicaValidator pbValidator;
	MessageShow msgShw;
	PersonaService personaService;
	ClienteService clienteService;
	
	@Inject
	private PersonaValidator(PersonaBasicaValidator pbValidator, 
			MessageShow msgShw, 
			PersonaService personaService,
			ClienteService clienteService) {
		
		this.pbValidator = pbValidator;
		this.msgShw = msgShw;
		this.personaService = personaService;
		this.clienteService = clienteService;
	}
	
	@Override
	public boolean isValid(Persona t) {
		
		if(t == null){
			return false;
		}
		if(pbValidator.isValid(t) == false) {
			return false;
		}
		else if(isCredentialValid(t) == false) {
			msgShw.showErrorMessage("El DNI/CUIT es invalido", "Error");
			return false;
		}
		else if(personaService.existePersonaConCredencial(t) && !personaService.existePersona(t)) {
			msgShw.showErrorMessage("El " + t.getTipoCred().toString() 
					+ " est� repetido. \n"
					+ "Si requiere ingresar a alguien existente utilize el bot�n buscar", "Error");
			return false;
		}
		
		return true;
	}
	
	private boolean isCredentialValid(Persona p) {
		if(p.getTipoCred().equals(TipoCredencial.DNI)) {
			return p.getCredencial().matches(Regex.DNI()) ||
					p.getCredencial().matches(Regex.OnlyNumbersDNI());
		}
		else if(p.getTipoCred().equals(TipoCredencial.CUIT)) {
			return isCuitValid(p);
		}
		return false;
	}
	
	private boolean isCuitValid(Persona p) {
		boolean checkSintaxis = p.getCredencial().matches(Regex.CUIT()) ||
								p.getCredencial().matches(Regex.onlyNumbersCUIT());
		
		String cuit = p.getCredencial();
		
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
