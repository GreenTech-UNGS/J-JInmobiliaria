package presentacion.controller;

import com.google.inject.Inject;
import entities.*;
import misc.Binder;
import model.LocalidadService;
import model.LocalizationService;
import model.LogicaNegocioException;
import model.PropiedadService;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import persistencia.dao.iface.LocalizationDao.MapPoint;
import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;
import presentacion.validators.MessageShow;
import presentacion.validators.PropiedadFormValidator;
import presentacion.vista.PropiedadForm;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class PropiedadController {
	
	private PropiedadForm view;
	private ProvinciaComboBoxModel provCombo;
	private MonedaComboBoxModel monedaCombo;
	private TipoOfrecimientoComboBoxModel tipoOfrCombo;
	private LocalidadComboBoxModel localidadCombo;
	private PropiedadFormValidator propiedadValidator;
	private PropiedadService propiedadService;
	private LocalidadService localidadService;
	private ElegirPropietarioController elegirPropController;
	private ElegirInmobiliariaController elegirInmobController;
	private HistorialPropiedadController historialPropController;
	private LocalizationService localizationService;
	
	@Inject private PropiedadOtrosDatosController otrosDatosForm;
	
	private final Coordinate centerOfMap = new Coordinate(50.064191736659104, 8.96484375);
		
	Propiedad currentPropiedad;
	Propietario currentPropietario;
	Inmobiliaria currentInmobiliaria;
	Binder<Propiedad> binder;
	
	MessageShow msgShw;
	
	@Inject
	private PropiedadController(PropiedadForm view,
									PropiedadFormValidator propiedadValidator,
									PropiedadService propiedadService,
									LocalidadService localidadService,
									ElegirPropietarioController elegirPropController,
									ElegirInmobiliariaController elegirInmobController,
									HistorialPropiedadController historialPropController,
									LocalizationService localizationService,
									MessageShow msgShw){
		
		this.view = view;
		this.propiedadValidator = propiedadValidator;
		this.propiedadService = propiedadService;
		this.localidadService = localidadService;
		this.binder = new Binder<>();
		this.elegirPropController = elegirPropController;
		this.elegirInmobController = elegirInmobController;
		this.historialPropController = historialPropController;
		this.localizationService = localizationService;
		this.msgShw = msgShw;
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();

		fillCombos();
		initBinder();
		
		view.getComboProvincia().addActionListener(e -> cambiaLocalidades());
		view.getBtnLupita().addActionListener(e -> selectPropietario());
		view.getBtnCancelar().addActionListener(e -> view.setVisible(false));
		view.getBtnVerHistorial().addActionListener(e -> this.historialPropController.showView(currentPropiedad));
		view.getBtnActualizar().addActionListener(e -> actualizaMapa());
		view.getBotonLupitaInmobiliaria().addActionListener(e -> selectInmobiliaria());
		view.getBtnGuardarDisponible().addActionListener(e -> savePropiedad());
		view.getBtnMasDatos().addActionListener(e -> agregarOtrosDatos());
		view.getBtnBorrador().addActionListener(e -> saveBorrador());
		
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
				() -> Double.parseDouble((view.getTfPrecio().getText())),
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
			
			view.getTfPropietario().setText(currentPropietario.getPersona().getNombre() + " " +
			currentPropietario.getPersona().getApellido());
		}
	}
	

	private void selectInmobiliaria() {
		this.elegirInmobController.showView();
		
		Inmobiliaria inmob = elegirInmobController.getInmobiliaria();
		
		if(inmob !=null){
			currentInmobiliaria = elegirInmobController.getInmobiliaria();
			view.getTfInmobiliaria().setText(currentInmobiliaria.getNombre());
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

		Thread t = new Thread(() -> actualizaMapaThread());
		t.start();
	}
	
	private void actualizaMapaThread() {
		
		String calle = view.getTfCalle().getText();
		String altura = view.getTfAltura().getText();
		Localidad localidad = localidadCombo.getSelected();
		
		if(calle == null || altura == null || localidad == null || localidad.getNombre() == null) {
			JOptionPane.showMessageDialog(view, "No se puede actualizar el mapa, faltan datos de ubcaci�n", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		MapPoint punto = localizationService.getLocalizationOf(calle, altura, localidad);
	
		if(punto == null) {
			JOptionPane.showMessageDialog(view, "No se encontro la ubicaci�n", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}	
		Coordinate localizacion = new Coordinate(punto.getLat(), punto.getLon());
		restartMapa();
		
		view.getMapa().addMapMarker(new MapMarkerDot(localizacion));
		view.getMapa().setDisplayPosition(localizacion, 15);
		
		currentPropiedad.setLat(punto.getLat());
		currentPropiedad.setLon(punto.getLon());
		
	}
	
	private void actualizaMapaConCoord() {
		
		restartMapa();
		Coordinate localizacion = new Coordinate(currentPropiedad.getLat(), currentPropiedad.getLon());
		view.getMapa().addMapMarker(new MapMarkerDot(localizacion));
		view.getMapa().setDisplayPosition(localizacion, 15);
		
	}
	
	private void restartMapa() {
		
		view.getMapa().removeAllMapMarkers();
		view.getMapa().setDisplayPosition(centerOfMap, 3);
	}
	
	private void cambiaLocalidades() {
		
		localidadCombo.removeAllElements();
		List<Localidad> localidades = localidadService.getAllOf(provCombo.getSelected());
		localidadCombo.actualize(localidades);
		
	}

	public void editPropiedad(Propiedad p){

		view.setTitle("Editar Propiedad");
		view.getBtnGuardarDisponible().setVisible(false);
		view.getBtnCancelar().setVisible(false);
		view.getBtnGuardarDisponible().setVisible(true);
		fillCombos();
		currentPropiedad = p;
		binder.setObjective(currentPropiedad);
		binder.fillFields();
	}

	private void actualizarPropiedad() {
		
		if(propiedadValidator.isValid()){
			binder.fillBean();
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(propiedadValidator.getErrorMessage(), "Error");
		}
	}
	
	private void savePropiedad() {

		if(propiedadValidator.isValid()){
			binder.fillBean();
			actualizaMapaThread();
			try {
				propiedadService.savePropiedad(currentPropiedad);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(propiedadValidator.getErrorMessage(), "Error");
		}
	}
	
	private void saveBorrador() {

		if(propiedadValidator.isValid()){
			binder.fillBean();
			actualizaMapaThread();
			try {
				propiedadService.savePropiedadBorrador(currentPropiedad);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(propiedadValidator.getErrorMessage(), "Error");
		}
	}
	
	private void agregarOtrosDatos() {
		otrosDatosForm.setModeNew();
		otrosDatosForm.showView();
		PropiedadOtrosDatos otrosDatos = otrosDatosForm.getOtrosDatos();
		
		if(otrosDatos != null)currentPropiedad.setOtrosDatos(otrosDatos);
		
	}
	
	public void setModeNew() {
		
		view.setTitle("Agregar Propiedad");
		currentPropiedad = propiedadService.getEmptyPropiedad();
		binder.setObjective(currentPropiedad);
		binder.fillFields();
		
		setEnabled(true);
		restartMapa();
		view.getTfPropietario().setText("");
		view.getTfInmobiliaria().setText("");
		view.getLblReservada().setVisible(false);
	}

	public void setModeView(Propiedad propiedad) {

		view.setTitle("Detalle de propiedad");

		currentPropiedad = propiedad;
		binder.setObjective(currentPropiedad);
		setEnabled(false);
		actualizaMapaConCoord();
		binder.fillFields();
		view.getTfPropietario().setText(currentPropiedad.getPropietario().getPersona().getTipoCred().toString() + " " +
										currentPropiedad.getPropietario().getPersona().getCredencial());
		if(currentPropiedad.getInmobiliaria()!=null)
			view.getTfInmobiliaria().setText(currentPropiedad.getInmobiliaria().getCUIT());
		
		if(propiedadService.getCurrentEstado(currentPropiedad).equals(EstadoProp.RESERVADA))
			view.getLblReservada().setVisible(true);
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
		view.getTaDescPubl().setEditable(bool);
		view.getTaDescPriv().setEditable(bool);
		view.getBtnGuardarDisponible().setVisible(bool);
		view.getBtnCancelar().setVisible(bool);
		view.getBtnLupita().setVisible(bool);
		view.getBtnVerHistorial().setVisible(!bool);
		view.getBtnVerHistorial().setVisible(!bool);	
		view.getBtnActualizar().setVisible(bool);
		view.getBotonLupitaInmobiliaria().setVisible(bool);
		view.getComboLocalidad().setEnabled(bool);
		view.getComboMoneda().setEnabled(bool);
		view.getComboProvincia().setEnabled(bool);
		view.getComboTipoOfre().setEnabled(bool);
		view.getBtnGuardarDisponible().setVisible(false);
	}
}
