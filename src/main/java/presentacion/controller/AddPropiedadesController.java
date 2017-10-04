package presentacion.controller;

import java.util.Arrays;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Moneda;
import entities.Propiedad;
import entities.Provincia;
import entities.TipoOfrecimiento;
import misc.Binder;
import model.PropiedadService;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
import presentacion.vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	private AgregarPropiedad view;
	private ProvinciaComboBoxModel provCombo;
	private MonedaComboBoxModel monedaCombo;
	private TipoOfrecimientoComboBoxModel tipoOfrCombo;
	private PropiedadService propiedadService;
	
	Propiedad currentPropiedad;
	Binder<Propiedad> binder;
	
	@Inject
	private AddPropiedadesController(AgregarPropiedad view,
									PropiedadService propiedadService){
		
		this.view = view;
		this.propiedadService = propiedadService;
		this.binder = new Binder<>();
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		
		binder.bind("identificador", view.getTfIdentificador()::getText, t -> view.getTfIdentificador().setText((String)t));
		
		binder.bind("calle", view.getTfCalle()::getText, t -> view.getTfCalle().setText((String)t));
		
		binder.bind("altura", () -> Integer.parseInt(view.getTfAltura().getText()),
				t -> view.getTfAltura().setText(t.toString()));
		
		binder.bind("piso", () -> Integer.parseInt(view.getTfPiso().getText()),
				t -> view.getTfPiso().setText(t.toString()));
		
		binder.bind("dpto", () -> Integer.parseInt(view.getTfDepto().getText()),
				t -> view.getTfDepto().setText(t.toString()));
		
		binder.bind("obsPublicas", view.getTaDescPubl()::getText, t -> view.getTaDescPubl().setText((String)t));
		
		binder.bind("obsPrivadas", view.getTaDescPriv()::getText, t -> view.getTaDescPriv().setText((String)t));
		
		binder.bind("precioTentativo.moneda", monedaCombo::getSelected, t -> monedaCombo.setSelected((Moneda)t));
		
		binder.bind("precioTentativo.monto", () -> Float.parseFloat(view.getTfPrecio().getText()),
				t -> view.getTfPrecio().setText(t.toString()));

		binder.bind("tipoOfrecimiento", tipoOfrCombo::getSelected, t -> tipoOfrCombo.setSelected((TipoOfrecimiento)t));
		
		view.getBtnGuardar().addActionListener(e -> savePropiedad());
		
		fillCombos();
	}


	private void fillCombos() {
		
		this.view.getComboProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		this.view.getComboTipoOfre().setModel(tipoOfrCombo);
		tipoOfrCombo.actualize(Arrays.asList(TipoOfrecimiento.values()));
		
		this.view.getComboMoneda().setModel(monedaCombo);
		monedaCombo.actualize(Arrays.asList(Moneda.values()));
		
	}
	
	private void savePropiedad() {
		binder.fillBean();
		propiedadService.savePropiedad(currentPropiedad);
	}
	
	public void setModeNew() {
		currentPropiedad = propiedadService.getEmptyPropiedad();
		binder.setObjective(currentPropiedad);
		binder.fillFields();
	}

	public void showView(){
			
			view.setVisible(true);
	}

}
