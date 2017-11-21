package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.CartelDTO;
import entities.Cartel;
import persistencia.dao.iface.CartelDao;
import persistencia.dao.iface.PersonaDao;

import java.util.ArrayList;
import java.util.List;

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

	public List<CartelDTO> fichaPropiedadReporteOf(List<Cartel> carteles) {

		List<CartelDTO> dtos = new ArrayList<CartelDTO>();

		for (Cartel cartel : carteles) {
			CartelDTO cart = new CartelDTO();

			cart.setAlto(cartel.getAlto());
			cart.setAncho(cartel.getAncho());
			cart.setDescripcion(cartel.getDescripcion());
			dtos.add(cart);
		}
		return dtos;
	}

}
