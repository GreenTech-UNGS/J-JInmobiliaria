package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import persistencia.dao.iface.LocalizationDao;
import persistencia.dao.iface.LocalizationDao.MapPoint;

@Singleton
public class LocalizationService {

	LocalizationDao locDao;
	
	@Inject
	public LocalizationService(LocalizationDao locDao) {

		this.locDao = locDao;
		
	}
	
	public MapPoint getLocalizationOf(String calle, String altura, Localidad localidad) {
		
		String loc = calle +
				" " + altura +
				", " + localidad.getNombre() +
				" " + localidad.getProvincia().toString().replaceAll("_", "") +
				" " + "Argentina";
		
		return locDao.getLocationOf(loc);
		
	}
	
}
