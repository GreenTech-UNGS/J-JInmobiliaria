package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Habitacion;
import entities.PropiedadOtrosDatos;
import entities.TipoPropiedad;
import presentacion.mappers.PropiedadOtrosDatosMapper;
import presentacion.validators.MessageShow;
import presentacion.validators.PropiedadOtrosDatosValidator;
import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosController {

	private PropiedadOtrosDatosForm view;
	
	@Inject HabitacionController habitacionController;
	
	@Inject PropiedadOtrosDatosMapper mapper;
	@Inject PropiedadOtrosDatosValidator validator;
	@Inject MessageShow msgShw;
	
	private boolean okWasPressed;
	private PropiedadOtrosDatos currentDatos;
	
	@Inject
	private PropiedadOtrosDatosController(PropiedadOtrosDatosForm view) {
		
		this.view = view;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		view.getBtnAgergar().addActionListener(e -> agregaHabitacion());
		view.getBtnBorrar().addActionListener(e -> borraHabitacion());
		
		fillCombo();
		
	}

	private void aceptar() {
		if(validator.isValid()) {
			okWasPressed = true;
			this.view.setVisible(false);
		}
		else {
			msgShw.showErrorMessage(validator.getErrorMessage(), "Error");
		}
	
	}
	

	private void agregaHabitacion() {
		habitacionController.setModeNew();
		habitacionController.showView();
		
		Habitacion habitacion = habitacionController.getHabitacion();
		
		if(habitacion != null) {
			view.getTableModel().addRow(habitacion);
			currentDatos.getHabitaciones().add(habitacion);
		}
	}
	
	private void borraHabitacion() {
		
		int selectedRow = view.getTable().getSelectedRow();
		
		if(selectedRow >= 0) {
			view.getTableModel().removeRow(selectedRow);
			currentDatos.getHabitaciones().remove(selectedRow);
			fillTable();
		}
		
	}
	
	private void fillTable() {
		view.getTableModel().clean();
		view.getTableModel().actualizeRows(currentDatos.getHabitaciones());
	}

	private void fillCombo() {
		this.view.getTipoCombo().removeAllElements();
		this.view.getTipoCombo().actualize(Arrays.asList(TipoPropiedad.values()));
	}
	
	public void setModeNew() {
		okWasPressed = false;
		currentDatos = new PropiedadOtrosDatos();
		currentDatos.setTipo(TipoPropiedad.Otro);
		
		mapper.fillFields(currentDatos);
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public PropiedadOtrosDatos getOtrosDatos() {
		if(!okWasPressed)
			return null;
			
		mapper.fillBean(currentDatos);
		
		return currentDatos;
	}
	
}
