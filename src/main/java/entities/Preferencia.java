package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preferencias")
public class Preferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne(cascade = {CascadeType.MERGE})//TODO: podriamos ponerle persist
	private Localidad localidad;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoOfrecimiento tipoOfrecimiento;
	
	private int metrosCuadrados; // Lote
	private int cantidadAmbientes;
	private int precioDesde;
	private int precioHasta;
	private Moneda moneda;
	
	public Preferencia(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public TipoOfrecimiento getTipoOfrecimiento() {
		return tipoOfrecimiento;
	}

	public void setTipoOfrecimiento(TipoOfrecimiento tipoOfrecimiento) {
		this.tipoOfrecimiento = tipoOfrecimiento;
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public double getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(int precioDesde) {
		this.precioDesde = precioDesde;
	}

	public double getPrecioHasta() {
		return precioHasta;
	}

	public void setPrecioHasta(int precioHasta) {
		this.precioHasta = precioHasta;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
}
