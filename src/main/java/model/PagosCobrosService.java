package model;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
import entities.IngresoAlquiler;
import entities.InteresPunitorioCuota;
import entities.Precio;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.IngresoDao;

@Singleton
public class PagosCobrosService {

	CuotaService cuotaService;
	IngresoDao ingresoDao;
	
	@Inject
	private PagosCobrosService(CuotaService cuotaService,
			IngresoDao ingresoDao) {
		
		this.cuotaService = cuotaService;
		this.ingresoDao = ingresoDao;
	}
	
	
	public void generarCobroAlquiler(CuotaAlquiler cuota, DateTime fecha) {
		
		HistoriaEstadoCuota nuevo = new HistoriaEstadoCuota();
		nuevo.setFecha(fecha);
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
		ingreso.setDetalle("Pago de cuota al dia " + fecha.toDate().toString());
		ingreso.setFecha(fecha);
		ingreso.setMonto(p);
		
		ingresoDao.save(ingreso);
		cuotaService.saveCuota(cuota);
		
	}
	
}
