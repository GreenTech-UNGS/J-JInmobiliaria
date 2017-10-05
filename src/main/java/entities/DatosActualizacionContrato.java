package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.Period;

@Entity
public class DatosActualizacionContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private float porcentaje;
	private boolean isAcumulativo;
	
	private String periodoDeActualizacion;

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

	public Period getPeriodoDeActualizacion() {
		return Period.parse(periodoDeActualizacion);
	}

	public void setPeriodoDeActualizacion(Period periodoDeActualizacion) {
		this.periodoDeActualizacion = periodoDeActualizacion.toString();
	}

	public int getID() {
		return ID;
	}
	
}
