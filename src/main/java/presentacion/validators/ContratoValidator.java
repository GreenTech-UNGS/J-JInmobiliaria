package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Contrato;
import entities.EstadoContrato;
import entities.EstadoProp;
import model.ContratoService;
import model.PropiedadService;

@Singleton
public class ContratoValidator implements Validator<Contrato>{

	ContratoService contratoService;
	PropiedadService propiedadService;
	MessageShow msgShw;
	
	@Inject
	public ContratoValidator(ContratoService contratoService,
			PropiedadService propiedadService,
			MessageShow msgShw) {
		
		this.contratoService = contratoService;
		this.propiedadService = propiedadService;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Contrato t) {
		
		if(t == null){
			return false;
		} else if(hayCamposVacios(t)) { //contratoService.getEstadoOf(t).equals(EstadoContrato.DEFINITIVO) && 
			msgShw.showErrorMessage("Debe completar todos los campos obligatorios", "Error");
			return false;
			
		}else if(t.getGastosAdmin() <= 0){		
				msgShw.showErrorMessage("Ingrese un precio valido", "Error");
				return false;
		
		} else if(existeContratoConIdentificador(t)) {
			msgShw.showErrorMessage("El Identificador" + t.getIdentificador() 
					+ " esta repetido. \n"
					+ "Si requiere ingresar un contrato existente utilice el boton buscar", "Error");
			return false;
			
		} else if(! (propiedadService.getCurrentEstado(t.getPropiedad()).equals(EstadoProp.DISPONIBLE) || 
				propiedadService.getCurrentEstado(t.getPropiedad()).equals(EstadoProp.RESERVADA))) {
			msgShw.showErrorMessage("La propiedad seleccionada no esta disponible", "Error");
			return false;
		}			
		
		return true;
	}
	
	private boolean existeContratoConIdentificador(Contrato t) {		
		return contratoService.existeContratoConIdentificador(t);
	} 
	
	private boolean hayCamposVacios(Contrato t) {
		return t.getIdentificador() == null||
				t.getPropiedad().getCalle() == null ||
				t.getCliente().getPersona() == null ||
				t.getGarantia().equals("");
	}
}
