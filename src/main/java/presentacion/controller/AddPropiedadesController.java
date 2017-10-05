package presentacion.controller;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Moneda;
import entities.Propiedad;
import entities.Provincia;
import entities.TipoOfrecimiento;
import misc.Binder;
import model.LocalidadService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
import presentacion.vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	private AgregarPropiedad view;
	private ProvinciaComboBoxModel provCombo;
	private MonedaComboBoxModel monedaCombo;
	private TipoOfrecimientoComboBoxModel tipoOfrCombo;
	private LocalidadComboBoxModel localidadCombo;
	private PropiedadService propiedadService;
	private PropietarioService propietarioService;
	private LocalidadService localidadService;
	
	Propiedad currentPropiedad;
	Binder<Propiedad> binder;
	
	@Inject
	private AddPropiedadesController(AgregarPropiedad view,
									PropiedadService propiedadService,
									PropietarioService propietarioService,
									LocalidadService localidadService){
		
		this.view = view;
		this.propiedadService = propiedadService;
		this.localidadService = localidadService;
		this.propietarioService = propietarioService;
		this.binder = new Binder<>();
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		
		fillCombos();
		
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

		binder.bind("localidad", localidadCombo::getSelected, t -> localidadCombo.setSelected((Localidad)t));
		
		view.getBtnGuardar().addActionListener(e -> savePropiedad());
		view.getBttAddLoc().addActionListener(e -> agregaLocalidad());
		view.getBttAddPropietario().addActionListener(e -> agregaPropietario());
		view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		
		
	}

	private void fillCombos() {
		
		this.view.getComboProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
		this.view.getComboTipoOfre().setModel(tipoOfrCombo);
		tipoOfrCombo.actualize(Arrays.asList(TipoOfrecimiento.values()));
		
		this.view.getComboMoneda().setModel(monedaCombo);
		monedaCombo.actualize(Arrays.asList(Moneda.values()));
		
		this.view.getComboLocalidad().setModel(localidadCombo);
		AutoCompleteDecorator.decorate(view.getComboLocalidad());
		cambiaLocalidades();
		
	}
	
	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		localidadCombo.actualize(localidadService.getAllOf(provCombo.getSelected()));
		
	}
	
	private void agregaLocalidad() {
		String nombreLoc = JOptionPane.showInputDialog(this.view, "Ingrese nombre de la nueva localidad: ", "Nueva localidad", JOptionPane.INFORMATION_MESSAGE);
		
		localidadService.addNewLocalidad(nombreLoc, provCombo.getSelected());
		
		cambiaLocalidades();
	}
	
	private void agregaPropietario() {
		String propietarioCuit = JOptionPane.showInputDialog(this.view, "Ingrese el cuit del nuevo propietario: ", "Nuevo propietario", JOptionPane.INFORMATION_MESSAGE);
		
		propietarioService.addNewPropietario(propietarioCuit);
	}
	
	private void savePropiedad() {
		binder.fillBean();
		propiedadService.savePropiedad(currentPropiedad);
		view.setVisible(false);
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
