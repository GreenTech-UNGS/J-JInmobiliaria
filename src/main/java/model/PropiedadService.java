package model;

import java.util.List;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Moneda;
import entities.Precio;
import entities.Propiedad;
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
	
}
