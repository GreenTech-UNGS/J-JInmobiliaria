package model;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.ContratoAlquiler;
import entities.DatosActualizacionContrato;
import entities.DatosPunitorioContrato;
import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Moneda;
import entities.Precio;
import entities.Propiedad;
import entities.TipoContratoAlquiler;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class ContratoService {

	ContratoDao contratoDao;
	PropiedadDao propiedadDao;
	
	@Inject
	private ContratoService(ContratoDao contratoDao,
			PropiedadDao propiedadDao) {
		this.contratoDao = contratoDao;
		this.propiedadDao = propiedadDao;
	}
	
	public void saveContratoAlquiler(ContratoAlquiler c) {
		contratoDao.save(c);
		
		HistoriaEstadoProp estado = new HistoriaEstadoProp();
		estado.setEstado(EstadoProp.ALQUILADA);
		estado.setFecha(DateTime.now());
		
		Propiedad propiedad = c.getPropiedad();
		propiedad.getEstados().add(estado);
		
		propiedadDao.save(propiedad);
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
