package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.MovimientoDeCajaDTO;
import entities.*;

import org.hamcrest.core.Is;
import org.joda.time.DateTime;
import persistencia.dao.iface.EgresoDao;
import persistencia.dao.iface.IngresoDao;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MovimientoCajaService {

	@Inject private OfrecimientoService ofrecimientoService;
	@Inject private PagosCobrosService pagosService;
	@Inject CuotaService cuotaService;
	
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

		//Aca se tendría que tomar los egresos
		// en caso de que sea un mes proyectado tiene que traer los datos de
		// los alquileres que se cobrarán ese mes y los gastos fijos


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
		
		if(!e.getFecha().isBeforeNow())
			throw new LogicaNegocioException("La fecha es posterior a hoy");
		
		egresoDao.save(e);
	}
	
	public void saveIngreso(Ingreso i) throws LogicaNegocioException{
		
		if(!i.getFecha().isBeforeNow())
			throw new LogicaNegocioException("La fecha es posterior a hoy");
		
		ingresoDao.save(i);
	}
	
	
	public void creaIngresos(ContratoAlquiler c) {
		
		creaComision(c);
		
		CuotaAlquiler primera = cuotaService.getcuotasOf(c).get(0);
		pagosService.generarCobroAlquiler(primera, DateTime.now());
		
	}

	public void creaComision(ContratoAlquiler c) {
		OfrecimientoAlquiler ofrecimientoTrucho = new OfrecimientoAlquiler();
		ofrecimientoTrucho.setAcumulativo(c.getDatoActualizacion().isAcumulativo());
		ofrecimientoTrucho.setCantidadMeses(c.getCantMeses());
		ofrecimientoTrucho.setHabilitada(true);
		ofrecimientoTrucho.setIntervaloActualizacion(c.getDatoActualizacion().getActualizacionMeses());
		ofrecimientoTrucho.setOtrosGastos(c.getPropiedad().getOfrecimientoAlquiler().getOtrosGastos());
		ofrecimientoTrucho.setPorcentajeSellado(c.getPropiedad().getOfrecimientoAlquiler().getPorcentajeSellado());
		ofrecimientoTrucho.setPrecio(c.getCuotaMensual());
		ofrecimientoTrucho.setProcentajeActualizacion(c.getDatoActualizacion().getPorcentaje());
		
		Precio comision = ofrecimientoService.getComisionOf(ofrecimientoTrucho);
		
		Ingreso valorIngreso = new Ingreso();
		valorIngreso.setFecha(DateTime.now());
		valorIngreso.setDetalle("Comision del contrato " + c.getIdentificador());
		valorIngreso.setMonto(comision);
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

	public void generaMovimientos(ContratoVenta c) {
		
		Moneda m = c.getMonto().getMoneda();
		double monto = c.getMonto().getMonto();
		
		double montoComprador = monto * (c.getComisionComprador() / 100);
		double montoVendedor = monto * (c.getComisionVendedor() / 100);
		
		Precio comprador = new Precio(montoComprador, m);
		Precio vendedor = new Precio(montoVendedor, m);
		
		Ingreso iComprador = new Ingreso();
		Ingreso iVendedor = new Ingreso();
		
		iComprador.setDetalle("Comision del comprador del contrato " + c.getIdentificador());
		iComprador.setFecha(DateTime.now());
		iComprador.setMonto(comprador);
		
		iVendedor.setDetalle("Comision del vendedor del contrato " + c.getIdentificador());
		iVendedor.setFecha(DateTime.now());
		iVendedor.setMonto(vendedor);
		
		ingresoDao.save(iVendedor);
		ingresoDao.save(iComprador);
		
	}
	
}
