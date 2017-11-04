package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "propiedades")
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String identificador;
	private String calle;
	private String altura;
	private String piso;
	private String dpto;
	private String obsPublicas;
	private String obsPrivadas;
	
	private double lat;
	private double lon;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropiedadOtrosDatos otrosDatos;
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@OneToMany(cascade = {CascadeType.ALL})
	private List<HistoriaEstadoProp> estados;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Foto> fotos;
	
	@Column(nullable = true, insertable = true, updatable = true)

	@Enumerated(EnumType.ORDINAL)
	private TipoOfrecimiento tipoOfrecimiento;
	
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
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public Precio getPrecioTentativo() {
		return precioTentativo;
	}

	public void setPrecioTentativo(Precio precioTentativo) {
		this.precioTentativo = precioTentativo;
	}

	public String getObsPublicas() {
		return obsPublicas;
	}

	public void setObsPublicas(String obsPublicas) {
		this.obsPublicas = obsPublicas;
	}

	public String getObsPrivadas() {
		return obsPrivadas;
	}

	public void setObsPrivadas(String obsPrivadas) {
		this.obsPrivadas = obsPrivadas;
	}

	public List<HistoriaEstadoProp> getEstados() {
		return estados;
	}

	public void setEstados(List<HistoriaEstadoProp> estados) {
		this.estados = estados;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public TipoOfrecimiento getTipoOfrecimiento() {
		return tipoOfrecimiento;
	}

	public void setTipoOfrecimiento(TipoOfrecimiento tipoOfrecimiento) {
		this.tipoOfrecimiento = tipoOfrecimiento;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public int getID() {
		return ID;
	}

	public PropiedadOtrosDatos getOtrosDatos() {
		return otrosDatos;
	}

	public void setOtrosDatos(PropiedadOtrosDatos otrosDatos) {
		this.otrosDatos = otrosDatos;
	}	
}
