package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
@Entity
@Table(name = "egresos")
public class Egreso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Precio monto;	
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fecha;
	
	private String detalle;
	
	
	public Precio getMonto() {
		return monto;
	}
	public void setMonto(Precio monto) {
		this.monto = monto;
	}
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getID() {
		return ID;
	}
	
	
	
}
