package presentacion.controller.filtros;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.UsuarioFiltro;
import presentacion.mappers.UsuarioFiltroMapper;
import presentacion.vista.filtros.UsuarioFiltroView;

@Singleton
public class UsuarioFiltroController {
	
	UsuarioFiltroView view;
	UsuarioFiltro currentFiltro;
	@Inject UsuarioFiltroMapper mapper;
	private boolean wasOkPressed;
	
	@Inject
	private UsuarioFiltroController(UsuarioFiltroView view) {
		this.view = view;
		this.wasOkPressed = false;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
	}
	
	public void setModeNew() {
		view.getTipoComboBox().removeAllElements();
		view.getTipoComboBox().actualize(Arrays.asList(TipoCredencial.values()));
		currentFiltro = new UsuarioFiltro();
		currentFiltro.setTipoCredencial(TipoCredencial.DNI);
		mapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public UsuarioFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		return currentFiltro;
	}

}
