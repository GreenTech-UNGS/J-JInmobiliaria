package presentacion.controller.filtros;

import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.CuotaFiltro;
import presentacion.vista.filtros.CuotaFiltroView;

@Singleton
public class CuotaFiltroController {

	private CuotaFiltroView view;
	
	private CuotaFiltro currentFiltro;
	
	@Inject
	private CuotaFiltroController(CuotaFiltroView view) {
		this.view = view;
	}
	
	public void setModeNew(){
		
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	public CuotaFiltro getFiltro(){
		CuotaFiltro toRet = new CuotaFiltro();
		
		toRet.setDesde(YearMonth.parse("2017-10"));
		toRet.setHasta(YearMonth.parse("2018-03"));
		
		return toRet;
		
		
	}
	
}
