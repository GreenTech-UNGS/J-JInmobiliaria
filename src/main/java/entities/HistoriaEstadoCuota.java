package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "estadosCuota")
public class HistoriaEstadoCuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private long fecha;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoCuota estado;

	public DateTime getFecha() {
		return new DateTime(fecha);
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha.getMillis();
	}

	public EstadoCuota getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuota estado) {
		this.estado = estado;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
