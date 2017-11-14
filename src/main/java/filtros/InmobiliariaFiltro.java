package filtros;

import entities.Localidad;

public class InmobiliariaFiltro {
	
	String cuit;
	String nombre;
	Localidad localidad;
	
	public InmobiliariaFiltro(){
		
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
}
