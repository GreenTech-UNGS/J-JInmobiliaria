package dto;

public class PropietariosDTO {

	String Nombre;
	String Apellido;
	String Email;
	String CredencialStr;
	String TipoCredencial;
	String Telefonos;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCredencialStr() {
		return CredencialStr;
	}

	public void setCredencialStr(String credencialStr) {
		CredencialStr = credencialStr;
	}

	public String getTipoCredencial() {
		return TipoCredencial;
	}

	public void setTipoCredencial(String tipoCredencial) {
		TipoCredencial = tipoCredencial;
	}


	public String getTelefonos() {
		return Telefonos;
	}

	public void setTelefonos(String telefonos) {
		Telefonos = telefonos;
	}



}
