package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatosActualizacionContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private float porcentaje;
	private boolean isAcumulativo;
	
	private int actualizacionMeses;

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isAcumulativo() {
		return isAcumulativo;
	}

	public void setAcumulativo(boolean isAcumulativo) {
		this.isAcumulativo = isAcumulativo;
	}
	

	public int getID() {
		return ID;
	}

	public int getActualizacionMeses() {
		return actualizacionMeses;
	}

	public void setActualizacionMeses(int actualizacionMeses) {
		this.actualizacionMeses = actualizacionMeses;
	}
	
}
