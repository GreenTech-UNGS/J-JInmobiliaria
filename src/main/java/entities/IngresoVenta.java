package entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ingresoVenta")
public class IngresoVenta extends Ingreso{

	@OneToOne(cascade = CascadeType.MERGE)
	private ContratoVenta contratoVenta;

	public ContratoVenta getContratoVenta() {
		return contratoVenta;
	}

	public void setContratoVenta(ContratoVenta contratoVenta) {
		this.contratoVenta = contratoVenta;
	}
	
	
	
}
