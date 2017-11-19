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

	@Inject private OfrecimientoService ofrecimientoService;
	
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
		ret.sort((m1, m2) -> {
			String m1Str = m1.getTipo().toString() + m1.getFecha().toString();
			String m2Str = m2.getTipo().toString() + m2.getFecha().toString();
			return m2Str.compareTo(m1Str);
		});
		//Collections.reverse(ret);
		return ret;
	}
	
	public void saveEgreso(Egreso e) throws LogicaNegocioException{
		
		if(e.getFecha().isBeforeNow())
			throw new LogicaNegocioException("La fecha es posterior a hoy");
		
		egresoDao.save(e);
	}
	
	public void saveIngreso(Ingreso i) throws LogicaNegocioException{
		
		if(i.getFecha().isBeforeNow())
			throw new LogicaNegocioException("La fecha es posterior a hoy");
		
		ingresoDao.save(i);
	}
	
	
	public void creaIngresos(ContratoAlquiler c) {
		
		OfrecimientoAlquiler ofrecimientoTrucho = new OfrecimientoAlquiler();
		ofrecimientoTrucho.setAcumulativo(c.getDatoActualizacion().isAcumulativo());
		ofrecimientoTrucho.setCantidadMeses(c.getCantMeses());
		ofrecimientoTrucho.setHabilitada(true);
		ofrecimientoTrucho.setIntervaloActualizacion(c.getDatoActualizacion().getActualizacionMeses());
		ofrecimientoTrucho.setOtrosGastos(c.getPropiedad().getOfrecimientoAlquiler().getOtrosGastos());
		ofrecimientoTrucho.setPorcentajeSellado(c.getPropiedad().getOfrecimientoAlquiler().getPorcentajeSellado());
		ofrecimientoTrucho.setPrecio(c.getCuotaMensual());
		ofrecimientoTrucho.setProcentajeActualizacion(c.getDatoActualizacion().getPorcentaje());
		
		Precio valor = null;
		try {
			valor = ofrecimientoService.getPrecioParaEntrar(ofrecimientoTrucho);
		} catch (LogicaNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ingreso valorIngreso = new Ingreso();
		valorIngreso.setFecha(DateTime.now());
		valorIngreso.setDetalle("Pago del monto para entrar del contrato " + c.getIdentificador());
		valorIngreso.setMonto(valor);
		ingresoDao.save(valorIngreso);
		
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
