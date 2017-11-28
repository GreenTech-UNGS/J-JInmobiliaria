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

	private Integer metrosCuadradosDesde;
	private Integer metrosCuadradosHasta;
	private Integer cantidadAmbientesDesde;
	private Integer cantidadAmbientesHasta;
	private Integer precioVentaDesde;
	private Integer precioVentaHasta;
	private Integer precioAlquilerDesde;
	private Integer precioAlquilerHasta;
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

	public Integer getMetrosCuadradosDesde() {
		return metrosCuadradosDesde;
	}

	public Integer getMetrosCuadradosHasta() {
		return metrosCuadradosHasta;
	}

	public Integer getCantidadAmbientesDesde() {
		return cantidadAmbientesDesde;
	}

	public Integer getCantidadAmbientesHasta() {
		return cantidadAmbientesHasta;
	}

	public void setMetrosCuadradosDesde(Integer metrosCuadradosDesde) {
		this.metrosCuadradosDesde = metrosCuadradosDesde;
	}

	public void setMetrosCuadradosHasta(Integer metrosCuadradosHasta) {
		this.metrosCuadradosHasta = metrosCuadradosHasta;
	}

	public void setCantidadAmbientesDesde(Integer cantidadAmbientesDesde) {
		this.cantidadAmbientesDesde = cantidadAmbientesDesde;
	}

	public void setCantidadAmbientesHasta(Integer cantidadAmbientesHasta) {
		this.cantidadAmbientesHasta = cantidadAmbientesHasta;
	}
	
	public Integer getPrecioVentaDesde() {
		return precioVentaDesde;
	}

	public void setPrecioVentaDesde(Integer precioVentaDesde) {
		this.precioVentaDesde = precioVentaDesde;
	}

	public Integer getPrecioVentaHasta() {
		return precioVentaHasta;
	}

	public void setPrecioVentaHasta(Integer precioVentaHasta) {
		this.precioVentaHasta = precioVentaHasta;
	}

	public Integer getPrecioAlquilerDesde() {
		return precioAlquilerDesde;
	}

	public void setPrecioAlquilerDesde(Integer precioAlquilerDesde) {
		this.precioAlquilerDesde = precioAlquilerDesde;
	}

	public Integer getPrecioAlquilerHasta() {
		return precioAlquilerHasta;
	}

	public void setPrecioAlquilerHasta(Integer precioAlquilerHasta) {
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
