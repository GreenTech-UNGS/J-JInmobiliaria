package model;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.Interesado;
import entities.Persona;
import entities.Preferencia;
import entities.Propiedad;
import entities.TipoOfrecimiento;
import filtros.InteresadoFiltro;
import persistencia.dao.iface.InteresadoDao;
import persistencia.dao.iface.PersonaDao;

@Singleton
public class InteresadoService {
	
	@Inject private InteresadoDao interesadoDao;
	@Inject private PersonaDao personaDao;
	
	@Inject
	public InteresadoService(){

	}
	
	public List<Interesado> getAll(){
		return interesadoDao.getAll();
	}
	
	public Interesado getEmptyInteresado() {
		
		Interesado toRet = new Interesado();
		Persona p = new Persona();
		p.setTipoCred(Persona.TipoCredencial.DNI);
		toRet.setPersona(p);
		Preferencia preferencia = new Preferencia();
		toRet.setPreferencia(preferencia);
		
		return toRet;
	}
	
	public void saveInteresado(Interesado toSave) throws LogicaNegocioException {
			
		interesadoDao.save(toSave);
	}
	
	public void editInteresado(Interesado toSave) throws LogicaNegocioException {
		
		interesadoDao.save(toSave);
	}

	public void removeInteresado(Interesado toRemove){
		
		interesadoDao.remove(toRemove);
	}

	public List<Interesado> getAllByFiltro(InteresadoFiltro filtro){
	
		return interesadoDao.getAllByFiltro(filtro);
	
	}
	
	public List<Interesado> getAllByPropiedad(Propiedad propiedad){
		List<Interesado> toRet = new ArrayList<Interesado>();
		for(Interesado i : interesadoDao.getAll()){
			if(this.matches(i.getPreferencia(), propiedad)){
				toRet.add(i);
			}
		}				
		return toRet;
	}
	
	public boolean matches(Preferencia t, Propiedad p) {
		
		if(t.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquiler) && p.getOfrecimientoAlquiler().isHabilitada() == false)
			return false;
		
		if(t.getTipoOfrecimiento().equals(TipoOfrecimiento.Venta) && p.getOfrecimientoVenta().isHabilitada() == false)
			return false;
		
		if( ! (p.getOfrecimientoVenta().getPrecio().getMoneda().equals(t.getMoneda())) )
			return false;
		
		if(p.getOfrecimientoVenta().getPrecio().getMonto() < t.getPrecioDesde())
			return false;
		
		if(p.getOfrecimientoVenta().getPrecio().getMonto() > t.getPrecioDesde())
			return false;
		
		if(p.getOtrosDatos().getCantidadAmbientes() < t.getCantidadAmbientesDesde())
			return false;
		
		if(p.getOtrosDatos().getCantidadAmbientes() > t.getCantidadAmbientesHasta())
			return false;
				
		if(p.getOtrosDatos().getMetrosCuadradosLote() < t.getMetrosCuadradosDesde())
			return false;
		
		if(p.getOtrosDatos().getMetrosCuadradosLote() > t.getMetrosCuadradosHasta())
			return false;
		
		
		return true;
	}
}
