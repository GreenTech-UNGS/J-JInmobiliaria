package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.YearMonth;

import com.google.inject.Inject;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
import entities.InteresPunitorioCuota;
import filtros.CuotaFiltro;
import persistencia.dao.iface.CuotaDao;

public class CuotaService {
	
	CuotaDao cuotaDao;
	
	@Inject
	private CuotaService(CuotaDao cuotaDao) {
		this.cuotaDao = cuotaDao;
	}
	
	public CuotaAlquiler getEmptyCliente() {
		
		CuotaAlquiler toRet = new CuotaAlquiler();
		
		return toRet;
	}
	
	public void saveCuota(CuotaAlquiler toSave) {
		
		cuotaDao.save(toSave);
	}
	
	public List<CuotaAlquiler> getAll(){
		return cuotaDao.getAll();
	}
	
	public EstadoCuota getEstadoOf(CuotaAlquiler c) {
		
		c.getEstados().sort((e1, e2) -> e2.getFecha().compareTo(e1.getFecha()));
		
		return c.getEstados().get(0).getEstado();
		
	}
	
	public List<CuotaAlquiler> getAllByFiltro(CuotaFiltro filtro){
		List<CuotaAlquiler> todos = getAll();
		
		return todos.stream().filter(c -> {
			return !c.getAnioMes().isAfter(filtro.getHasta()) && 
					!c.getAnioMes().isBefore(filtro.getDesde());  
		
		}).collect(Collectors.toList());
		
	}

	public List<CuotaAlquiler> getCuotasOf(YearMonth anioMes, EstadoCuota... estados){
		List<CuotaAlquiler> allCuotas = cuotaDao.getAllOf(anioMes);
		
		List<EstadoCuota> estadosRequeridos = Arrays.asList(estados);
		
		List<CuotaAlquiler> toRet = allCuotas.stream().
				filter(c -> estadosRequeridos.contains(getEstadoOf(c))).
				collect(Collectors.toList());
		
		return toRet;
	}

	public List<CuotaAlquiler> getVencidas() {
		List<CuotaAlquiler> cuotas = cuotaDao.getAllOfThisMonth();
		
		LocalDate today = DateTime.now().toLocalDate();
		return cuotas.stream().
				filter(c ->{
						
				LocalDate diaPago = new LocalDate(c.getAnioMes().getYear(),
							c.getAnioMes().getMonthOfYear(),
							c.getContrato().getDatoPunitorio().getDiasDePago());
					return today.isAfter(diaPago);
				} ).
				filter(c -> getEstadoOf(c).equals(EstadoCuota.PENDIENTE)).
				collect(Collectors.toList());
	}

	public LocalDate getDiaPago(CuotaAlquiler cuota) {
		
		return new LocalDate(cuota.getAnioMes().getYear(),
				cuota.getAnioMes().getMonthOfYear(),
				cuota.getContrato().getDatoPunitorio().getDiasDePago());
	}
	
	public void cancelaCuotas(List<CuotaAlquiler> cuotas) {
		for(CuotaAlquiler c: cuotas) {
			HistoriaEstadoCuota nuevo = new HistoriaEstadoCuota();
			nuevo.setEstado(EstadoCuota.CANCELADA);
			nuevo.setFecha(DateTime.now());
			
			c.getEstados().add(nuevo);
			
			cuotaDao.save(c);
		}
	}
	
	public List<CuotaAlquiler> getcuotasOf(ContratoAlquiler c){
		return cuotaDao.getCuotasOf(c);
	}

	public InteresPunitorioCuota getInteresOf(CuotaAlquiler cuota) {
		// TODO Auto-generated method stub
		return cuotaDao.getInteresOf(cuota);
	}

	public void saveInteres(InteresPunitorioCuota interes) {
		cuotaDao.saveInteres(interes);
		
	}

	public List<CuotaAlquiler> getAllOfNow() {
		// TODO Auto-generated method stub
		return cuotaDao.getAllOf(YearMonth.now());
	}


}
