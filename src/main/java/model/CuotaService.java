package model;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import entities.ContratoAlquiler;
import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
import entities.InteresPunitorioCuota;
import entities.Moneda;
import entities.Precio;
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
		
		return cuotas.stream().
				filter(c -> isVencida(c)).
				filter(c -> getEstadoOf(c).equals(EstadoCuota.PENDIENTE)).
				collect(Collectors.toList());
	}
	
	public boolean isVencida(CuotaAlquiler c) {
		LocalDate today = DateTime.now().toLocalDate();

		LocalDate diaPago = new LocalDate(c.getAnioMes().getYear(),
				c.getAnioMes().getMonthOfYear(),
				c.getContrato().getDatoPunitorio().getDiasDePago());
		return today.isAfter(diaPago);
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
	
	public int getNumeroCuota(CuotaAlquiler c){
		
		YearMonth inicio = c.getContrato().getPrimerAnioMes();
		YearMonth mes = c.getAnioMes();
		
		Period p = new Period(inicio, mes);
		
		return p.getMonths() + 1;
		
	}
	
	public int getCantidadCuotasOf(ContratoAlquiler c){
		return cuotaDao.getCantidadCuotasOf(c);
	}

	public InteresPunitorioCuota getInteresOf(CuotaAlquiler cuota) {
		// TODO Auto-generated method stub
		return cuotaDao.getInteresOf(cuota);
	}
	
	public InteresPunitorioCuota getInteresCalculado(CuotaAlquiler c, DateTime fecha) {
		
		LocalDate diaPago = getDiaPago(c);
		int cantDias = Days.daysBetween(diaPago, fecha.toLocalDate()).getDays();
		
		if(cantDias < 0)
			return null;
		
		if(getEstadoOf(c).equals(EstadoCuota.PENDIENTE)) {
			
			double montoCuota = c.getMonto().getMonto();
			Moneda moneda = c.getMonto().getMoneda();
			boolean isAcumulativo = c.getContrato().getDatoPunitorio().isAcumulativo();
			float porcentaje = c.getContrato().getDatoPunitorio().getPorcentaje();
			
			Precio p = new Precio(0, moneda);
			double m;
			
			InteresPunitorioCuota interes = getInteresOf(c);
			
			if(interes == null){
				
				interes = new InteresPunitorioCuota();
				interes.setCuota(c);
				
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
			
			return interes;
		}
		
		return null;
	}
	

	public void saveInteres(InteresPunitorioCuota interes) {
		cuotaDao.saveInteres(interes);
		
	}

	public List<CuotaAlquiler> getAllOfNow() {
		// TODO Auto-generated method stub
		return cuotaDao.getAllOf(YearMonth.now());
	}


}
