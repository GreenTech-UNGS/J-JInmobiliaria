package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ofrecimientosVenta")
public class OfrecimientoVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@ManyToOne(cascade = CascadeType.ALL)
	private Precio precio;
	
	private boolean isHabilitada;
	private float comisionComprador;
	private float comisionVendedor;
	
	public OfrecimientoVenta() {
		// TODO Auto-generated constructor stub
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public boolean isHabilitada() {
		return isHabilitada;
	}

	public void setHabilitada(boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}

	public float getComisionComprador() {
		return comisionComprador;
	}

	public void setComisionComprador(float comisionComprador) {
		this.comisionComprador = comisionComprador;
	}

	public float getComisionVendedor() {
		return comisionVendedor;
	}

	public void setComisionVendedor(float comisionVendedor) {
		this.comisionVendedor = comisionVendedor;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
