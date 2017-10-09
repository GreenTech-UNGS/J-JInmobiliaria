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

	public enum EstadoPago{PENDIENTE, PAGO};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private CuotaAlquiler cuota;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Propietario propietario;
	@Enumerated(EnumType.ORDINAL)
	private EstadoPago estado;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Precio monto;

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
