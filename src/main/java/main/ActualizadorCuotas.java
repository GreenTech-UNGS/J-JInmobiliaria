package main;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.YearMonth;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoContrato;
import entities.EstadoCuota;
import entities.HistoriaEstadoContrato;
import entities.HistoriaEstadoCuota;
import entities.InteresPunitorioCuota;
import misc.ActualizadorModule;
import misc.ProdModule;
import model.ContratoService;
import model.CuotaService;
import model.LogicaNegocioException;
import persistencia.conexion.Conexion;

public class ActualizadorCuotas {
	
	static Injector injector;
	static CuotaService cuotaService;
	static ContratoService contratoService;
	
	  public static void main( String[] args ){
		  
    	DateTimeZone.setDefault(DateTimeZone.UTC);
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));  
		
		injector = Guice.createInjector(new ProdModule());
		
		cuotaService = injector.getInstance(CuotaService.class);
		contratoService = injector.getInstance(ContratoService.class);

		actualizeCuotasVencidas();
		actualizeContratos();
		
		Conexion c = injector.getInstance(Conexion.class);
		c.cerrar();
	  }

	private static void actualizeContratos() {
		
		List<ContratoAlquiler> contratos = contratoService.getContratosAlquiler();
		
		YearMonth today = YearMonth.now();
		
		for (ContratoAlquiler contratoAlquiler : contratos) {
			YearMonth desde = contratoAlquiler.getPrimerAnioMes();
			YearMonth hasta = contratoAlquiler.getPrimerAnioMes().plusMonths(contratoAlquiler.getCantMeses());
			
			if(!desde.isBefore(today) && contratoService.getEstadoOf(contratoAlquiler).equals(EstadoContrato.DEFINITIVO)) {
				HistoriaEstadoContrato estadoNuevo = new HistoriaEstadoContrato();
				estadoNuevo.setEstado(EstadoContrato.VIGENTE);
				estadoNuevo.setFecha(DateTime.now());
				
				contratoAlquiler.getEstados().add(estadoNuevo);
				
				try {
					contratoService.saveContratoAlquiler(contratoAlquiler);
				} catch (LogicaNegocioException e) {
				}
			}
			
			if(today.isAfter(hasta) && contratoService.getEstadoOf(contratoAlquiler).equals(EstadoContrato.VIGENTE)) {
				HistoriaEstadoContrato estadoNuevo = new HistoriaEstadoContrato();
				estadoNuevo.setEstado(EstadoContrato.FINALIZADO);
				estadoNuevo.setFecha(DateTime.now());
				
				contratoAlquiler.getEstados().add(estadoNuevo);
				
				try {
					contratoService.saveContratoAlquiler(contratoAlquiler);
				} catch (LogicaNegocioException e) {
				}
			}
			
		}
		
	}

	private static void actualizeCuotasVencidas() {
		DateTime today = DateTime.now();
		List<CuotaAlquiler> vencidas = cuotaService.getVencidas();
				
		for(CuotaAlquiler cuota : vencidas){
			
			InteresPunitorioCuota interes = cuotaService.getInteresCalculado(cuota, today);
			HistoriaEstadoCuota estadoVenciado = new HistoriaEstadoCuota();
			estadoVenciado.setEstado(EstadoCuota.ATRASADA);
			estadoVenciado.setFecha(DateTime.now());
			
			cuotaService.saveCuota(cuota);
			cuotaService.saveInteres(interes);
			
		}
		
	}

}
