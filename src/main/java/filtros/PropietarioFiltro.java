package filtros;

import entities.Persona.TipoCredencial;

public class PropietarioFiltro {
	
	String nombre;
	String apellido;
	String credencial;
	TipoCredencial tipoCredencial;
	
	public PropietarioFiltro() {
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCredencial() {
		return credencial;
	}

	public TipoCredencial getTipoCredencial() {
		return tipoCredencial;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public void setTipoCredencial(TipoCredencial tipoCredencial) {
		this.tipoCredencial = tipoCredencial;
	}
	
}
