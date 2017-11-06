package presentacion.controller.filtros;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.ClienteFiltro;
import presentacion.mappers.ClienteFiltroMapper;
import presentacion.vista.filtros.ClienteFiltroView;

@Singleton
public class ClienteFiltroController {

	private ClienteFiltroView view;
	
	@Inject private ClienteFiltroMapper mapper;
	
	private ClienteFiltro currentFiltro;
	private boolean wasOkPressed;
	
	@Inject
	private ClienteFiltroController(ClienteFiltroView view) {
		this.view = view;
		wasOkPressed = false;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		view.getBtnCancelar().addActionListener(e -> view.setVisible(false));
		
	}
	
	private void aceptar() {
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void setModeNew() {
		view.getTipoComboBox().removeAllElements();
		view.getTipoComboBox().actualize(Arrays.asList(TipoCredencial.values()));
		currentFiltro = new ClienteFiltro();
		currentFiltro.setTipoCredencial(TipoCredencial.DNI);
		mapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public ClienteFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		return currentFiltro;
	}
	
}
