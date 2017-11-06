package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="carteles")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cartel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int largo;
	private int ancho;
	private String identificador;
	private float monto;
	private String descripcion;
	
	public Cartel() {		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getLargo() {
		return largo;
	}
	
	public void setLargo(int largo) {
		this.largo = largo;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
