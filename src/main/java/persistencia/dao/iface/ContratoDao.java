package persistencia.dao.iface;

import java.util.List;

import entities.Contrato;
import entities.ContratoAlquiler;
import entities.ContratoVenta;

public interface ContratoDao extends Dao<Contrato>{
	
	public boolean existeContratoConIdentificador(String identificador);
	public List<ContratoAlquiler> getAllAlquiler();
	public List<ContratoVenta> getAllVenta();
}
