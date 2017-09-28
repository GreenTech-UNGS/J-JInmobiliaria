package entities;

public class Telefono {
	
	public enum Tipo{
		CELULAR,
		CASA,
		TRABAJO,
		OTRO
	}
	
	private int ID;
	private long numero;
	private Tipo tipo;
	private String notas;
	
}
