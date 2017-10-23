package main;

import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.YearMonth;

import persistencia.conexion.Conexion;
import persistencia.dao.iface.CuotaDao;
import misc.ActualizadorModule;
import model.ContratoService;
import model.CuotaService;
import model.LogicaNegocioException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoContrato;
import entities.EstadoCuota;
import entities.HistoriaEstadoContrato;
import entities.InteresPunitorioCuota;
import entities.Moneda;
import entities.Precio;

public class ActualizadorCuotas {
	
	static Injector injector;
	static CuotaService cuotaService;
	static ContratoService contratoService;
	
	  public static void main( String[] args ){
		  
		injector = Guice.createInjector(new ActualizadorModule());
		
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
