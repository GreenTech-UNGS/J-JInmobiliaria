package presentacion.validators;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Foto;
import entities.HistoriaEstadoProp;
import entities.Inmobiliaria;
import entities.Localidad;
import entities.Precio;
import entities.Propiedad;
import entities.Propietario;
import entities.TipoOfrecimiento;
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

		if(t.getPrecioTentativo().getMonto() < 0){			
			return false;
		}
		
		if(propietarioValidator.isValid(t.getPropietario()) == false) {		
			msgShw.showErrorMessage("El propietario asociado tiene datos incorrectos", "Error");
			return false;
		}
			
		if(inmobiliariaValidator.isValid(t.getInmobiliaria()) == false) {
			msgShw.showErrorMessage("La inmobiliaria asociada tiene datos incorrectos", "Error");
			return false;
		}
		return true;
	}
	
}
