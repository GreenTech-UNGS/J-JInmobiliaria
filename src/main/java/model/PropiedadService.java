package model;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Moneda;
import entities.Precio;
import entities.Propiedad;
import entities.Propietario;
import entities.TipoOfrecimiento;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class PropiedadService {

	@Inject
	PropiedadDao propiedadDao;
	
	@Inject
	private PropiedadService() {
		
	}
	
	public List<Propiedad> getAll(){
		return propiedadDao.getAll();
	}
	
	public void savePropiedad(Propiedad p) {
		
		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.DISPONIBLE);
		historia.setFecha(DateTime.now());
		
		p.getEstados().add(historia);
		propiedadDao.save(p);
	}
	
	public Propiedad getEmptyPropiedad() {
		Propiedad toRet = new Propiedad();
		
		toRet.setPrecioTentativo(new Precio(0, Moneda.PESOS));
		toRet.setTipoOfrecimiento(TipoOfrecimiento.ALQUILER);
		
		return toRet;
		
	}
	
	public EstadoProp getCurrentEstado(Propiedad p) {
		
		p.getEstados().sort((h1, h2) -> h1.getFecha().compareTo(h2.getFecha()));
		return p.getEstados().get(p.getEstados().size() - 1).getEstado();
		
	}

	public List<Propiedad> getDisponiblesAlquiler() {
		
		List<Propiedad> allProps = getAll();
		
		List<Propiedad> toRet = allProps.stream().filter(p -> getCurrentEstado(p).equals(EstadoProp.DISPONIBLE) ||
			getCurrentEstado(p).equals(EstadoProp.BORRADOR))
						.filter(p -> p.getTipoOfrecimiento().equals(TipoOfrecimiento.ALQUILER) ||
				p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA_Y_ALQUILER))
						.collect(Collectors.toList());
		
		return toRet;
		
	}
	
}
