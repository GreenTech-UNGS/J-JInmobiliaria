package presentacion.validators;

import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.ContratoAlquilerForm;

@Singleton
public class ContratoAlquilerFormValidator implements ValidatorNew{

	ContratoAlquilerForm view;
	
	@Inject
	private ContratoAlquilerFormValidator(ContratoAlquilerForm view) {
		this.view = view;
	}
		
	@Override
	public boolean isValid() {
		return isIdValid() 
				&& isPropiedadValid()
				&& isClienteValid()
				&& isGarantiaValid()
				&& isPrecioValid()
				&& isCantMesesValid()
				&& isGastosAdmValid()
				&& isActualizacionValid()
				&& isPjeActualizacionValid()
				&& isTiempoPagoValid()
				&& isPjePunitorioValid()
				&& isAnioMesValid();
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
		if(!isCantMesesValid())
			toRet += "\n- La duracion del contrato no es valida";		
		if(!isGastosAdmValid())
			toRet += "\n- El porcentaje de gastos administrativos debe ser mayor a cero";		
		if(!isActualizacionValid())
			toRet += "\n- La frecuencia de actualizacion debe ser mayor a cero";		
		if(!isPjeActualizacionValid())
			toRet += "\n- El porcentaje de actualizacion debe ser mayor a cero";		
		if(!isTiempoPagoValid())
			toRet += "\n- El plazo de pago debe ser mayor a cero";		
		if(!isPjePunitorioValid())
			toRet += "\n- El porcentaje punitorio debe ser mayor a cero";
		if(!isAnioMesValid())
			toRet += "\n- La fecha de inicio debe ser posterior a hoy";
		
		return toRet;
		
	}
		
	private boolean isIdValid(){
		String id = view.getTextIdContrato().getText();
		
		if(id == null || id.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isPropiedadValid(){
		String propiedad = view.getTfIdPropiedad().getText();
		
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
		String garantia = view.getTextGarantia().getText();
		
		if(garantia == null || garantia.equals(""))
			return false;
		
		return true;
	}
	
	private boolean isPrecioValid(){
		return view.getTextPrecio().getText().matches("([0-9]*[\\.])?[0-9]+");
	}	
	
	private boolean isCantMesesValid(){
		return   ((Integer) view.getSpinnerDuracionContrato().getValue() >= 12 ||
				  (Integer) view.getSpinnerDuracionContrato().getValue() <= 48);
	}	
	
	private boolean isGastosAdmValid(){
		return ((float) view.getSpinnerGastosAdmin().getValue() > 0);
	}	
	
	private boolean isActualizacionValid(){
		return ((Integer) view.getSpinnerActualizaContrato().getValue() > 0);
	}	
	
	private boolean isPjeActualizacionValid(){
		return ((float) view.getSpinnerPorcenajeActualiza().getValue() > 0);
	}	
	
	private boolean isTiempoPagoValid(){
		return ((Integer) view.getSpinnerTiempoPago().getValue() > 0);
	}	
	
	private boolean isPjePunitorioValid(){
		return ((float) view.getSpinnerPorcentajePunitorio().getValue() > 0);
	}
	
	private boolean isAnioMesValid() {
		
		YearMonth inicio = new YearMonth(view.getAnio().getYear(), view.getMes().getMonth() + 1);
		
		return !YearMonth.now().isAfter(inicio);
		
	}

}
