package presentacion.mappers;

import java.time.Period;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;
import entities.Moneda;
import entities.TipoContratoAlquiler;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;
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
		TipoContratoAlquiler tipoContrato = TipoContratoAlquiler.valueOf((String)view.getComboTipoContrato().getSelectedItem());
		int cantidadMeses = (int) view.getSpinnerDuracionContrato().getValue();
		float gatosAdmin = (float) view.getSpinnerGastosAdmin().getValue();
		double cuotaMensualMonto = Double.parseDouble(view.getTextPrecio().getText());
		Moneda cuotaMensualMoneda = Moneda.valueOf((String)view.getComboMoneda().getSelectedItem());
		
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
		Period intimacionPeriod = Period.ofDays(Integer.parseInt(intimacionDiasStr));
		Period vencimientoPeriod = Period.ofMonths(Integer.parseInt(vencimientoMesesStr));
		
		
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
		
		view.getTextIdContrato().setText(identificador);
		view.getTextGarantia().setText(garantia);
		view.getComboTipoContrato().setSelectedItem(tipoContrato.toString());
		view.getSpinnerDuracionContrato().setValue(cantidadMeses);
		view.getSpinnerGastosAdmin().setValue(gatosAdmin);
		view.getTextPrecio().setText(cuotaMensualMonto + "");
		view.getComboMoneda().setSelectedItem(cuotaMensualMoneda.toString());
		
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
