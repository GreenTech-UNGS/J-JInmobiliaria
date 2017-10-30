package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<PersonaBasica> asistentes;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fechaHora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Localidad localidad;
	private String calle;
	private String altura;
	
	private long lat;
	private long lng;
	
	private boolean creadorAsiste;
	
	private String duracionEstimada;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoCita tipo;
	
	@Column(length = 1000)
	private String descripcion;

	@OneToOne(cascade = CascadeType.ALL)
	private AvisoNotificacion avisoCorto;

	@OneToOne(cascade = CascadeType.ALL)
	private AvisoNotificacion avisoLargo;
	
	public Cita() {
		
		asistentes = new ArrayList<>();
	}

	public List<PersonaBasica> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<PersonaBasica> asistentes) {
		this.asistentes = asistentes;
	}

	public DateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(DateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
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

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public String getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(String duracipnEstimada) {
		this.duracionEstimada = duracipnEstimada;
	}

	public TipoCita getTipo() {
		return tipo;
	}

	public void setTipo(TipoCita tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AvisoNotificacion getAvisoCorto() {
		return avisoCorto;
	}

	public void setAvisoCorto(AvisoNotificacion avisoCorto) {
		this.avisoCorto = avisoCorto;
	}

	public AvisoNotificacion getAvisoLargo() {
		return avisoLargo;
	}

	public void setAvisoLargo(AvisoNotificacion avisoLargo) {
		this.avisoLargo = avisoLargo;
	}

	public int getID() {
		return ID;
	}

	public boolean isCreadorAsiste() {
		return creadorAsiste;
	}

	public void setCreadorAsiste(boolean creadorAsiste) {
		this.creadorAsiste = creadorAsiste;
	}
	
	
}
