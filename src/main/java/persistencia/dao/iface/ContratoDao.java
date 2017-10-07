package persistencia.dao.iface;

import entities.Contrato;

public interface ContratoDao extends Dao<Contrato>{
	
	public boolean existeContratoConIdentificador(String identificador);

}
