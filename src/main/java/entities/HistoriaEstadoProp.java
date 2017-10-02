package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "estadosPropiedad")
public class HistoriaEstadoProp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ID;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fecha;
	private EstadoProp estado;
	
	public HistoriaEstadoProp() {
		// TODO Auto-generated constructor stub
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}

	public EstadoProp getEstado() {
		return estado;
	}

	public void setEstado(EstadoProp estado) {
		this.estado = estado;
	}
	
	
	
}
