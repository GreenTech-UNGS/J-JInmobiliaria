package presentacion.mappers;

import org.joda.time.Period;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;
import entities.Moneda;
import entities.TipoContratoAlquiler;
import presentacion.vista.ContratoAlquilerForm;

@Singleton
public class ContratoAlquilerFormMapper implements Mapper<ContratoAlquiler>{

	ContratoAlquilerForm view;
	
	
	@Inject
	private ContratoAlquilerFormMapper(ContratoAlquilerForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(ContratoAlquiler t) {
		

		String identificador = getStringOf(view.getTextIdContrato().getText());
		String garantia = getStringOf(view.getTextGarantia().getText());
		TipoContratoAlquiler tipoContrato = view.getComboTipoContratoModel().getSelected();
		int cantidadMeses = (int) view.getSpinnerDuracionContrato().getValue();
		float gatosAdmin = (float) view.getSpinnerGastosAdmin().getValue();
		double cuotaMensualMonto = Double.parseDouble(view.getTextPrecio().getText());
		Moneda cuotaMensualMoneda = view.getMonedaComboModel().getSelected();
		
		//Actualizacion
		float porcentajeActualizacion = (float) view.getSpinnerPorcenajeActualiza().getValue();
		int mesesActualizacion = (int) view.getSpinnerActualizaContrato().getValue();
		boolean actualizacionAcumulativo = view.getChckbxAcumulativoActualiza().isSelected();
		
		//Punitorio
		float porcentajePunitorio = (float)view.getSpinnerPorcentajePunitorio().getValue();
		int diasPagoPunitorio = (int)view.getSpinnerTiempoPago().getValue();
		boolean acumulativoPunitorio = view.getChkbxAcumulativoPunitorio().isSelected();
		
		//Avisos
		boolean intimacionHabilitado = view.getChckbxIntimacion().isSelected();
		boolean vencimientoHabilitado = view.getChckbxVencimiento().isSelected();
		String intimacionDiasStr = view.getSpinnerIntimacionEmail().getValue().toString();
		String vencimientoMesesStr = view.getSpinnerVencimientoEmail().getValue().toString();
		Period intimacionPeriod = Period.days(Integer.parseInt(intimacionDiasStr));
		Period vencimientoPeriod = Period.months(Integer.parseInt(vencimientoMesesStr));
		
//		Propiedad propiedad = view.getTfIdPropiedad();
		
		
		
		t.setIdentificador(identificador);
		t.setGarantia(garantia);
		t.setTipoContratoAlquiler(tipoContrato);
		t.setCantMeses(cantidadMeses);
		t.setGastosAdmin(gatosAdmin);
		t.getCuotaMensual().setMonto(cuotaMensualMonto);
		t.getCuotaMensual().setMoneda(cuotaMensualMoneda);
		
		t.getDatoActualizacion().setPorcentaje(porcentajeActualizacion);
		t.getDatoActualizacion().setActualizacionMeses(mesesActualizacion);
		t.getDatoActualizacion().setAcumulativo(actualizacionAcumulativo);
		
		t.getDatoPunitorio().setPorcentaje(porcentajePunitorio);
		t.getDatoPunitorio().setDiasDePago(diasPagoPunitorio);
		t.getDatoPunitorio().setAcumulativo(acumulativoPunitorio);
		
		t.getAvisoIntimacion().setHabilitado(intimacionHabilitado);
		t.getAvisoIntimacion().setPeriodo(intimacionPeriod);
		
		t.getAvisoProxVencer().setHabilitado(vencimientoHabilitado);
		t.getAvisoProxVencer().setPeriodo(vencimientoPeriod);
		
	}

	@Override
	public void fillFields(ContratoAlquiler t) {

		
		String identificador = t.getIdentificador();
		String garantia = t.getGarantia();
		TipoContratoAlquiler tipoContrato = t.getTipoContratoAlquiler();
		int cantidadMeses = t.getCantMeses();
		float gatosAdmin = t.getGastosAdmin();
		double cuotaMensualMonto = t.getCuotaMensual().getMonto();
		Moneda cuotaMensualMoneda = t.getCuotaMensual().getMoneda();
		
		//Actualizacion
		float porcentajeActualizacion = t.getDatoActualizacion().getPorcentaje();
		int mesesActualizacion = t.getDatoActualizacion().getActualizacionMeses();
		boolean actualizacionAcumulativo = t.getDatoActualizacion().isAcumulativo();
		
		//Punitorio
		float porcentajePunitorio = t.getDatoPunitorio().getPorcentaje();
		int diasPagoPunitorio = t.getDatoPunitorio().getDiasDePago();
		boolean acumulativoPunitorio = t.getDatoPunitorio().isAcumulativo();
		
		//Avisos
		boolean intimacionHabilitado = t.getAvisoIntimacion().isHabilitado();
		boolean vencimientoHabilitado = t.getAvisoProxVencer().isHabilitado();
		
		int intimacionDias = t.getAvisoIntimacion().getPeriodo().getDays();
		int vencimientoMeses = t.getAvisoProxVencer().getPeriodo().getMonths();
		
		String propiedad = t.getPropiedad().getIdentificador();
		view.getTfIdPropiedad().setText(propiedad);

		String cliente = t.getCliente().getPersona().getCredencial();
		view.getTfCliente().setText(cliente);
		
		view.getTextIdContrato().setText(identificador);
		view.getTextGarantia().setText(garantia);
		view.getComboTipoContratoModel().setSelected(tipoContrato);
		view.getSpinnerDuracionContrato().setValue(cantidadMeses);
		view.getSpinnerGastosAdmin().setValue(gatosAdmin);
		view.getTextPrecio().setText(cuotaMensualMonto + "");
		view.getMonedaComboModel().setSelected(cuotaMensualMoneda);
		
		//Actualizacion
		view.getSpinnerPorcenajeActualiza().setValue(porcentajeActualizacion);
		view.getSpinnerActualizaContrato().setValue(mesesActualizacion);
		view.getChckbxAcumulativoActualiza().setSelected(actualizacionAcumulativo);
		
		//Punitorio
		view.getSpinnerPorcentajePunitorio().setValue(porcentajePunitorio);
		view.getSpinnerTiempoPago().setValue(diasPagoPunitorio);
		view.getChkbxAcumulativoPunitorio().setSelected(acumulativoPunitorio);
		
		//Avisos
		view.getChckbxIntimacion().setSelected(intimacionHabilitado);
		view.getChckbxVencimiento().setSelected(vencimientoHabilitado);
		view.getSpinnerIntimacionEmail().setValue(intimacionDias);
		view.getSpinnerVencimientoEmail().setValue(vencimientoMeses);
		
		
	}
	
	private String getStringOf(String s){
		return s == null? "": s;
	}

}
