package presentacion.controller.filtros;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.PropietarioFiltro;
import presentacion.mappers.PropietarioFiltroMapper;
import presentacion.vista.filtros.PropietarioFiltroView;

@Singleton
public class PropietarioFiltroController {

	private PropietarioFiltroView view;
	
	@Inject private PropietarioFiltroMapper mapper;
	
	private PropietarioFiltro currentFiltro;
	private boolean wasOkPressed;
	
	@Inject
	private PropietarioFiltroController(PropietarioFiltroView view) {
		this.view = view;
		wasOkPressed = false;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		
	}
	
	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void setModeNew() {
		view.getTipoComboBox().removeAllElements();
		view.getTipoComboBox().actualize(Arrays.asList(TipoCredencial.values()));
		currentFiltro = new PropietarioFiltro();
		mapper.fillFields(currentFiltro);
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public PropietarioFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		return currentFiltro;
	}
	
}
