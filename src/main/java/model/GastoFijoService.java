package model;

import java.util.List;

import com.google.inject.Inject;

import entities.GastoFijo;
import persistencia.dao.iface.GastoFijoDao;

public class GastoFijoService {
	
	GastoFijoDao gastoFijoDao;
	
	@Inject
	private GastoFijoService(GastoFijoDao gastoFijoDao) {
		this.gastoFijoDao = gastoFijoDao;
	}
	
	public GastoFijo getEmptyGastoFijo() {
		
		GastoFijo toRet = new GastoFijo();		
		return toRet;
	}
		
	public void saveGastoFijo(GastoFijo toSave) throws LogicaNegocioException {

		gastoFijoDao.save(toSave);
	}

	public List<GastoFijo> getAll(){
		return gastoFijoDao.getAll();
	}
	
}
