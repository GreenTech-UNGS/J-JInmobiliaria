package filtros;

import org.joda.time.YearMonth;

public class CuotaFiltro {

	private YearMonth desde;
	private YearMonth hasta;
	
	public CuotaFiltro() {
		
	}

	public YearMonth getDesde() {
		return desde;
	}

	public void setDesde(YearMonth desde) {
		this.desde = desde;
	}

	public YearMonth getHasta() {
		return hasta;
	}

	public void setHasta(YearMonth hasta) {
		this.hasta = hasta;
	}
	
	
	
}
