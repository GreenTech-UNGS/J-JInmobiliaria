package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cartel;
import entities.Cliente;
import model.CartelService;
import model.LogicaNegocioException;
import presentacion.mappers.CartelMapper;
import presentacion.validators.MessageShow;
import presentacion.vista.CartelForm;

@Singleton
public class CartelController {

	private CartelForm view;
	
	@Inject CartelMapper mapper;
	
	private CartelService cartelService;
	private Cartel currentCartel;
	private MessageShow msgShw;
	private boolean okWasPressed;
	
	@Inject
	private CartelController(CartelForm view,
			CartelService cartelService,
			MessageShow msgShw) {
		this.view = view;
		this.cartelService = cartelService;
		this.msgShw = msgShw;
		this.view.getBtnAceptar().addActionListener(e -> saveCurrentCartel());

	}
	
	private void saveCurrentCartel() {
		
		if(currentCartel.getAlto() <= 0 || currentCartel.getAncho() <= 0 || currentCartel.getMonto() <= 0) { // Falta validator
			mapper.fillBean(currentCartel);
			try {
				cartelService.saveCartel(currentCartel);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage("Los datos no son correctos", "Error");
		}
	}
	
	private void setEditCampos(boolean b) {

		view.getTextIdentificador().setEditable(true);
		view.getTextDescripcion().setEditable(true);
	}

	public void editarCartel(Cartel c){
		view.setTitle("Editar cartel");
		view.getBtnAceptar().setVisible(true);
		
		currentCartel = c;
		mapper.fillFields(c);
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public Cartel getCartel() {
		
		if(!okWasPressed)
			return null;
		
		mapper.fillBean(currentCartel);
		
		return currentCartel;
		
	}

	public void setModeNew() {
		okWasPressed = false;
		view.setTitle("Nuevo cartel");
		currentCartel = cartelService.getEmptyCartel();		
		mapper.fillFields(currentCartel);
		
	}
		
}
