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

	private int metrosCuadradosDesde;
	private int metrosCuadradosHasta;
	private int cantidadAmbientesDesde;
	private int cantidadAmbientesHasta;
	private int precioVentaDesde;
	private int precioVentaHasta;
	private int precioAlquilerDesde;
	private int precioAlquilerHasta;
	private Moneda monedaVenta;
	private Moneda monedaAlquiler;
	
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

	public int getMetrosCuadradosDesde() {
		return metrosCuadradosDesde;
	}

	public int getMetrosCuadradosHasta() {
		return metrosCuadradosHasta;
	}

	public int getCantidadAmbientesDesde() {
		return cantidadAmbientesDesde;
	}

	public int getCantidadAmbientesHasta() {
		return cantidadAmbientesHasta;
	}

	public void setMetrosCuadradosDesde(int metrosCuadradosDesde) {
		this.metrosCuadradosDesde = metrosCuadradosDesde;
	}

	public void setMetrosCuadradosHasta(int metrosCuadradosHasta) {
		this.metrosCuadradosHasta = metrosCuadradosHasta;
	}

	public void setCantidadAmbientesDesde(int cantidadAmbientesDesde) {
		this.cantidadAmbientesDesde = cantidadAmbientesDesde;
	}

	public void setCantidadAmbientesHasta(int cantidadAmbientesHasta) {
		this.cantidadAmbientesHasta = cantidadAmbientesHasta;
	}
	
	public double getPrecioVentaDesde() {
		return precioVentaDesde;
	}

	public void setPrecioVentaDesde(int precioVentaDesde) {
		this.precioVentaDesde = precioVentaDesde;
	}

	public double getPrecioVentaHasta() {
		return precioVentaHasta;
	}

	public void setPrecioVentaHasta(int precioVentaHasta) {
		this.precioVentaHasta = precioVentaHasta;
	}

	public int getPrecioAlquilerDesde() {
		return precioAlquilerDesde;
	}

	public void setPrecioAlquilerDesde(int precioAlquilerDesde) {
		this.precioAlquilerDesde = precioAlquilerDesde;
	}

	public int getPrecioAlquilerHasta() {
		return precioAlquilerHasta;
	}

	public void setPrecioAlquilerHasta(int precioAlquilerHasta) {
		this.precioAlquilerHasta = precioAlquilerHasta;
	}

	public Moneda getMonedaVenta() {
		return monedaVenta;
	}

	public void setMonedaVenta(Moneda moneda) {
		this.monedaVenta = moneda;
	}
	
	public Moneda getMonedaAlquiler() {
		return monedaAlquiler;
	}

	public void setMonedaAlquiler(Moneda moneda) {
		this.monedaAlquiler = moneda;
	}
	
}
