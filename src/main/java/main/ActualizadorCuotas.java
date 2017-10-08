package main;

import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;

import persistencia.dao.iface.CuotaDao;
import misc.ActualizadorModule;
import model.ContratoService;
import model.CuotaService;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.InteresPunitorioCuota;
import entities.Moneda;
import entities.Precio;

public class ActualizadorCuotas {
	
	static Injector injector;
	static CuotaDao cuotaDao;
	static CuotaService cuotaService;
	
	  public static void main( String[] args ){
		  
		injector = Guice.createInjector(new ActualizadorModule());
		
		cuotaDao = injector.getInstance(CuotaDao.class);
		cuotaService = injector.getInstance(CuotaService.class);

		actualizeCuotasVencidas();
		  
	  }

	private static void actualizeCuotasVencidas() {
		LocalDate today = DateTime.now().toLocalDate();
		List<CuotaAlquiler> vencidas = cuotaService.getVencidas();
				
		for(CuotaAlquiler cuota : vencidas){
			
			LocalDate diaPago = cuotaService.getDiaPago(cuota);
			
			double montoCuota = cuota.getMonto().getMonto();
			Moneda moneda = cuota.getMonto().getMoneda();
			
			boolean isAcumulativo = cuota.getContrato().getDatoPunitorio().isAcumulativo();
			float porcentaje = cuota.getContrato().getDatoPunitorio().getPorcentaje();
			
			int cantDias = new Period(diaPago,today).getDays();
			Precio p = new Precio(0, moneda);
			double m;

			InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
			
			if(interes == null){
				
				interes = new InteresPunitorioCuota();
				interes.setCuota(cuota);
				
			}
			else{
				p = interes.getMonto();
			}
			
			
			if(isAcumulativo) 
				m = montoCuota * Math.pow((1 + (porcentaje/100.0)), cantDias) - montoCuota ;
			else 
				m = montoCuota * (porcentaje/100.0) * cantDias;
			
			p.setMonto(m);
			interes.setMonto(p);
			interes.setFecha(DateTime.now());
			
			cuotaService.saveInteres(interes);
			
		}
		
	}

}
