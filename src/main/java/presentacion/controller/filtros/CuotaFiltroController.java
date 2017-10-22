package presentacion.controller.filtros;

import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.CuotaFiltro;
import presentacion.mappers.CuotaFiltroMapper;
import presentacion.vista.filtros.CuotaFiltroView;

@Singleton
public class CuotaFiltroController {

	private CuotaFiltroView view;
	
	@Inject private CuotaFiltroMapper mapper;
	
	private CuotaFiltro currentFiltro;
	private boolean wasOkPressed;
	
	@Inject
	private CuotaFiltroController(CuotaFiltroView view) {
		this.view = view;
		wasOkPressed = false;
		
		view.getBtnAceptar().addActionListener(e -> aceptar());
		
	}
	
	private void aceptar(){
		wasOkPressed = true;
		view.setVisible(false);
	}
	
	public void setModeNew(){
		wasOkPressed = false;
		currentFiltro = new CuotaFiltro();
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	public CuotaFiltro getFiltro(){
		
		if(!wasOkPressed)
			return null;
		
		mapper.fillBean(currentFiltro);
		
		return currentFiltro;
		
		
	}
	
}
