package model;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import persistencia.iface.InmobiliariaDao;

@Singleton
public class InmobiliariaService {

	InmobiliariaDao inmobiliariaDao;
	
	@Inject
	private InmobiliariaService(InmobiliariaDao inmobiliariaDao) {
		this.inmobiliariaDao = inmobiliariaDao;
	}
	
	public List<Inmobiliaria> getAll(){
		return inmobiliariaDao.getAll();
	}
}
