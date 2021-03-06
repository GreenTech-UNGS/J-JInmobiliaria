package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "estadosContrato")
public class HistoriaEstadoContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fecha;
	@Enumerated(EnumType.ORDINAL)
	private EstadoContrato estado;
	
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public EstadoContrato getEstado() {
		return estado;
	}
	public void setEstado(EstadoContrato estado) {
		this.estado = estado;
	}
	public int getID() {
		return ID;
	}
	
	
	
}
