package presentacion.controller.filtros;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.vista.filtros.CuotaFiltroView;

@Singleton
public class CuotaFiltroController {

	private CuotaFiltroView view;
	
	@Inject
	private CuotaFiltroController(CuotaFiltroView view) {
		this.view = view;
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
}
