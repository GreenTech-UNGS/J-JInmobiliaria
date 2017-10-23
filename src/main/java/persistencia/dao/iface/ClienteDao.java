package persistencia.dao.iface;

import java.util.List;

import entities.Cliente;
import entities.Persona;
import filtros.ClienteFiltro;

public interface ClienteDao extends Dao<Cliente>{

	boolean existeClienteCon(Persona t);
	public List<Cliente> getAllByFiltro(ClienteFiltro filtro);
	public void actualizeCliente(Cliente toActualize);

}
