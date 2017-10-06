package presentacion.controller;

import java.time.Period;
import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.AvisoNotificacion;
import entities.ContratoAlquiler;
import entities.Moneda;
import entities.TipoContratoAlquiler;
import entities.TipoOfrecimiento;
import misc.Binder;
import model.ContratoService;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;
import presentacion.vista.AddContratoAlq;

@Singleton
public class AddContAlqController {
	
	@Inject
	ContratoService contratoService;
	@Inject
	AddContratoAlq view;
	
	Binder<ContratoAlquiler> binder;
	ContratoAlquiler currentContrato;
	
	TipoContratoAlqComboBoxModel tipoCombo;
	MonedaComboBoxModel monedaCombo;
	
	@Inject
	private AddContAlqController(ContratoService contratoService,
								AddContratoAlq view) {
		
		this.contratoService = contratoService;
		this.view = view;
		
		tipoCombo = new TipoContratoAlqComboBoxModel();
		monedaCombo = new MonedaComboBoxModel();
		
		this.binder = new Binder<>();
		initBinder();
		
		view.getBtnGuardarContrato().addActionListener(e -> guardaContrato());
		

		fillCombos();
	}
	

	private void initBinder() {
		
		binder.bind("identificador", view.getTextIdContrato());
		
		binder.bind("garantia",
				view.getTextGarantia()::getText,
				t -> view.getTextGarantia().setText((String)t));
		
		binder.bind("tipoContratoAlquiler",
				tipoCombo::getSelected,
				t -> tipoCombo.setSelected((TipoContratoAlquiler)t));
		
		binder.bind("cantMeses",
				view.getSpinnerDuracionContrato()::getValue,
				i -> view.getSpinnerDuracionContrato().setValue(i));
		
		binder.bind("gastosAdmin",
				view.getSpinnerGastosAdmin()::getValue,
				f -> view.getSpinnerGastosAdmin().setValue(f));
		
		binder.bind("cuotaMensual.monto",
				() -> Float.parseFloat(view.getTextPrecio().getText()),
				f -> view.getTextPrecio().setText(f.toString()));
		
		binder.bind("cuotaMensual.moneda",
				monedaCombo::getSelected,
				m -> monedaCombo.setSelected((Moneda)m));
		
		binder.bind("datoActualizacion.porcentaje",
				view.getSpinnerPorcenajeActualiza()::getValue,
				f -> view.getSpinnerPorcenajeActualiza().setValue(f));
		
		binder.bind("datoActualizacion.actualizacionMeses",
				view.getSpinnerActualizaContrato()::getValue,
				f -> view.getSpinnerActualizaContrato().setValue(f));
		
		binder.bind("datoActualizacion.isAcumulativo",
				view.getChckbxAcumulativoActualiza()::isSelected,
				b -> view.getChckbxAcumulativoActualiza().setSelected((Boolean)b));
		
		binder.bind("datoPunitorio.porcentaje",
				view.getSpinnerPorcentajePunitorio()::getValue,
				f -> view.getSpinnerPorcentajePunitorio().setValue(f));
		
		binder.bind("datoPunitorio.diasDePago",
				view.getSpinnerTiempoPago()::getValue,
				f -> view.getSpinnerTiempoPago().setValue(f));
		
		binder.bind("datoPunitorio.isAcumulativo",
				view.getChkbxAcumulativoPunitorio()::isSelected,
				b -> view.getChkbxAcumulativoPunitorio().setSelected((Boolean)b));
		
	}
	
	private void bindAvisos() {
		
		AvisoNotificacion intimacion = new AvisoNotificacion();
		AvisoNotificacion vencimiento = new AvisoNotificacion();
		
		intimacion.setHabilitado(view.getChckbxIntimacion().isSelected());
		vencimiento.setHabilitado(view.getChckbxIntimacion().isSelected());
		
		String intimacionDiasStr = view.getSpinnerIntimacionEmail().getValue().toString();
		String vencimientoMesesStr = view.getSpinnerVencimientoEmail().getValue().toString();
		
		intimacion.setPeriodo(Period.ofDays(Integer.parseInt(intimacionDiasStr)));
		vencimiento.setPeriodo(Period.ofMonths(Integer.parseInt(vencimientoMesesStr)));
		
		currentContrato.setAvisoIntimacion(intimacion);
		currentContrato.setAvisoProxVencer(vencimiento);
		
	}
	
	private void guardaContrato() {
		
		binder.fillBean();
		bindAvisos();
		//if(contratoValidator.isvalid)
		contratoService.saveContratoAlquiler(currentContrato);
		
	}
	
	private void fillCombos() {
		
		this.view.getComboTipoContrato().setModel(tipoCombo);
		tipoCombo.actualize(Arrays.asList(TipoContratoAlquiler.values()));
		
		this.view.getComboMoneda().setModel(monedaCombo);
		monedaCombo.actualize(Arrays.asList(Moneda.values()));
		
	}

	public void setModeNew() {
		
		currentContrato = contratoService.getNewContratoAlquiler();
		binder.setObjective(currentContrato);
		binder.fillFields();
		
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
}
