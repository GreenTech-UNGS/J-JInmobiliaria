package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.Precio;
import entities.Propiedad;
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
	
	public Propiedad getEmptyPropiedad() {
		
		Propiedad toRet = new Propiedad();
		
		toRet.setPrecioTentativo(new Precio(0, Moneda.PESOS));
		
		return toRet;
		
	}
	
}
