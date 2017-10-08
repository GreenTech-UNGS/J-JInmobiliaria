package model;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Cliente;
import entities.Contrato;
import entities.ContratoAlquiler;
import entities.ContratoVenta;
import entities.CuotaAlquiler;
import entities.DatosActualizacionContrato;
import entities.DatosPunitorioContrato;
import entities.EstadoCuota;
import entities.EstadoProp;
import entities.HistoriaEstadoCuota;
import entities.HistoriaEstadoProp;
import entities.Moneda;
import entities.Persona;
import entities.Precio;
import entities.Propiedad;
import entities.TipoContratoAlquiler;
import entities.TipoOfrecimiento;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class ContratoService {

	ContratoDao contratoDao;
	PropiedadDao propiedadDao;
	CuotaDao cuotaDao;
	
	@Inject
	private ContratoService(ContratoDao contratoDao,
			PropiedadDao propiedadDao,
			CuotaDao cuotaDao) {
		
		this.contratoDao = contratoDao;
		this.propiedadDao = propiedadDao;
		this.cuotaDao = cuotaDao;
		
	}
	
	public boolean existeContratoConIdentificador(Contrato t) {
		
		return contratoDao.existeContratoConIdentificador(t.getIdentificador());		
	}
	
	public void saveContratoAlquiler(ContratoAlquiler c) {

		contratoDao.save(c);
		
		HistoriaEstadoProp estado = new HistoriaEstadoProp();
		estado.setEstado(EstadoProp.ALQUILADA);
		estado.setFecha(DateTime.now());
		
		Propiedad propiedad = c.getPropiedad();
		propiedad.getEstados().add(estado);
		
		creaCuotas(c);
		
		propiedadDao.save(propiedad);
		//TODO: crear pagos y eso
	}
	
	private void creaCuotas(ContratoAlquiler c) {
		
		int cantCuotas = c.getCantMeses();
		float montoInicial = c.getCuotaMensual().getMonto();
		float monto = c.getCuotaMensual().getMonto();
		Moneda m = c.getCuotaMensual().getMoneda();
		YearMonth nextMonth = YearMonth.now().plusMonths(1);
		
		for(int i = 1; i <= cantCuotas; i++) {
			
			CuotaAlquiler nuevaCuota = new CuotaAlquiler();
			nuevaCuota.setContrato(c);
			
			Precio p = new Precio(monto, m);
			nuevaCuota.setMonto(p);
			
			HistoriaEstadoCuota estado = new HistoriaEstadoCuota();
			estado.setEstado(EstadoCuota.PENDIENTE);
			estado.setFecha(DateTime.now());
			nuevaCuota.getEstados().add(estado);
			
			nuevaCuota.setAnioMes(nextMonth);
			nextMonth = nextMonth.plusMonths(1);
			
			if(i % c.getDatoActualizacion().getActualizacionMeses() == 0) {
				if(c.getDatoActualizacion().isAcumulativo())
					monto += monto * (c.getDatoActualizacion().getPorcentaje()/100);
				else
					monto += montoInicial * (c.getDatoActualizacion().getPorcentaje()/100);
			}
			
			cuotaDao.save(nuevaCuota);
		}	
	}
	
	public ContratoAlquiler getNewContratoAlquiler() {
		
		ContratoAlquiler toRet;
		toRet = new ContratoAlquiler();
		
		Precio p = new Precio(0, Moneda.PESOS);
		AvisoNotificacion intimacion = new AvisoNotificacion();
		AvisoNotificacion vencer = new AvisoNotificacion();
		DatosPunitorioContrato punitorio = new DatosPunitorioContrato();
		DatosActualizacionContrato actualizacion = new DatosActualizacionContrato();
		
		toRet.setCuotaMensual(p);
		toRet.setAvisoIntimacion(intimacion);
		toRet.setAvisoProxVencer(vencer);
		toRet.setDatoPunitorio(punitorio);
		toRet.setDatoActualizacion(actualizacion);
		toRet.setTipoContratoAlquiler(TipoContratoAlquiler.VIVIENDA);
		
		return toRet;
	}
	
	public void SaveContratoVenta(ContratoVenta c){
			
			contratoDao.save(c);
			
			HistoriaEstadoProp estado = new HistoriaEstadoProp();
			estado.setEstado(EstadoProp.VENDIDA);
			estado.setFecha(DateTime.now());
			
			Propiedad propiedad = c.getPropiedad();
			propiedad.getEstados().add(estado);
			
			propiedadDao.save(propiedad);
		}
	
	public ContratoVenta getNewContratoVenta(){
		
		ContratoVenta toRet = new ContratoVenta();

		return toRet;
	}
	
	public List<Contrato> getAll(){
		return contratoDao.getAll();
		
		//esto va a devolver todos los contratos, hay que cambiarlo
	}
	public List<Contrato> getContratosVenta(){
		
		List<Contrato> allContratos = getAll();

		List<Contrato> toRet = allContratos.stream().filter(p -> p.getClass().equals(ContratoVenta.class)).collect(Collectors.toList());
		System.out.println(toRet);
		return toRet;
		
	}
	
	public List<Contrato> getContratosAlquiler(){
		
		List<Contrato> allContratos = getAll();
		List<Contrato> toRet = allContratos.stream().filter(p -> p.getClass().equals(ContratoAlquiler.class)).collect(Collectors.toList());
		return toRet;
	}
	
}
