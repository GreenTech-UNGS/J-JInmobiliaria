package entities;

import java.util.List;

public class Persona {
	
	public enum TipoCredencial{
		DNI,
		CUIT
		
	}
	
	private int ID;
	private String credencial;
	private TipoCredencial tipoCred;
	private String nombre;
	private String apellido;
	private String email;
	private List<Telefono> telefonos;
	
	
}
