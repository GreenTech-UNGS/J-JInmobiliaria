package presentacion.mappers;

import org.joda.time.YearMonth;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import filtros.CuotaFiltro;
import presentacion.vista.filtros.CuotaFiltroView;

@Singleton
public class CuotaFiltroMapper implements Mapper<CuotaFiltro>{

	private CuotaFiltroView view;
	
	@Inject
	private CuotaFiltroMapper(CuotaFiltroView view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(CuotaFiltro t) {
		
		int anioDesde = view.getDesdeAnio().getValue();
		int mesDesde = view.getDesdeMes().getMonth() + 1;
		
		int anioHasta = view.getHastaAnio().getValue();
		int mesHasta = view.getHastaMes().getMonth() + 1;
		
		YearMonth desde = new YearMonth(anioDesde, mesDesde);
		YearMonth hasta = new YearMonth(anioHasta, mesHasta);
		
		t.setDesde(desde);
		t.setHasta(hasta);
		
	}

	@Override
	public void fillFields(CuotaFiltro t) {
		// TODO Auto-generated method stub
		
	}

}
