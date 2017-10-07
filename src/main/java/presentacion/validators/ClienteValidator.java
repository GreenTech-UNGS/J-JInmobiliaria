package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import model.ClienteService;

@Singleton
public class ClienteValidator implements Validator<Cliente>{

	PersonaValidator pValidator;
	ClienteService clienteService;
	MessageShow msgShw;
	
	@Inject
	private ClienteValidator(PersonaValidator pValidator, MessageShow msgShw, ClienteService clienteService) {
		this.pValidator = pValidator;
		this.clienteService = clienteService;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Cliente t) {
		
		if(t == null){
			return false;
		} 
		
		if(pValidator.isValid(t.getPersona()) == false)
				return false;
		if(clienteService.existeClienteCon(t.getPersona())) {
			msgShw.showErrorMessage("El cliente ya está agregado", "Error");
			
			return false;			
		}
			
		
		return true;
		
		}
	
}
