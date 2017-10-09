package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.PendientesPropietariosDTO;
import entities.PagoPropietario;
import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.Precio;
import entities.Propiedad;
import entities.Propietario;
import persistencia.dao.iface.PropietarioDao;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PropietarioService {

	PropietarioDao propietarioDao;
	//PropietarioPagoPendienteDAO propietarioPagoPendienteDAO;


    @Inject
	private PropietarioService(PropietarioDao propietarioDao) {
		this.propietarioDao = propietarioDao;
	}

	public void addNewPropietario(String propietarioCuit) {
		Propietario toAdd = new Propietario();
		toAdd.setHabilitado(true);
		
		//TODO: si ya existe una persona con el mismo cuit se debe trar y agregar esa
		Persona p = new Persona();
		p.setTipoCred(TipoCredencial.CUIT);
		p.setCredencial(propietarioCuit);
		
		toAdd.setPersona(p);
		
		propietarioDao.save(toAdd);
		
	}

	public List<Propietario> getAll() {
		return propietarioDao.getAll();
	}
	
	public List<PendientesPropietariosDTO> pagosPendientesReporte() {
		
		DecimalFormat format = new DecimalFormat("#.##");
		
		List<PagoPropietario> lista = propietarioDao.getAllPagosPropsPendientes();
		List<PendientesPropietariosDTO> toRet = lista.stream().map(p -> {
			PendientesPropietariosDTO dto = new PendientesPropietariosDTO();
			Persona persona = p.getCuota().getContrato().getCliente().getPersona();
			Persona propietario = p.getPropietario().getPersona();
			Precio precio = p.getMonto();
			Propiedad prop = p.getCuota().getContrato().getPropiedad();
			String provincia =  prop.getLocalidad().getProvincia().toString().replaceAll("_", "");
			
			dto.setIdContrato(p.getCuota().getContrato().getIdentificador());
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
