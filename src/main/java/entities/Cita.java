package entities;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario asistente;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime fechaHora;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Localidad localidad;
	private String calle;
	private String altura;
	
	private double lat;
	private double lng;
	
	//private boolean creadorAsiste;
	private boolean finalizada;
	private boolean seBorra;
	
	private String duracionEstimada;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoCita tipo;
	
	@Column(length = 1000)
	private String descripcion;

	@OneToMany(cascade = CascadeType.ALL)
	private List<NotificacionCita> avisos;

	
	public Cita() {
		
		avisos = new ArrayList<>();
	}

	public DateTime getFechaHora() {
		return fechaHora.toDateTime();
	}

	public void setFechaHora(DateTime fechaHora) {
		this.fechaHora = fechaHora.toLocalDateTime();
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

	public double getLat() {
		return lat;
	}

	public void setLat(double d) {
		this.lat = d;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
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

	public int getID() {
		return ID;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public List<NotificacionCita> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<NotificacionCita> avisoCorto) {
		this.avisos = avisoCorto;
	}

	public boolean isSeBorra() {
		return seBorra;
	}

	public void setSeBorra(boolean seBorra) {
		this.seBorra = seBorra;
	}

	public Usuario getAsistente() {
		return asistente;
	}

	public void setAsistente(Usuario asistente) {
		this.asistente = asistente;
	}
	
	
}
