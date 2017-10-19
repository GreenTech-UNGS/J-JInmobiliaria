package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Egreso;
import entities.Ingreso;
import persistencia.dao.iface.EgresoDao;
import persistencia.dao.iface.IngresoDao;

@Singleton
public class MovimientoCajaService {

	IngresoDao ingresoDao;
	EgresoDao egresoDao;
	
	@Inject
	private MovimientoCajaService(	IngresoDao ingresoDao,
				EgresoDao egresoDao) {
		
		this.ingresoDao = ingresoDao;
		this.egresoDao = egresoDao;
	}
	
	public void saveEgreso(Egreso e){
		egresoDao.save(e);
	}
	
	public void saveIngreso(Ingreso i){
		ingresoDao.save(i);
	}
	
}
