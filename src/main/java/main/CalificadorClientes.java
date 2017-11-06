package main;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.YearMonth;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entities.CalificacionCliente;
import entities.Cliente;
import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoCuota;
import misc.ProdModule;
import model.CuotaService;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;

public class CalificadorClientes {

	private static Injector injector;
	private static int cantidadMinimaMeses = 6;
	
	public static void main(String[] args) {
		
		//TODO: cambiar
		injector = Guice.createInjector(new ProdModule());
		
		CuotaDao cuotaDao = injector.getInstance(CuotaDao.class);
		ClienteDao clienteDao = injector.getInstance(ClienteDao.class);
		CuotaService cuotaService = injector.getInstance(CuotaService.class);
		
		List<Cliente> clientes = clienteDao.getAll();
		
		for (Cliente cliente : clientes) {
			
			List<CuotaAlquiler> cuotas = cuotaDao.getAllCuotasOf(cliente);
			
			List<CuotaAlquiler> cuotasAnteriores = cuotas.stream()
					.filter(c -> !c.getAnioMes().isAfter(YearMonth.now()))
					.sorted((c1, c2) -> c2.getAnioMes().compareTo(c1.getAnioMes()))
					.collect(Collectors.toList());
			
			if(cuotasAnteriores.size() > cantidadMinimaMeses)
				cliente.setCalificacion(CalificacionCliente.C);
			else {
				int cantidadFaltas = 0;
				for(CuotaAlquiler cuota : cuotasAnteriores.subList(0, cantidadMinimaMeses))
					if(cuotaService.getEstadoOf(cuota).equals(EstadoCuota.ATRASADA))
						cantidadFaltas++;
				
				if(cantidadFaltas == 0)
					cliente.setCalificacion(CalificacionCliente.D);
				if(cantidadFaltas >= 4)
					cliente.setCalificacion(CalificacionCliente.A);
				if(cantidadFaltas < 4)
					cliente.setCalificacion(CalificacionCliente.C);
			}
			
		}
		
		
		

	}

}
