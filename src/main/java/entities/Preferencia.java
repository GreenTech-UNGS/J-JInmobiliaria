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

	public int getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(int precioDesde) {
		this.precioDesde = precioDesde;
	}

	public int getPrecioHasta() {
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
