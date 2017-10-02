package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "propiedades")
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ID;
	private String identificador;
	private String calle;
	private int altura;
	private int piso;
	private int dpto;
	private String obsPublicas;
	private String obsPrivadas;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private List<HistoriaEstadoProp> estados;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Foto> fotos;
	
	@Column(nullable = true, insertable = true, updatable = true)
	@ElementCollection
	@Enumerated(EnumType.ORDINAL)
	private Set<TipoOfrecimiento> tiposOfrecimiento;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Precio precioTentativo;
	
	@OneToOne(cascade = {CascadeType.MERGE})//TODO: podriamos ponerle persist
	private Localidad localidad;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Inmobiliaria inmobiliaria;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Propietario propietario;
	
	public Propiedad() {
		this.fotos = new ArrayList<>();
		this.estados = new ArrayList<>();
		this.tiposOfrecimiento = new HashSet<>();
	}
	
}
