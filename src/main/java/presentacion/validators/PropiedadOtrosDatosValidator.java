package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosValidator implements ValidatorNew{

	private PropiedadOtrosDatosForm view;
	
	@Inject
	private PropiedadOtrosDatosValidator(PropiedadOtrosDatosForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return isMetrosValid() &&
				isCubiertoPositivo()&&
				isLotePositivo()&&
				isAmbientePositivo();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos: ";
		
		if(!isMetrosValid())
			toRet += "\n- La superficie del lote debe ser mayor a la superficie cubierta";
		if(!isAmbientePositivo())
			toRet += "\n- La cantidad de ambientes debe ser positiva";
		if(!isLotePositivo())
			toRet += "\n- La superficie de lote debe ser positiva";
		if(!isCubiertoPositivo())
			toRet += "\n- La superficie cubierta debe ser positiva";
		
		return toRet;
	}
	
	private boolean isMetrosValid() {
		
		int cubiertos = (int)view.getSpinnerCubiertos().getValue();
		int lote = (int) view.getSpinnerLote().getValue();
		
		return lote >= cubiertos;
	}
	
	private boolean isCubiertoPositivo() {

		int cubiertos = (int)view.getSpinnerCubiertos().getValue();
		return cubiertos > 0;
	}
	
	private boolean isLotePositivo() {

		int lote = (int) view.getSpinnerLote().getValue();
		return lote > 0;
	}
	
	private boolean isAmbientePositivo() {
		
		int ambientes = (int)view.getSpinnerAmbientes().getValue();
		return ambientes > 0;
		
	}

}
