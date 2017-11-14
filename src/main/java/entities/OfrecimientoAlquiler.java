package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ofrecimientosAlquiler")
public class OfrecimientoAlquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@ManyToOne(cascade = CascadeType.ALL)
	private Precio precio;
	@ManyToOne(cascade = CascadeType.ALL)
	private Precio otrosGastos;
	
	private boolean isHabilitada;
	private int cantidadMeses;
	private int intervaloActualizacion;
	private float procentajeActualizacion;
	private boolean isAcumulativo;
	
	
	public OfrecimientoAlquiler() {
		
		cantidadMeses = 1;
		intervaloActualizacion = 1;
		
	}


	public Precio getPrecio() {
		return precio;
	}


	public void setPrecio(Precio precio) {
		this.precio = precio;
	}


	public Precio getOtrosGastos() {
		return otrosGastos;
	}


	public void setOtrosGastos(Precio otrosGastos) {
		this.otrosGastos = otrosGastos;
	}


	public int getCantidadMeses() {
		return cantidadMeses;
	}


	public void setCantidadMeses(int cantidadMeses) {
		this.cantidadMeses = cantidadMeses;
	}


	public int getIntervaloActualizacion() {
		return intervaloActualizacion;
	}


	public void setIntervaloActualizacion(int intervaloActualizacion) {
		this.intervaloActualizacion = intervaloActualizacion;
	}


	public float getProcentajeActualizacion() {
		return procentajeActualizacion;
	}


	public void setProcentajeActualizacion(float procentajeActualizacion) {
		this.procentajeActualizacion = procentajeActualizacion;
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


	public boolean isHabilitada() {
		return isHabilitada;
	}


	public void setHabilitada(boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}

}
