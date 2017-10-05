package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Propiedad propiedad;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private PersonaBasica reservador;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fecha;
	private boolean isHabilitada;
	
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	public PersonaBasica getReservador() {
		return reservador;
	}
	public void setReservador(PersonaBasica reservador) {
		this.reservador = reservador;
	}
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public boolean isHabilitada() {
		return isHabilitada;
	}
	public void setHabilitada(boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}
	public int getID() {
		return ID;
	}

	
	
}
