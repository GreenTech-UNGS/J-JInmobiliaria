package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.MovimientoDeCajaDTO;
import entities.*;
import org.joda.time.DateTime;
import persistencia.dao.iface.EgresoDao;
import persistencia.dao.iface.IngresoDao;

import java.util.ArrayList;
import java.util.List;

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

	public List<MovimientoDeCajaDTO> getReporteMovimientoDeCaja(){
		List<MovimientoDeCajaDTO> ret = new ArrayList<MovimientoDeCajaDTO>();
		List<Ingreso> ingresos = ingresoDao.getAll();
		List<Egreso> engresos = egresoDao.getAll();
		for (Ingreso ingreso : ingresos
			 ) {
			MovimientoDeCajaDTO mov = new MovimientoDeCajaDTO();
			mov.setTipo(MovimientoDeCajaDTO.Tipo.Ingreso);
			mov.setMonto(ingreso.getMonto().getMonto());
			mov.setMonedaStr(ingreso.getMonto().getMoneda().toString());
			//mov.setMontoStr(ingreso.getMonto().toString());
			mov.setDetalleStr(ingreso.getDetalle());
			mov.setFecha(ingreso.getFecha().toString("dd-MM-yyyy"));
			ret.add(mov);
		}
        for (Egreso egreso : engresos
                ) {
            MovimientoDeCajaDTO mov = new MovimientoDeCajaDTO();
            mov.setTipo(MovimientoDeCajaDTO.Tipo.Egreso);
            mov.setMonto(egreso.getMonto().getMonto()*-1);
            mov.setMonedaStr(egreso.getMonto().getMoneda().toString());
            //mov.setMontoStr(egreso.getMonto().getMonto());
            mov.setDetalleStr(egreso.getDetalle());
            mov.setFecha(egreso.getFecha().toString("dd-MM-yyyy"));
            ret.add(mov);
        }

//        ret.sort((m1, m2) -> DateTime.parse(m1.getFecha()).compareTo(DateTime.parse(m2.getFecha())));
		//TODO: También tendría que estar ordenado por Fecha
		ret.sort((m1, m2) -> m1.getTipo().compareTo(m2.getTipo()));
		return ret;
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

	public List<MovimientoCaja> getAll() {
		List<Ingreso> ingresos = ingresoDao.getAll();
		List<Egreso> egresos = egresoDao.getAll();
		
		List<MovimientoCaja> toRet = new ArrayList<>(ingresos);
		toRet.addAll(egresos);
		toRet.sort((m1, m2) -> m2.getFecha().compareTo(m1.getFecha()));
		
		return toRet;
	}
	
}
