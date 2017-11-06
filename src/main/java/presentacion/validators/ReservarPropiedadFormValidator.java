package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ReservarPropiedadForm;

@Singleton
public class ReservarPropiedadFormValidator implements ValidatorNew{

	ReservarPropiedadForm view;
	
	@Inject
	private ReservarPropiedadFormValidator(ReservarPropiedadForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		
		return isPropiedadSelected() && isClienteSelected();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos";

		if(!isPropiedadSelected())
			toRet += "\n- No ha seleccionado ninguna propiedad";
		if(!isClienteSelected())
			toRet += "\n- No ha seleccionado ningun cliente";
		
		return toRet;
	}
	
	private boolean isPropiedadSelected(){
		return ! (view.getTfPropiedad() == null || view.getTfCliente().getText().equals(""));
	}
	
	private boolean isClienteSelected(){
		return ! (view.getTfCliente() == null || view.getTfCliente().getText().equals(""));
	}

}
