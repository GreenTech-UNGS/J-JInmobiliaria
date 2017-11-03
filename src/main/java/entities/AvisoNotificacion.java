package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.joda.time.Period;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "notificaciones")
public class AvisoNotificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String periodo;
	
	private boolean isHabilitado;
	private boolean isVisto;
	
	public AvisoNotificacion(){
		periodo = "P";
	}

	public Period getPeriodo() {
		return Period.parse(periodo);
	}

	public void setPeriodo(Period periodo) {
		this.periodo = periodo.toString();
	}

	public boolean isHabilitado() {
		return isHabilitado;
	}

	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}

	public int getID() {
		return ID;
	}

	public boolean isVisto() {
		return isVisto;
	}

	public void setVisto(boolean isVisto) {
		this.isVisto = isVisto;
	}

}
