package model;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
import entities.IngresoAlquiler;
import entities.InteresPunitorioCuota;
import entities.PagoPropietario;
import entities.PagoPropietario.EstadoPago;
import entities.Precio;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.IngresoDao;
import persistencia.dao.iface.PropietarioDao;

@Singleton
public class PagosCobrosService {

	CuotaService cuotaService;
	IngresoDao ingresoDao;
	PropietarioDao propietarioDao;
	
	@Inject
	private PagosCobrosService(CuotaService cuotaService,
			IngresoDao ingresoDao,
			PropietarioDao propietarioDao) {
		
		this.cuotaService = cuotaService;
		this.ingresoDao = ingresoDao;
		this.propietarioDao = propietarioDao;
	}
	
	
	public void generarCobroAlquiler(CuotaAlquiler cuota, DateTime fecha) {
		
		HistoriaEstadoCuota nuevo = new HistoriaEstadoCuota();
		
		DateTime fechaNueva = fecha.withTime(LocalTime.now());
		
		nuevo.setFecha(fechaNueva);
		nuevo.setEstado(EstadoCuota.PAGA);
		
		cuota.getEstados().add(nuevo);
		
		IngresoAlquiler ingreso = new IngresoAlquiler();
		Precio p = new Precio(0, cuota.getContrato().getCuotaMensual().getMoneda());
		double monto = cuota.getMonto().getMonto();

		InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
		if(interes != null)
			monto += cuotaService.getInteresOf(cuota).getMonto().getMonto();
		
		double ingresoMonto = monto * (cuota.getContrato().getGastosAdmin() / 100.0);
		p.setMonto(ingresoMonto);
		
		ingreso.setCuota(cuota);
		ingreso.setDetalle("Pago de cuota al dia " + fechaNueva.toDate().toString());
		ingreso.setFecha(fechaNueva);
		ingreso.setMonto(p);
		
		ingresoDao.save(ingreso);
		cuotaService.saveCuota(cuota);
		
		generaPagopropietario(cuota);
		
	}
	
	public void generaPagopropietario(CuotaAlquiler cuota) {
		
		PagoPropietario nuevoPago = new PagoPropietario();
		double monto = cuota.getMonto().getMonto();
		InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
		
		if(interes != null)
			monto += interes.getMonto().getMonto();
		
		double montoParaPropietario = monto * ((100.0 - cuota.getContrato().getGastosAdmin())/100.0);
		
		Precio p = new Precio(montoParaPropietario, cuota.getMonto().getMoneda());
		
		nuevoPago.setCuota(cuota);
		nuevoPago.setEstado(EstadoPago.PENDIENTE);
		nuevoPago.setMonto(p);
		nuevoPago.setPropietario(cuota.getContrato().getPropiedad().getPropietario());
		
		propietarioDao.generaPago(nuevoPago);
		
	}
	
	public List<PagoPropietario> getAllPagosPropsPendientes(){
		
		return propietarioDao.getAllPagosPropsPendientes();
		
	}
	
}
