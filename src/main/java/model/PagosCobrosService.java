package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.CobrosDeAlquileresDTO;
import dto.PendientesPropietariosDTO;
import entities.*;
import entities.PagoPropietario.EstadoPago;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import persistencia.dao.iface.IngresoDao;
import persistencia.dao.iface.PropietarioDao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PagosCobrosService {

	CuotaService cuotaService;
	IngresoDao ingresoDao;
	PropietarioDao propietarioDao;
	
	@Inject
	private PagosCobrosService(CuotaService cuotaService,
			IngresoDao ingresoDao,
			PropietarioDao propietarioDao) {
		
		this.cuotaService = cuotaService;
		this.ingresoDao = ingresoDao;
		this.propietarioDao = propietarioDao;
	}
	
	
	public void generarCobroAlquiler(CuotaAlquiler cuota, DateTime fecha) {
		
		HistoriaEstadoCuota nuevo = new HistoriaEstadoCuota();
		
		DateTime fechaNueva = fecha.withTime(LocalTime.now());
		
		nuevo.setFecha(fechaNueva);
		nuevo.setEstado(EstadoCuota.PAGA);
		
		cuota.getEstados().add(nuevo);
		
		IngresoAlquiler ingreso = new IngresoAlquiler();
		Precio p = new Precio(0, cuota.getContrato().getCuotaMensual().getMoneda());
		double monto = cuota.getMonto().getMonto();

		InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
		if(interes != null)
			monto += interes.getMonto().getMonto();
		
		double ingresoMonto = monto * (cuota.getContrato().getGastosAdmin() / 100.0);
		p.setMonto(ingresoMonto);
		
		ingreso.setCuota(cuota);
		ingreso.setDetalle("Pago de cuota al dia " + fechaNueva.toString("dd/MM/YYYY"));
		ingreso.setFecha(fechaNueva);
		ingreso.setMonto(p);
		
		ingresoDao.save(ingreso);
		cuotaService.saveCuota(cuota);
		
		generaPagopropietario(cuota);
		
	}
	
	public void generaPagopropietario(CuotaAlquiler cuota) {
		
		PagoPropietario nuevoPago = new PagoPropietario();
		double monto = cuota.getMonto().getMonto();
		InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
		
		if(interes != null)
			monto += interes.getMonto().getMonto();
		
		double montoParaPropietario = monto * ((100.0 - cuota.getContrato().getGastosAdmin())/100.0);
		
		Precio p = new Precio(montoParaPropietario, cuota.getMonto().getMoneda());
		
		nuevoPago.setCuota(cuota);
		nuevoPago.setContrato(cuota.getContrato());
		nuevoPago.setEstado(EstadoPago.PENDIENTE);
		nuevoPago.setMonto(p);
		nuevoPago.setPropietario(cuota.getContrato().getPropiedad().getPropietario());
		
		propietarioDao.generaPago(nuevoPago);
		
	}
	
	public void generaPagoPropietario(ContratoVenta c) {
		
		PagoPropietario nuevoPago = new PagoPropietario();
		double monto = c.getMonto().getMonto();		
		
		double montoParaPropietario = monto * ((100.0 - c.getGastosAdmin())/100.0);
		
		Precio p = new Precio(montoParaPropietario, c.getMonto().getMoneda());
		
		nuevoPago.setContrato(c);
		nuevoPago.setEstado(EstadoPago.PENDIENTE);
		nuevoPago.setMonto(p);
		nuevoPago.setPropietario(c.getPropiedad().getPropietario());
		
		propietarioDao.generaPago(nuevoPago);
		
	}
	
	public List<PagoPropietario> getAllPagosPropsPendientes(){
		
		return propietarioDao.getAllPagosPropsPendientes();
		
	}

	public void registrarpagoPropietario(PagoPropietario p) {
		
		p.setEstado(EstadoPago.PAGO);
		
		HistoriaEstadoCuota nuevo = new HistoriaEstadoCuota();
		nuevo.setEstado(EstadoCuota.PAGAPROPIETARIO);
		nuevo.setFecha(DateTime.now());

		p.getCuota().getEstados().add(nuevo);
		propietarioDao.savePago(p);
		
	}

	public List<CobrosDeAlquileresDTO> cobrosDeAlquilerReporteOf(List<CuotaAlquiler> listaCuotas) {

		//List<CuotaAlquiler> listaCuotas =  cuotaService.getCuotasOf(aniomes, EstadoCuota.values());
		List<CobrosDeAlquileresDTO> cobros = new ArrayList<CobrosDeAlquileresDTO>();

		for (CuotaAlquiler cuota : listaCuotas) {
			String identificadorContrato = cuota.getContrato().getIdentificador();
			String nombreInquilino = cuota.getContrato().getCliente()
										.getPersona().getApellido()
									+ ", "
									+ cuota.getContrato().getCliente()
										.getPersona().getNombre();
									//+ cuota.getContrato().getCliente().getPersona().getTelefonos()
			String propiedad = cuota.getContrato().getPropiedad().getCalle()
								+ " " +cuota.getContrato().getPropiedad().getAltura()
								+ " Piso:" +cuota.getContrato().getPropiedad().getPiso()
								+ " Dto.:" +cuota.getContrato().getPropiedad().getDpto();
			String estado = cuotaService.getEstadoOf(cuota).toString();
			String moneda = cuota.getMonto().getMoneda().toString();
			InteresPunitorioCuota interes = cuotaService.getInteresOf(cuota);
			String interesStr  = "";
			Double montoTotal = cuota.getMonto().getMonto();
			Double monto = cuota.getMonto().getMonto();
			if(interes != null){
				interesStr = interes.getMonto().getMonto()+ " "
							+ interes.getMonto().getMoneda().toString();
				montoTotal += interes.getMonto().getMonto();
			}

			CobrosDeAlquileresDTO toAdd = new CobrosDeAlquileresDTO();
			toAdd.setIdContrato(identificadorContrato);
			toAdd.setInquilinoStr(nombreInquilino);
			toAdd.setPropiedadStr(propiedad);
			toAdd.setMonedaStr(moneda);
			toAdd.setAnioMes(cuota.getAnioMes().toString());
			toAdd.setMonto(monto);
			toAdd.setMontoTotal(montoTotal);
			toAdd.setEstadoStr(estado);
			toAdd.setInteresStr(interesStr);

			cobros.add(toAdd);
		}
		return cobros;
	}
	
	public List<PendientesPropietariosDTO> pagosPendientesReporte() {
		
		DecimalFormat format = new DecimalFormat("#.##");
		
		List<PagoPropietario> lista = propietarioDao.getAllPagosPropsPendientes();
		List<PendientesPropietariosDTO> toRet = lista.stream().map(p -> {
			PendientesPropietariosDTO dto = new PendientesPropietariosDTO();
			Persona persona = p.getContrato().getCliente().getPersona();
			Persona propietario = p.getPropietario().getPersona();
			Precio precio = p.getMonto();
			Propiedad prop = p.getContrato().getPropiedad();
			String provincia =  prop.getLocalidad().getProvincia().toString().replaceAll("_", "");
			
			dto.setIdContrato(p.getContrato().getIdentificador());
			dto.setInquilinoStr(persona.getNombre() + " " +
					persona.getApellido() + " " +
					persona.getTipoCred().toString() + " " +
					persona.getCredencial());
			
			dto.setMontoStr(precio.getMoneda().toString() + " " + format.format(precio.getMonto()));
			dto.setPropiedadStr(prop.getCalle() + " " +prop.getAltura() + ", " + prop.getLocalidad().getNombre() + " " + provincia);
			dto.setPropietarioStr(propietario.getApellido() + " " + propietario.getNombre());
			
			return dto;
		}).sorted((p1, p2) -> p1.getPropietarioStr().compareTo(p2.getPropietarioStr()))
				.collect(Collectors.toList());
		
		
		
		return toRet;
		
		
	}

}
