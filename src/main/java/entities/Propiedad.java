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
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<HistoriaEstadoProp> estados;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Foto> fotos;
	
	@OneToOne(cascade = {CascadeType.MERGE})//TODO: podriamos ponerle persist
	private Localidad localidad;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Inmobiliaria inmobiliaria;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Propietario propietario;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private OfrecimientoAlquiler ofrecimientoAlquiler;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private OfrecimientoVenta ofrecimientoVenta;
	
	public Propiedad() {
		this.fotos = new ArrayList<>();
		this.estados = new ArrayList<>();
	}	
	
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

	public OfrecimientoAlquiler getOfrecimientoAlquiler() {
		return ofrecimientoAlquiler;
	}

	public void setOfrecimientoAlquiler(OfrecimientoAlquiler ofrecimientoAlquiler) {
		this.ofrecimientoAlquiler = ofrecimientoAlquiler;
	}

	public OfrecimientoVenta getOfrecimientoVenta() {
		return ofrecimientoVenta;
	}

	public void setOfrecimientoVenta(OfrecimientoVenta ofrecimientoVenta) {
		this.ofrecimientoVenta = ofrecimientoVenta;
	}	
}
