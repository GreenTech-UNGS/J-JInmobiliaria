package presentacion.controller.filtros;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.InteresadoFiltro;
import presentacion.mappers.InteresadoFiltroMapper;
import presentacion.vista.filtros.InteresadoFiltroView;

@Singleton
public class InteresadoFiltroController {
	
	private InteresadoFiltroView view;
	
	@Inject InteresadoFiltroMapper interesadoMapper;
	
	private InteresadoFiltro currentFiltro;
	private boolean wasOkPressed;
	
	@Inject
	private InteresadoFiltroController(InteresadoFiltroView view){
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
		currentFiltro = new InteresadoFiltro();
		currentFiltro.setTipoCredencial(TipoCredencial.DNI);
		interesadoMapper.fillFields(currentFiltro);
		wasOkPressed = false;
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public InteresadoFiltro getFiltro() {
		
		if(!wasOkPressed)
			return null;
		
		interesadoMapper.fillBean(currentFiltro);
		return currentFiltro;
	}

}
