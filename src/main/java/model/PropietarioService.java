package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.PendientesPropietariosDTO;
import dto.PropietariosDTO;
import entities.*;
import entities.Persona.TipoCredencial;
import filtros.PropietarioFiltro;
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
    
	public Propietario getEmptyPropietario() {
		
		Propietario toRet = new Propietario();
		Persona p = new Persona();
		p.setTipoCred(Persona.TipoCredencial.DNI);
		toRet.setHabilitado(true);
		
		toRet.setPersona(p);
		
		return toRet;
	}
	
	public Propietario getNewPropietarioFrom(Persona p) {
		Propietario toRet = new Propietario();
		toRet.setHabilitado(true);
		toRet.setPersona(p);
		
		return toRet;
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

	public void savePropietario(Propietario toSave) throws LogicaNegocioException{
		
		if(existePropietarioCon(toSave.getPersona()))
			throw new LogicaNegocioException("Ya existe un propietario con la misma credencial");
		
		propietarioDao.save(toSave);
	}
	
	public List<Propietario> getAll() {
		return propietarioDao.getAll();
	}
	
	public List<Propietario> getAllByFiltro(PropietarioFiltro filtro){
		
		return propietarioDao.getAllByFiltro(filtro);
		
	}
	
	public boolean existePropietarioCon(Persona t) {
		
		return propietarioDao.existePropietarioCon(t);
		
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

	public List<PropietariosDTO> propietariosReporte() {

		List<Propietario> lista = propietarioDao.getAll();
		List<PropietariosDTO> toRet;
		toRet = lista.stream()
			.map((Propietario p) ->
				{
				PropietariosDTO dto = new PropietariosDTO();
				Persona persona = p.getPersona();
				dto.setApellido( persona.getApellido());
				dto.setEmail(persona.getEmail());
				dto.setNombre(persona.getNombre());
				dto.setTipoCredencial(persona.getTipoCred().toString());
				dto.setCredencialStr(persona.getCredencial());
				String telephones = getTelefonosString(p.getPersona());
				dto.setTelefonos( telephones );
				return dto;
			}).sorted((p1, p2) -> p1.getApellido().compareTo(p2.getApellido()))
			.collect(Collectors.toList());
		return toRet;
	}

	private String getTelefonosString(Persona p){
		String toRet  = "";

		for (Telefono t : p.getTelefonos()) {
			toRet += t.getNumero() + " " + t.getTipo() + " ";
		}

		return toRet;
	}

}
