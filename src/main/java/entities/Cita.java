package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

@Entity
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private List<PersonaBasica> asistentes;
	
	private DateTime fechaHora;
	
	private Localidad localidad;
	private String calle;
	private String altura;
	
	private long lat;
	private long lng;
	
	private String duracipnEstimada;
	
	private TipoCita tipo;
	
	@Column(length = 1000)
	private String descripcion;
	
	private AvisoNotificacion avisoCorto;
	
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

	public String getDuracipnEstimada() {
		return duracipnEstimada;
	}

	public void setDuracipnEstimada(String duracipnEstimada) {
		this.duracipnEstimada = duracipnEstimada;
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
	
	
}
