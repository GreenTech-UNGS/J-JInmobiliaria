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
	
	public MapPoint getLocalizationOf(String calle, String altura, Localidad localidad) throws LogicaNegocioException {
		
		if(calle == null || altura == null || localidad == null || localidad.getNombre() == null)
			throw new LogicaNegocioException("No se puede actualizar el mapa, faltan datos de ubcacion");

			
		
		String loc = altura +
				" " + calle +
				"," + localidad.getNombre() +
				"," + localidad.getProvincia().toString().replaceAll("_", " ") +
				" " + "Argentina";
		
		loc = loc.replaceAll(" ", "+");
		
		MapPoint point = locDao.getLocationOf(loc);
		
		if(point == null)
			throw new LogicaNegocioException("No se encontro la ubicacion");
		
		return point;
		
	}
	
}
