package model;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Egreso;
import entities.Ingreso;
import entities.Moneda;
import entities.Precio;
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
	
	public Ingreso getNewIngreso() {
		Ingreso toRet = new Ingreso();
		Precio p = new Precio(0, Moneda.PESOS);
		
		toRet.setMonto(p);
		toRet.setDetalle("");
		toRet.setFecha(DateTime.now());
		
		return toRet;
	}

	public Egreso getNewEgreso() {
		Egreso toRet = new Egreso();
		Precio p = new Precio(0, Moneda.PESOS);
		
		toRet.setMonto(p);
		toRet.setDetalle("");
		toRet.setFecha(DateTime.now());
		
		return toRet;
	}
	
}
