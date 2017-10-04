package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona;
import entities.Persona.TipoCredencial;
import entities.Propietario;
import persistencia.dao.iface.PropietarioDao;

@Singleton
public class PropietarioService {

	PropietarioDao propietarioDao;
	
	@Inject
	private PropietarioService(PropietarioDao propietarioDao) {
		this.propietarioDao = propietarioDao;
	}

	public void addNewPropietario(String propietarioCuit) {
		Propietario toAdd = new Propietario();
		toAdd.setHabilitado(true);
		
		//TODO: si ya existe una persona con el mismo cuit se debe trar y agregar esa
		Persona p = new Persona();
		p.setTipoCred(TipoCredencial.CUIT);
		p.setCredencial(propietarioCuit);
		
		toAdd.setPersona(p);
		
		propietarioDao.save(toAdd);
		
	}
	
}
