package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatosPunitorioContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private int diasDePago;
	private float porcentaje;
	private boolean isAcumulativo;
	
	public int getDiasDePago() {
		return diasDePago;
	}
	public void setDiasDePago(int diasDePago) {
		this.diasDePago = diasDePago;
	}
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
	
	
	
}
