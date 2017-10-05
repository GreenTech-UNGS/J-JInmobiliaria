package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "pagosPropietario")
public class PagoPropietario {

	private enum EstadoPago{PENDIENTE, PAGO};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private CuotaAlquiler cuota;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Propietario propietario;
	@Enumerated(EnumType.ORDINAL)
	private EstadoPago estado;
	
	private float monto;

	public CuotaAlquiler getCuota() {
		return cuota;
	}

	public void setCuota(CuotaAlquiler cuota) {
		this.cuota = cuota;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public EstadoPago getEstado() {
		return estado;
	}

	public void setEstado(EstadoPago estado) {
		this.estado = estado;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getID() {
		return ID;
	}

	
	
	
}
