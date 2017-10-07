package presentacion.controller;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Moneda;
import entities.Propiedad;
import entities.Propietario;
import entities.Provincia;
import entities.TipoOfrecimiento;
import misc.Binder;
import model.LocalidadService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
import presentacion.validators.PropiedadValidator;
import presentacion.vista.AgregarPropiedad;

public class AddPropiedadController {
	
	private AgregarPropiedad view;
	private ProvinciaComboBoxModel provCombo;
	private MonedaComboBoxModel monedaCombo;
	private TipoOfrecimientoComboBoxModel tipoOfrCombo;
	private LocalidadComboBoxModel localidadCombo;
	private PropiedadValidator propiedadValidator;
	private PropiedadService propiedadService;
	private PropietarioService propietarioService;
	private LocalidadService localidadService;
	private ElegirPropietarioController elegirPropController;
		
	Propiedad currentPropiedad;
	Propietario currentPropietario;
	Binder<Propiedad> binder;
	Binder<Propiedad> binderP;
	
	@Inject
	private AddPropiedadController(AgregarPropiedad view,
									PropiedadValidator propiedadValidator,
									PropiedadService propiedadService,
									PropietarioService propietarioService,
									LocalidadService localidadService,
									ElegirPropietarioController elegirPropController){
		
		this.view = view;
		this.propiedadValidator = propiedadValidator;
		this.propiedadService = propiedadService;
		this.localidadService = localidadService;
		this.propietarioService = propietarioService;
		this.binder = new Binder<>();
		this.elegirPropController = elegirPropController;
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();

		fillCombos();
		
		initBinder();
		
		
		view.getBtnGuardar().addActionListener(e -> savePropiedad());
		view.getBttAddLoc().addActionListener(e -> agregaLocalidad());
		view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		view.getBtnLupita().addActionListener(e -> selectPropietario());
		
		
	}
	
	private void initBinder() {
		binder.bind("identificador",
				view.getTfIdentificador()::getText,
				t -> view.getTfIdentificador().setText((String)t));
		
		binder.bind("calle",
				view.getTfCalle()::getText,
				t -> view.getTfCalle().setText((String)t));
		
		binder.bind("altura", () -> view.getTfAltura().getText(),
				t -> view.getTfAltura().setText((String)t));
		
		binder.bind("piso", () -> view.getTfPiso().getText(),
				t -> view.getTfPiso().setText((String)t));
		
		binder.bind("dpto", () -> view.getTfDepto().getText(),
				t -> view.getTfDepto().setText((String)t));
		
		binder.bind("obsPublicas",
				view.getTaDescPubl()::getText,
				t -> view.getTaDescPubl().setText((String)t));
		
		binder.bind("obsPrivadas",
				view.getTaDescPriv()::getText,
				t -> view.getTaDescPriv().setText((String)t));
		
		binder.bind("precioTentativo.moneda",
				monedaCombo::getSelected,
				t -> monedaCombo.setSelected((Moneda)t));
		
		binder.bind("precioTentativo.monto",
				() -> Float.parseFloat(view.getTfPrecio().getText()),
				t -> view.getTfPrecio().setText(t.toString()));

		binder.bind("tipoOfrecimiento",
				tipoOfrCombo::getSelected,
				t -> tipoOfrCombo.setSelected((TipoOfrecimiento)t));

		binder.bind("localidad",
				localidadCombo::getSelected,
				t -> localidadCombo.setSelected((Localidad)t));
	}

	private void selectPropietario() {
		this.elegirPropController.showView();
		Propietario prop = elegirPropController.getPropietario();
		
		if(prop != null) {
			currentPropietario = elegirPropController.getPropietario();
			currentPropiedad.setPropietario(currentPropietario);
			
			view.getTfPropietario().setText(currentPropietario.getPersona().getTipoCred() + " " +currentPropietario.getPersona().getCredencial());
		}
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
	
	private void savePropiedad() {
		
		binder.fillBean();
		if(propiedadValidator.isValid(currentPropiedad)){		
			
			propiedadService.savePropiedad(currentPropiedad);
			view.setVisible(false);
		}
	}
	
	public void setModeNew() {
		view.setTitle("Agregar Propiedad");

		currentPropiedad = propiedadService.getEmptyPropiedad();
		binder.setObjective(currentPropiedad);
		binder.fillFields();
		
		view.getTfPropietario().setText("");
	}

	public void setModeView(Propiedad propiedad) {

		view.setTitle("Detalle Propiedad");

		currentPropiedad = propiedad;
		binder.setObjective(currentPropiedad);
		binder.fillFields();
	}

	public void showView(){
			
			view.setVisible(true);
	}
	public void setNotEnabled(){
		this.view.getTfAltura().setEditable(false);
		view.getTfCalle().setEditable(false);
		view.getTfPrecio().setEditable(false);
		view.getTfIdentificador().setEditable(false);
		view.getTfEntrecalles().setEditable(false);
		view.getTfPiso().setEditable(false);
		view.getTfDepto().setEditable(false);
		view.getTfPropietario().setEditable(false);
		view.getComboProvincia().setEditable(false);
		view.getComboMoneda().setEditable(false);
		view.getComboTipoOfre().setEditable(false);
		view.getComboLocalidad().setEditable(false);
		view.getTaDescPubl().setEditable(false);
		view.getTaDescPriv().setEditable(false);
		view.getBtnGuardar().setVisible(false);
		view.getBtnCancelar().setVisible(false);
		view.getBtnLupita().setVisible(false);
		view.getBttAddLoc().setVisible(false);
		view.getBtnVerHistorial().setVisible(true);	
	}

}
