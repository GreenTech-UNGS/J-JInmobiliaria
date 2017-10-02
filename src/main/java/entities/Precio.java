package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precios")
public class Precio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ID;
	private float monto;
	
	@Enumerated(EnumType.ORDINAL)
	private Moneda moneda;
	
	private Precio() {
		
	}
	
	public Precio(float monto, Moneda moneda) {
		super();
		this.monto = monto;
		this.moneda = moneda;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	
	
}
