package model;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.ContratoAlquiler;
import entities.DatosActualizacionContrato;
import entities.DatosPunitorioContrato;
import entities.Moneda;
import entities.Precio;
import entities.TipoContratoAlquiler;
import persistencia.dao.iface.ContratoDao;

@Singleton
public class ContratoService {

	ContratoDao contratoDao;
	
	@Inject
	private ContratoService(ContratoDao contratoDao) {
		this.contratoDao = contratoDao;
	}
	
	public void saveContratoAlquiler(ContratoAlquiler c) {
		contratoDao.save(c);
		//TODO: crear pagos y eso
	}
	
	public ContratoAlquiler getNewContratoAlquiler() {
		
		ContratoAlquiler toRet;
		toRet = new ContratoAlquiler();
		
		Precio p = new Precio(0, Moneda.PESOS);
		AvisoNotificacion intimacion = new AvisoNotificacion();
		AvisoNotificacion vencer = new AvisoNotificacion();
		DatosPunitorioContrato punitorio = new DatosPunitorioContrato();
		DatosActualizacionContrato actualizacion = new DatosActualizacionContrato();
		
		toRet.setCuotaMensual(p);
		toRet.setAvisoIntimacion(intimacion);
		toRet.setAvisoProxVencer(vencer);
		toRet.setDatoPunitorio(punitorio);
		toRet.setDatoActualizacion(actualizacion);
		toRet.setTipoContratoAlquiler(TipoContratoAlquiler.VIVIENDA);
		
		return toRet;
	}
	
}
