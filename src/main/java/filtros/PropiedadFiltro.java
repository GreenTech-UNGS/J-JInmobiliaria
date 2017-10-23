package filtros;

import entities.Localidad;
import entities.Moneda;
import entities.Precio;

public class PropiedadFiltro {
	Precio precioDesde;
	Precio precioHasta;
	Localidad localidad;
	
	public PropiedadFiltro(){
		
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Precio getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(Precio precioDesde) {
		this.precioDesde = precioDesde;
	}

	public Precio getPrecioHasta() {
		return precioHasta;
	}

	public void setPrecioHasta(Precio precioHasta) {
		this.precioHasta = precioHasta;
	}
	
	
}
