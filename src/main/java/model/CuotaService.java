package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.YearMonth;

import com.google.inject.Inject;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
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
		
		c.getEstados().sort((e1, e2) -> e1.getFecha().compareTo(e2.getFecha()));
		
		return c.getEstados().get(0).getEstado();
		
	}

	public List<CuotaAlquiler> getCuotasOf(YearMonth anioMes, EstadoCuota... estados){
		List<CuotaAlquiler> allCuotas = cuotaDao.getAllOf(anioMes);
		
		List<EstadoCuota> estadosRequeridos = Arrays.asList(estados);
		
		List<CuotaAlquiler> toRet = allCuotas.stream().
				filter(c -> estadosRequeridos.contains(getEstadoOf(c))).
				collect(Collectors.toList());
		
		return toRet;
	}
}
