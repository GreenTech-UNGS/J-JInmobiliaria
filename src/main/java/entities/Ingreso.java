package entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ingresoBasico")
@Table(name = "ingresos")
public class Ingreso extends MovimientoCaja{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ID;
	
	@OneToOne(cascade = CascadeType.ALL)
	Precio monto;	
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime fecha;
	
	String detalle;
	
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public Precio getMonto() {
		return monto;
	}
	public void setMonto(Precio monto) {
		this.monto = monto;
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
