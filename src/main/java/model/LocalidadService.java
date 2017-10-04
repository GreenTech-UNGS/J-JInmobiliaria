package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import entities.Provincia;
import persistencia.dao.iface.LocalidadDao;

@Singleton
public class LocalidadService {

	LocalidadDao localidadDao;
	
	@Inject
	private LocalidadService(LocalidadDao localidadDao) {
		this.localidadDao = localidadDao;
	}
	
	public List<Localidad> getAllOf(Provincia p){
		
		return localidadDao.getAllOf(p);
		
	}
	
	public void addNewLocalidad(String nombre, Provincia provincia) {
		
		Localidad toAdd = new Localidad();
		toAdd.setNombre(nombre);
		toAdd.setProvincia(provincia);
		
		localidadDao.save(toAdd);
		
	}
	
}
