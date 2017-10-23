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
@Table(name = "interesesPunitorios")
public class InteresPunitorioCuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	//TODO: One to one?
	@OneToOne(cascade = CascadeType.MERGE)
	private CuotaAlquiler cuota;

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime fecha;
	@OneToOne(cascade = CascadeType.ALL)
	private Precio monto;
	public CuotaAlquiler getCuota() {
		return cuota;
	}
	public void setCuota(CuotaAlquiler cuota) {
		this.cuota = cuota;
	}
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
	public int getID() {
		return ID;
	}
	
	
	
}
