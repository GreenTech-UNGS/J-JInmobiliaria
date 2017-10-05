package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contratosVenta")
public class ContratoVenta extends Contrato{
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Precio monto;
	public Precio getMonto() {
		return monto;
	}
	public void setMonto(Precio monto) {
		this.monto = monto;
	}

	
	

}
