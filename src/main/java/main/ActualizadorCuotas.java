package main;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import persistencia.dao.iface.CuotaDao;
import misc.ActualizadorModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entities.CuotaAlquiler;
import entities.InteresPunitorioCuota;
import entities.Moneda;

public class ActualizadorCuotas {
	
	  public static void main( String[] args ){
		  
		Injector injector = Guice.createInjector(new ActualizadorModule());
		
		CuotaDao cuotaDao = injector.getInstance(CuotaDao.class);
		

		List<CuotaAlquiler> cuotas = cuotaDao.getAllOfThisMonth();
		
		int today = DateTime.now().getDayOfMonth();
		
		List<CuotaAlquiler> vencidas = cuotas.stream().
				filter(c -> today > c.getContrato().getDatoPunitorio().getDiasDePago()).
				collect(Collectors.toList());
				
		for(CuotaAlquiler cuota : vencidas){
			
			float montoCuota = cuota.getMonto().getMonto();
			Moneda moeda = cuota.getMonto().getMoneda();
			
			InteresPunitorioCuota interes = cuotaDao.getInteresOf(cuota);
			
			if(interes == null){
				
				interes = new InteresPunitorioCuota();
				
			}
			else{
				
			}
			
		}
		  
	  }
}
