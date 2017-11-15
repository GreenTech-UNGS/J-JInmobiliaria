package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contratosVenta")
public class ContratoVenta extends Contrato{
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Precio monto;
	
	private float comisionVendedor;
	private float comisionComprador;
	
	public Precio getMonto() {
		return monto;
	}
	public void setMonto(Precio monto) {
		this.monto = monto;
	}
	public float getComisionVendedor() {
		return comisionVendedor;
	}
	public void setComisionVendedor(float comisionVendedor) {
		this.comisionVendedor = comisionVendedor;
	}
	public float getComisionComprador() {
		return comisionComprador;
	}
	public void setComisionComprador(float comisionComprador) {
		this.comisionComprador = comisionComprador;
	}

	
	

}
