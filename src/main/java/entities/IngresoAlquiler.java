package entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ingresoAlquiler")
public class IngresoAlquiler extends Ingreso{
	
	@OneToOne(cascade = CascadeType.MERGE)
	private CuotaAlquiler cuota;

	public CuotaAlquiler getCuota() {
		return cuota;
	}

	public void setCuota(CuotaAlquiler cuota) {
		this.cuota = cuota;
	}
	
	
	

}
