package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.PropiedadForm;

@Singleton
public class PropiedadFormValidator implements ValidatorNew{

	
	PropiedadForm view;
	
	@Inject
	private PropiedadFormValidator(PropiedadForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		return isIdentificadorValid() 
				&& isCalleValid()
				&& isAlturaValid()
				&& isLocalidadValid()
				&& isPrecioValid();
	}	

	@Override
	public String getErrorMessage() {
		String toRet = "Error en los siguientes campos: ";
		if(!isIdentificadorValid())
			toRet += "\n- El codigo no es valido";
		if(!isCalleValid())
			toRet += "\n- La calle no es valida";
		if(!isAlturaValid())
			toRet += "\n- La altura no es valida";
		if(!isLocalidadValid())
			toRet += "\n- No ha seleccionado ninguna localidad";
		if(!isPrecioValid())
			toRet += "\n- El precio no es valido";
		
		return toRet;
	}
	
	private boolean isIdentificadorValid(){
		String identificador = view.getTfIdentificador().getText();
		
		if(identificador == null || identificador.equals("") || identificador.matches("\\b*"))
			return false;
		
		return true;
	}
	
	private boolean isPrecioValid(){
		return true;// view.getTfPrecio().getText().matches("([0-9]*[\\.])?[0-9]+");
	}
	
	private boolean isCalleValid(){
		String calle = view.getTfCalle().getText();
		
		if(calle == null || calle.equals("") || calle.matches("\\b*"))
			return false;

		return true;
	}
	
	private boolean isAlturaValid(){
		String localidad = view.getTfAltura().getText();
		
		if(localidad == null || localidad.equals("") || localidad.matches("\\b*"))
			return false;
		if( ! localidad.matches(Regex.onlyNumbers()))
			return false;
		
		return true;
	}
	
	private boolean isLocalidadValid(){
		String localidad = (String) view.getComboLocalidad().getSelectedItem();
		
		if(localidad == null || localidad.equals("") || localidad.matches("\\b*"))
			return false;
		
		return true;
	}

}
