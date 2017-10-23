package entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "otrosDatos_Propiedades")
public class PropiedadOtrosDatos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoPropiedad tipo;
	
	private int cantidadAmbientes;
	private int metrosCuadradosCubiertos;
	private int metrosCuadradosLote;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Habitacion> habitaciones;
	
	private boolean esAptoCredito;

	public PropiedadOtrosDatos() {
		habitaciones = new ArrayList<>();
	}
	
	public TipoPropiedad getTipo() {
		return tipo;
	}

	public void setTipo(TipoPropiedad tipo) {
		this.tipo = tipo;
	}

	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public int getMetrosCuadradosCubiertos() {
		return metrosCuadradosCubiertos;
	}

	public void setMetrosCuadradosCubiertos(int metrosCuadradosCubiertos) {
		this.metrosCuadradosCubiertos = metrosCuadradosCubiertos;
	}

	public int getMetrosCuadradosLote() {
		return metrosCuadradosLote;
	}

	public void setMetrosCuadradosLote(int metrosCuadradosLote) {
		this.metrosCuadradosLote = metrosCuadradosLote;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public boolean isAptoCredito() {
		return esAptoCredito;
	}

	public void setEsAptoCredito(boolean esAptoCredito) {
		this.esAptoCredito = esAptoCredito;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
