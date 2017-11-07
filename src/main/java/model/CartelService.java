package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cartel;
import persistencia.dao.iface.CartelDao;
import persistencia.dao.iface.PersonaDao;

@Singleton
public class CartelService {
	
	CartelDao cartelDao;
	PersonaDao personaDao;
	
	@Inject
	private CartelService(CartelDao cartelDao) {
		this.cartelDao = cartelDao;
	}
	
	public Cartel getEmptyCartel() {
		
		Cartel toRet = new Cartel();		
		return toRet;
	}
		
	public void saveCartel(Cartel toSave) throws LogicaNegocioException {
		
		if(existeCartelCon(toSave.getIdentificador()))
			throw new LogicaNegocioException("Ya existe un cartel con el mismo identificador");
	
		cartelDao.save(toSave);
	}
	
	private boolean existeCartelCon(String identificador) {
		
		return cartelDao.existeCartelCon(identificador);
	}

	public List<Cartel> getAll(){
		return cartelDao.getAll();
	}
	
}
