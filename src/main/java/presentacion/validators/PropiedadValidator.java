package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.Propiedad;
import model.PropiedadService;

@Singleton
public class PropiedadValidator implements Validator<Propiedad>{

	MessageShow msgShw;
	PropiedadService propiedadService;
	
	@Inject
	private PropiedadValidator(MessageShow msgShw, 
			PropiedadService propiedadService) {
		
		this.msgShw = msgShw;
		this.propiedadService = propiedadService;
	}
	
	@Override
	public boolean isValid(Propiedad t) {

		if(hayCamposVacios(t)){ //propiedadService.getCurrentEstado(t).equals(EstadoProp.DISPONIBLE) && 
			msgShw.showErrorMessage("Debe completar todos los campos obligatorios", "Error");
			return false;
		}
		
		if(t.getPropietario().isHabilitado() == false) {		
			msgShw.showErrorMessage("El propietario asociado no esta habilitado", "Error");
			return false;
		}
			
		if(t.getPrecioTentativo().getMonto() <= 0){		
			msgShw.showErrorMessage("Ingrese un precio valido", "Error");
			return false;
		}
		
		return true;
	}
	
	private boolean hayCamposVacios(Propiedad t) {
		
		return
				t.getIdentificador().equals("") ||
				t.getCalle().equals("") ||
				t.getAltura().equals("") ||
				t.getLocalidad().getNombre() == null ||
				t.getPropietario().getPersona().getNombre() == null;
	}
		
}
