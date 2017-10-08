package persistencia.dao.iface;

import entities.Cliente;
import entities.Persona;

public interface ClienteDao extends Dao<Cliente>{

	boolean existeClienteCon(Persona t);
	
	public void actualizeCliente(Cliente toActualize);

	
	
}
