package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Contrato;
import model.ContratoService;

@Singleton
public class ContratoValidator implements Validator<Contrato>{

	ContratoService contratoService;
	MessageShow msgShw;
	
	@Inject
	public ContratoValidator(ContratoService contratoService,
			MessageShow msgShw) {
		
		this.contratoService = contratoService;
		this.msgShw = msgShw;
	}
	
	@Override
	public boolean isValid(Contrato t) {
		
		if(t == null){
			return false;
		} else if(hayCamposVacios(t)) {
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
		}
		
		return true;
	}
	
	private boolean existeContratoConIdentificador(Contrato t) {		
		return contratoService.existeContratoConIdentificador(t);
	} 
	
	private boolean hayCamposVacios(Contrato t) {
		return t.getCliente().getPersona() == null ||
				t.getCreador().getPersona() == null ||
				t.getPropiedad().getCalle() == null ||
				t.getIdentificador().equals("") ||
				t.getGarantia().equals("");
	}
}
