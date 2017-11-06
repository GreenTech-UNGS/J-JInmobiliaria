package presentacion.controller;


import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.GastoFijo;
import model.GastoFijoService;
import model.LogicaNegocioException;
import presentacion.mappers.GastoFijoMapper;
import presentacion.validators.MessageShow;
import presentacion.vista.GastoFijoForm;

@Singleton
public class GastoFijoController {

	private GastoFijoForm view;
		
	@Inject GastoFijoMapper mapper;
	
	private GastoFijoService gastoFijoService;
	private GastoFijo currentGastoFijo;
	private MessageShow msgShw;
	private boolean okWasPressed;
	
	@Inject
	private GastoFijoController(GastoFijoForm view,
			GastoFijoService gastoFijoService,
			MessageShow msgShw) {
		this.view = view;
		this.gastoFijoService = gastoFijoService;
		this.msgShw = msgShw;
		this.view.getBtnAceptar().addActionListener(e -> saveCurrentGastoFijo());

	}
	
	private void saveCurrentGastoFijo() {
		
		if(currentGastoFijo.getMonto() > 0) { // Falta validator
			mapper.fillBean(currentGastoFijo);
			try {
				gastoFijoService.saveGastoFijo(currentGastoFijo);
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

		view.getTextNombre().setEditable(true);
		view.getTextDescripcion().setEditable(true);
	}

	public void editarGastoFijo(GastoFijo c){
		view.setTitle("Editar gasto fijo");
		view.getBtnAceptar().setVisible(true);
		
		currentGastoFijo = c;
		mapper.fillFields(c);
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public GastoFijo getGastoFijo() {
		
		if(!okWasPressed)
			return null;
		
		mapper.fillBean(currentGastoFijo);
		
		return currentGastoFijo;
		
	}

	public void setModeNew() {
		okWasPressed = false;
		currentGastoFijo = gastoFijoService.getEmptyGastoFijo();		
		mapper.fillFields(currentGastoFijo);
		
	}
		
}
