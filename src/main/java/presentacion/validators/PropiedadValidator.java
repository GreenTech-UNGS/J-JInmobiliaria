package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import model.ClienteService;
import model.PropiedadService;

@Singleton
public class PropiedadValidator implements Validator<Propiedad>{

	PropietarioValidator propietarioValidator;
	InmobiliariaValidator inmobiliariaValidator;
	MessageShow msgShw;
	PropiedadService propiedadService;
	ClienteService clienteService;
	
	@Inject
	private PropiedadValidator(PropietarioValidator propietarioValidator,
			InmobiliariaValidator inmobiliariaValidator,
			MessageShow msgShw, 
			PropiedadService propiedadService,
			ClienteService clienteService) {
		
		this.propietarioValidator = propietarioValidator;
		this.inmobiliariaValidator = inmobiliariaValidator;
		this.msgShw = msgShw;
		this.propiedadService = propiedadService;
		this.clienteService = clienteService;
	}
	
	@Override
	public boolean isValid(Propiedad t) {

		if(hayCamposVacios(t)){
			msgShw.showErrorMessage("Debe completar todos los campos obligatorios", "Error");
			return false;
		}
		
		if(propietarioValidator.isValid(t.getPropietario()) == false) {		
			msgShw.showErrorMessage("El propietario asociado tiene datos incorrectos", "Error");
			return false;
		}
			
//		if(inmobiliariaValidator.isValid(t.getInmobiliaria()) == false) {
//			msgShw.showErrorMessage("La inmobiliaria asociada tiene datos incorrectos", "Error");
//			return false;
//		}

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
				t.getLocalidad().getNombre() == null;
	}
	
}
