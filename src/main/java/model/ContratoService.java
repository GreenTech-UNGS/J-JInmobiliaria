package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.Contrato;
import entities.ContratoAlquiler;
import entities.ContratoVenta;
import entities.CuotaAlquiler;
import entities.DatosActualizacionContrato;
import entities.DatosPunitorioContrato;
import entities.EstadoContrato;
import entities.EstadoCuota;
import entities.EstadoProp;
import entities.HistoriaEstadoContrato;
import entities.HistoriaEstadoCuota;
import entities.HistoriaEstadoProp;
import entities.Ingreso;
import entities.InteresPunitorioCuota;
import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.Precio;
import entities.Propiedad;
import entities.Reserva;
import entities.TipoContratoAlquiler;
import filtros.ContratoAlquilerFiltro;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class ContratoService {

	ReservaService reservaService;
	@Inject CuotaService cuotaService;
	@Inject private MovimientoCajaService cajaService;
	@Inject private PropiedadService propeidadService;
	@Inject private PropietarioService propietarioService;
	
	ContratoDao contratoDao;
	PropiedadDao propiedadDao;
	CuotaDao cuotaDao;
	
	@Inject
	private ContratoService(ContratoDao contratoDao,
			PropiedadDao propiedadDao,
			CuotaDao cuotaDao,
			ReservaService reservaService) {
		
		this.contratoDao = contratoDao;
		this.propiedadDao = propiedadDao;
		this.cuotaDao = cuotaDao;
		this.reservaService = reservaService;
		
	}
	
	public boolean existeContratoConIdentificador(Contrato t) {
		
		return contratoDao.existeContratoConIdentificador(t.getIdentificador());		
	}
	
	public void saveContratoAlquiler(ContratoAlquiler c) throws LogicaNegocioException{

		if(!isPropiedadReservadaCorrectamente(c))
			throw new LogicaNegocioException("La propiedad esta reservada. El cliente debe ser el reservador");
			
		contratoDao.save(c);
		
		HistoriaEstadoProp estado = new HistoriaEstadoProp();
		estado.setEstado(EstadoProp.ALQUILADA);
		estado.setFecha(DateTime.now());
		
		Propiedad propiedad = c.getPropiedad();
		propiedad.getEstados().add(estado);
		propiedad.getOfrecimientoAlquiler().setHabilitada(false);
		
		creaCuotas(c);
		cajaService.creaIngresos(c);
		
		propiedadDao.save(propiedad);
	}
	
	public void saveContratoAlquilerBorrador(ContratoAlquiler c) throws LogicaNegocioException{
		
		if(!isPropiedadReservadaCorrectamente(c))
			throw new LogicaNegocioException("La propiedad esta reservada. El cliente debe ser el reservador");
		
		HistoriaEstadoContrato nuevo = new HistoriaEstadoContrato();
		nuevo.setEstado(EstadoContrato.BORRADOR);
		nuevo.setFecha(DateTime.now());
		c.getEstados().add(nuevo);
		
		contratoDao.save(c);
	}
	
	private boolean isPropiedadReservadaCorrectamente(ContratoAlquiler c){
		Reserva r = reservaService.getReservaOf(c.getPropiedad());
		if( r != null) {
			if(r.getReservador().getID() != c.getCliente().getPersona().getID()) {
				return false;
			}
		}
		return true;
	}
		
	private void creaCuotas(ContratoAlquiler c) {
		
		int cantCuotas = c.getCantMeses();
		double montoInicial = c.getCuotaMensual().getMonto();
		double monto = c.getCuotaMensual().getMonto();
		Moneda m = c.getCuotaMensual().getMoneda();
		YearMonth nextMonth = c.getPrimerAnioMes();
		
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
			
			InteresPunitorioCuota interes = new InteresPunitorioCuota();
			Precio p2 = new Precio(0, m);
			interes.setCuota(nuevaCuota);
			interes.setFecha(DateTime.now());
			interes.setMonto(p2);
			
			cuotaDao.save(nuevaCuota);
			cuotaDao.saveInteres(interes);
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
		
		HistoriaEstadoContrato nuevo = new HistoriaEstadoContrato();
		nuevo.setEstado(EstadoContrato.DEFINITIVO);
		nuevo.setFecha(DateTime.now());
		
		toRet.getEstados().add(nuevo);
		
		toRet.setInicio(DateTime.now().plusMonths(1));
		
		return toRet;
	}
	
	public void saveContratoVenta(ContratoVenta c) throws LogicaNegocioException{
			
		Reserva r = reservaService.getReservaOf(c.getPropiedad());
		
		if( r != null) {
			if(r.getReservador().getID() != c.getCliente().getPersona().getID()) {
				throw new LogicaNegocioException("La propiedad esta reservada. El cliente debe ser el reservador");	
			}	
		}
		
		
		HistoriaEstadoProp estado = new HistoriaEstadoProp();
		estado.setEstado(EstadoProp.VENDIDA);
		estado.setFecha(DateTime.now());
		
		Propiedad propiedad = c.getPropiedad();
		propiedad.getEstados().add(estado);
		
		propiedad.setPropietario(propietarioService.desdePersona(c.getCliente().getPersona()));
		
		propiedad.getOfrecimientoVenta().setHabilitada(false);
		
		cajaService.generaMovimientos(c);
		
		contratoDao.save(c);
		propiedadDao.save(propiedad);
	}
	
	public ContratoVenta getNewContratoVenta(){
		
		ContratoVenta toRet = new ContratoVenta();
		Precio p = new Precio(0, Moneda.PESOS);
		
		HistoriaEstadoContrato nuevo = new HistoriaEstadoContrato();
		nuevo.setEstado(EstadoContrato.DEFINITIVO);
		nuevo.setFecha(DateTime.now());
		
		toRet.getEstados().add(nuevo);
		toRet.setMonto(p);

		return toRet;
	}
	
	public List<Contrato> getAll(){
		return contratoDao.getAll();
	}
	
	public EstadoContrato getEstadoOf(Contrato c) {
		
		List<HistoriaEstadoContrato> estados = c.getEstados();
		
		estados.sort((e1, e2) -> e2.getFecha().compareTo(e1.getFecha()));
		
		
		return estados.get(0).getEstado();
		
	}
	
	public List<ContratoVenta> getContratosVenta(){
		
		return contratoDao.getAllVenta();
		
	}
	
	public List<ContratoAlquiler> getContratosAlquiler(){
		
		return contratoDao.getAllAlquiler();
	}

	public ContratoAlquiler getActualizacionOf(ContratoAlquiler c) {
		ContratoAlquiler toRet = new ContratoAlquiler();
		
		Precio p = new Precio(c.getCuotaMensual().getMonto(), c.getCuotaMensual().getMoneda());
		AvisoNotificacion intimacion = new AvisoNotificacion();
		intimacion.setHabilitado(c.getAvisoIntimacion().isHabilitado());
		intimacion.setPeriodo(c.getAvisoIntimacion().getPeriodo());
		
		AvisoNotificacion vencer = new AvisoNotificacion();
		vencer.setHabilitado(c.getAvisoIntimacion().isHabilitado());
		vencer.setPeriodo(c.getAvisoIntimacion().getPeriodo());
		
		DatosPunitorioContrato punitorio = new DatosPunitorioContrato();
		punitorio.setAcumulativo(c.getDatoPunitorio().isAcumulativo());
		punitorio.setDiasDePago(c.getDatoPunitorio().getDiasDePago());
		punitorio.setPorcentaje(c.getDatoPunitorio().getPorcentaje());
		
		DatosActualizacionContrato actualizacion = new DatosActualizacionContrato();
		actualizacion.setActualizacionMeses(c.getDatoActualizacion().getActualizacionMeses());
		actualizacion.setAcumulativo(c.getDatoActualizacion().isAcumulativo());
		actualizacion.setPorcentaje(c.getDatoActualizacion().getPorcentaje());
		
		toRet.setCantMeses(c.getCantMeses());
		toRet.setCliente(c.getCliente());
		toRet.setGarantia(c.getGarantia());
		toRet.setGastosAdmin(c.getGastosAdmin());
		toRet.setPropiedad(c.getPropiedad());
		
		toRet.setCuotaMensual(p);
		toRet.setAvisoIntimacion(intimacion);
		toRet.setAvisoProxVencer(vencer);
		toRet.setDatoPunitorio(punitorio);
		toRet.setDatoActualizacion(actualizacion);
		toRet.setTipoContratoAlquiler(c.getTipoContratoAlquiler());
		
		HistoriaEstadoContrato nuevo = new HistoriaEstadoContrato();
		nuevo.setEstado(EstadoContrato.DEFINITIVO);
		nuevo.setFecha(DateTime.now());
		
		toRet.getEstados().add(nuevo);
		
		DateTime inicio = new DateTime(c.getPrimerAnioMes().getYear(),
				c.getPrimerAnioMes().getMonthOfYear(),
				1, 12, 0, 0, 0).plusMonths(1);

		toRet.setInicio(inicio);

		return toRet;
		
	}
	
	public void cancelarContrato (Contrato c) throws LogicaNegocioException{
		
		if (getEstadoOf(c) != EstadoContrato.DEFINITIVO)
			throw new LogicaNegocioException("Solo se pueden cancelar los contratos definitivos");
			 
		
		HistoriaEstadoContrato nuevoEstado = new HistoriaEstadoContrato();
		nuevoEstado.setEstado(EstadoContrato.CANCELADO);
		nuevoEstado.setFecha(DateTime.now());
		
		if(c instanceof ContratoAlquiler) {
			List<CuotaAlquiler> cuotas = cuotaService.getcuotasOf((ContratoAlquiler)c);
			List<CuotaAlquiler> aCancelar = new ArrayList<>();
			for(CuotaAlquiler cuota : cuotas) {
				if(cuotaService.getEstadoOf(cuota).equals(EstadoCuota.PENDIENTE))
					aCancelar.add(cuota);
			}
			
			cuotaService.cancelaCuotas(aCancelar);
		}
		
		c.getEstados().add(nuevoEstado);
		
		propeidadService.setDisponible(c.getPropiedad());
		
		contratoDao.save(c);
		
	}
	
	public List<ContratoAlquiler> getProximosVencer(){
		
		List<ContratoAlquiler> toRet = new ArrayList<>();
		
		contratoDao.getAlquilerVigentes().forEach(c -> {
		
			LocalDate fin = c.getPrimerAnioMes().plusMonths(c.getCantMeses()).toLocalDate(1);
			LocalDate notificacion = fin.minus(c.getAvisoProxVencer().getPeriodo());
			
			if(c.getAvisoProxVencer().isHabilitado())
				if(!notificacion.isAfter(LocalDate.now()))
					toRet.add(c);
		
		});
		
		return toRet;
		
	}

	public List<ContratoAlquiler> getcontratosAlquilerBy(ContratoAlquilerFiltro filtro) {
		return contratoDao.getAllBy(filtro);
	}
}
