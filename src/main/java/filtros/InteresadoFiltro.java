package filtros;

import entities.Localidad;
import entities.Moneda;
import entities.TipoOfrecimiento;

public class InteresadoFiltro {
	double precioDesde;
	double precioHasta;
	Moneda moneda;
	Localidad localidad;
	TipoOfrecimiento tipoOfrecimiento;
	int metros;
	int ambientes;
	
	public InteresadoFiltro(){
		
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public double getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(double precioDesde) {
		this.precioDesde = precioDesde;
	}

	public double getPrecioHasta() {
		return precioHasta;
	}

	public void setPrecioHasta(double precioHasta) {
		this.precioHasta = precioHasta;
	}

	public TipoOfrecimiento getTipoOfrecimiento() {
		return tipoOfrecimiento;
	}

	public void setTipoOfrecimiento(TipoOfrecimiento tipoOfrecimiento) {
		this.tipoOfrecimiento = tipoOfrecimiento;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

	public int getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(int ambientes) {
		this.ambientes = ambientes;
	}
}
