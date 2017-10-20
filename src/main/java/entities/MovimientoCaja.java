package entities;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

public abstract class MovimientoCaja {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ID;
	
	@OneToOne(cascade = CascadeType.ALL)
	Precio monto;	
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime fecha;
	
	String detalle;

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
