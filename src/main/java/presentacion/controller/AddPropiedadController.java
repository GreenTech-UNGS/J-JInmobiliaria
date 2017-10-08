package presentacion.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Moneda;
import entities.Propiedad;
import entities.Propietario;
import entities.Provincia;
import entities.TipoOfrecimiento;
import misc.Binder;
import model.LocalidadService;
import model.LocalizationService;
import model.PropiedadService;
import model.PropietarioService;
import persistencia.dao.iface.LocalizationDao.MapPoint;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
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
//	private PropietarioService propietarioService;
	private LocalidadService localidadService;
	private ElegirPropietarioController elegirPropController;
	private HistorialPropiedadController historialPropController;
	private LocalizationService localizationService;
		
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
									ElegirPropietarioController elegirPropController,
									HistorialPropiedadController historialPropController,
									LocalizationService localizationService){
		
		this.view = view;
		this.propiedadValidator = propiedadValidator;
		this.propiedadService = propiedadService;
		this.localidadService = localidadService;
//		this.propietarioService = propietarioService;
		this.binder = new Binder<>();
		this.elegirPropController = elegirPropController;
		this.historialPropController = historialPropController;
		this.localizationService = localizationService;
		
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
		view.getBtnCancelar().addActionListener(e -> view.setVisible(false));
		view.getBtnVerHistorial().addActionListener(e -> this.historialPropController.showView());
		view.getBtnActualizar().addActionListener(e -> actualizaMapa());
		
		
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
	
	private void actualizaMapa() {
		
		String calle = view.getTfCalle().getText();
		String altura = view.getTfAltura().getText();
		Localidad localidad = localidadCombo.getSelected();
		
		if(calle == null || altura == null || localidad == null || localidad.getNombre() == null) {
			JOptionPane.showMessageDialog(view, "No se puede actualizar el mapa, faltan datos de ubcación", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		
		MapPoint punto = localizationService.getLocalizationOf(calle, altura, localidad);
	
		Coordinate localizacion = new Coordinate(punto.getLat(), punto.getLon());
		
		view.getMapa().addMapMarker(new MapMarkerDot(localizacion));
		view.getMapa().setDisplayPosition(localizacion, 16);
	
	}
	
	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
		localidadCombo.actualize(localidades);
		localidadCombo.setSelected(localidades.get(0));
		
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

		view.setTitle("Detalle de propiedad");

		currentPropiedad = propiedad;
		binder.setObjective(currentPropiedad);
		binder.fillFields();
	}

	public void showView(){
			
			view.setVisible(true);
	}
	
	public void setEnabled(boolean bool){
		
		view.getTfAltura().setEditable(bool);
		view.getTfCalle().setEditable(bool);
		view.getTfPrecio().setEditable(bool);
		view.getTfIdentificador().setEditable(bool);
		view.getTfEntrecalles().setEditable(bool);
		view.getTfPiso().setEditable(bool);
		view.getTfDepto().setEditable(bool);
		view.getTfPropietario().setEditable(bool);
		view.getTaDescPubl().setEditable(bool);
		view.getTaDescPriv().setEditable(bool);
		view.getBtnGuardar().setVisible(bool);
		view.getBtnCancelar().setVisible(bool);
		view.getBtnLupita().setVisible(bool);
		view.getBttAddLoc().setVisible(bool);
		view.getBtnVerHistorial().setVisible(!bool);	
	}

}
