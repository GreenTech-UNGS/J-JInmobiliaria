package model;

import java.util.List;

import org.apache.commons.logging.LogConfigurationException;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import entities.Propiedad;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.PersonaDao;

public class ClienteService {
	
	ClienteDao clienteDao;
	PersonaDao personaDao;
	
	@Inject
	private ClienteService(ClienteDao clienteDao, PersonaDao personaDao) {
		this.clienteDao = clienteDao;
		this.personaDao = personaDao;
	}
	
	public Cliente getEmptyCliente() {
		
		Cliente toRet = new Cliente();
		Persona p = new Persona();
		p.setTipoCred(Persona.TipoCredencial.DNI);
		toRet.setHabilitado(true);
		
		toRet.setPersona(p);
		
		return toRet;
	}
	
	public Cliente getNewClienteFrom(Persona p) {
		Cliente toRet = new Cliente();
		toRet.setHabilitado(true);
		toRet.setPersona(p);
		
		return toRet;
	}
	
	public void saveCliente(Cliente toSave) throws LogicaNegocioException {
		
		if(existeClienteCon(toSave.getPersona()))
			throw new LogicaNegocioException("Ya existe un cliente con la misma credencial");
	
		clienteDao.save(toSave);
	}
	
	public List<Cliente> getAll(){
		return clienteDao.getAll();
	}

	public boolean existeClienteCon(Persona t) {
		
		return clienteDao.existeClienteCon(t);
		
	}
	
	public void actualizarCliente(Cliente clienteViejo){
		clienteDao.actualizeCliente(clienteViejo);
	}
}
