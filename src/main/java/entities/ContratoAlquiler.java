package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;

import java.util.Date;

@Entity
@Table(name="contratosAlquiler")
public class ContratoAlquiler extends Contrato{

	
	private int cantMeses;

	//private String primerAnioMes;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime inicio;

	private String garantia;

	@OneToOne(cascade = {CascadeType.ALL})
	private Precio cuotaMensual;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoContratoAlquiler tipoContratoAlquiler;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private AvisoNotificacion avisoIntimacion;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private AvisoNotificacion avisoProxVencer;

	@OneToOne(cascade = {CascadeType.ALL})
	private DatosPunitorioContrato datoPunitorio;

	@OneToOne(cascade = {CascadeType.ALL})
	private DatosActualizacionContrato datoActualizacion;

	public DateTime getInicio() {
		return inicio;
	}

	public YearMonth getPrimerAnioMes()
	{
		YearMonth anioMes = new YearMonth(this.getInicio());
		return anioMes;
	}

	public void setInicio(DateTime inicio) {
		this.inicio = inicio;
	}

	public int getCantMeses() {
		return cantMeses;
	}

	public void setCantMeses(int cantMeses) {
		this.cantMeses = cantMeses;
	}

	public Precio getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(Precio cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public TipoContratoAlquiler getTipoContratoAlquiler() {
		return tipoContratoAlquiler;
	}

	public void setTipoContratoAlquiler(TipoContratoAlquiler tipoContratoAlquiler) {
		this.tipoContratoAlquiler = tipoContratoAlquiler;
	}

	public AvisoNotificacion getAvisoIntimacion() {
		return avisoIntimacion;
	}

	public void setAvisoIntimacion(AvisoNotificacion avisoIntimacion) {
		this.avisoIntimacion = avisoIntimacion;
	}

	public AvisoNotificacion getAvisoProxVencer() {
		return avisoProxVencer;
	}

	public void setAvisoProxVencer(AvisoNotificacion avisoProxVencer) {
		this.avisoProxVencer = avisoProxVencer;
	}

	public DatosPunitorioContrato getDatoPunitorio() {
		return datoPunitorio;
	}

	public void setDatoPunitorio(DatosPunitorioContrato datoPunitorio) {
		this.datoPunitorio = datoPunitorio;
	}

	public DatosActualizacionContrato getDatoActualizacion() {
		return datoActualizacion;
	}

	public void setDatoActualizacion(DatosActualizacionContrato datoActualizacion) {
		this.datoActualizacion = datoActualizacion;
	}
/*
	public YearMonth getPrimerAnioMes() {
		return YearMonth.parse(primerAnioMes);
	}

	public void setPrimerAnioMes(YearMonth primerAnioMes) {
		this.primerAnioMes = primerAnioMes.toString();
	}
*/
	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	
	
}
