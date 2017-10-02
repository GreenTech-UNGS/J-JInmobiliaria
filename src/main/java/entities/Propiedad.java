package entities;

import java.util.List;
import java.util.Set;

public class Propiedad {

	private int ID;
	private String identificador;
	private String calle;
	private int altura;
	private int piso;
	private int dpto;
	private String obsPublicas;
	private String obsPrivadas;
	
	private HistoriaEstadoProp estado;
	private List<Foto> fotos;
	private Set<TipoOfrecimiento> tiposOfrecimiento;
	private Precio precioTentativo;
	private Localidad localidad;
	private Inmobiliaria inmobiliaria;
	private Propietario propietario;
	
}
