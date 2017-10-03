package model;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.PersonaDao;

public class ClienteService {
	
	ClienteDao clienteDao;
	
	@Inject
	private ClienteService(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public Cliente getEmptyCliente() {
		
		Cliente toRet = new Cliente();
		Persona p = new Persona();
		p.setTipoCred(Persona.TipoCredencial.DNI);
		toRet.setHabilitado(true);
		
		toRet.setPersona(p);
		
		return toRet;
	}
	
	public void saveCliente(Cliente toSave) {
		clienteDao.save(toSave);
	}
	
}
