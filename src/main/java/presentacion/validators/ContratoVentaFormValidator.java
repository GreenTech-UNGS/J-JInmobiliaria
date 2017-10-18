package presentacion.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ContratoVentaForm;

@Singleton
public class ContratoVentaFormValidator implements ValidatorNew{

	ContratoVentaForm view;
	
	@Inject
	private ContratoVentaFormValidator(ContratoVentaForm view) {
		this.view = view;
	}
	
	@Override
	public boolean isValid() {
		return isIdValid() 
				&& isPropiedadValid()
				&& isClienteValid()
				&& isGarantiaValid()
				&& isPrecioValid()
				&& isGarantiaValid();
	}

	@Override
	public String getErrorMessage() {
		String toRet = "Errores en los siguientes campos";
		if(!isIdValid())
			toRet += "\n- El identificador no es valido";
		if(!isPropiedadValid())
			toRet += "\n- No ha seleccionado una propiedad valida";
		if(!isClienteValid())
			toRet += "\n- No ha seleccionado un cliente valido";
		if(!isGarantiaValid())
			toRet += "\n- La garantia no es valido";
		if(!isPrecioValid())
			toRet += "\n- El precio no es valido";
		if(!isGastosAdmValid())
			toRet += "\n- El porcentaje de gastos administrativos debe ser mayor a cero";	
		
		return toRet;
		
	}
		
	private boolean isIdValid(){
		String id = view.getTfIdContrato().getText();
		
		if(id == null || id.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isPropiedadValid(){
		String propiedad = view.getTfPropiedad().getText();
		
		if(propiedad == null || propiedad.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isClienteValid(){
		String cliente = view.getTfCliente().getText();
		
		if(cliente == null || cliente.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isGarantiaValid(){
		String garantia = view.getTfGarantia().getText();
		
		if(garantia == null || garantia.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isPrecioValid(){
		return view.getTfPrecio().getText().matches("([0-9]*[\\.])?[0-9]+");
	}	
		
	private boolean isGastosAdmValid(){
		return ((Integer) view.getSpinnerPorcentaje().getValue() <= 0);
	}
}
