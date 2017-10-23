package filtros;

import entities.Localidad;
import entities.Moneda;
import entities.Precio;
import entities.TipoOfrecimiento;

public class PropiedadFiltro {
	double precioDesde;
	double precioHasta;
	Moneda moneda;
	Localidad localidad;
	TipoOfrecimiento tipoOfrecimiento;
	
	public PropiedadFiltro(){
		
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
	
	
}
