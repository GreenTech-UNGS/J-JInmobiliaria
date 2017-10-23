
package model;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import entities.Telefono;
import persistencia.dao.iface.InmobiliariaDao;

@Singleton
public class InmobiliariaService {
	
	InmobiliariaDao inmobiliariaDao;
	
	@Inject
	private InmobiliariaService(InmobiliariaDao inmobiliariaDao){
		this.inmobiliariaDao = inmobiliariaDao;
		
	}
	
	public List<Inmobiliaria> getAll(){
		return inmobiliariaDao.getAll();
	
	}
	
	public Inmobiliaria getEmptyInmobiliaria() {
		
		Inmobiliaria toRet = new Inmobiliaria();
		
		return toRet;
	}

	public void saveInmobiliaria(Inmobiliaria inmobiliaria) {
		inmobiliariaDao.save(inmobiliaria);
		
	}
	
	public List<Telefono> getAllTelefonosOf(Inmobiliaria i) {
		List<Telefono> toRet = inmobiliariaDao.getAllTelefonosOf(i);
		
		if(toRet == null)
			toRet = new ArrayList<>();
		
		return toRet;
		
	}
	

}

