package model;

import java.util.List;

import com.google.inject.Inject;

import entities.CuotaAlquiler;
import persistencia.dao.iface.CuotaDao;

public class CuotaService {
	
	CuotaDao cuotaDao;
	
	@Inject
	private CuotaService(CuotaDao cuotaDao) {
		this.cuotaDao = cuotaDao;
	}
	
	public CuotaAlquiler getEmptyCliente() {
		
		CuotaAlquiler toRet = new CuotaAlquiler();
		
		return toRet;
	}
	
	public void saveCuota(CuotaAlquiler toSave) {
		
		cuotaDao.save(toSave);
	}
	
	public List<CuotaAlquiler> getAll(){
		return cuotaDao.getAll();
	}

}
