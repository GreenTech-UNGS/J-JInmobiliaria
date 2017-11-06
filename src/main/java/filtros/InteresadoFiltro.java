package filtros;

import entities.Persona.TipoCredencial;

public class InteresadoFiltro {
	
	String nombre;
	String apellido;
	String credencial;
	TipoCredencial tipoCredencial;
	
	public InteresadoFiltro(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public TipoCredencial getTipoCredencial() {
		return tipoCredencial;
	}

	public void setTipoCredencial(TipoCredencial tipoCredencial) {
		this.tipoCredencial = tipoCredencial;
	}
	
	

}
