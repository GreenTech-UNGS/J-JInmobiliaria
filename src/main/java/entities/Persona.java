package entities;

import java.util.List;

public class Persona extends PersonaBasica{
	
	public enum TipoCredencial{
		DNI,
		CUIT
		
	}
	
	
	private String credencial;
	private TipoCredencial tipoCred;
	
}
