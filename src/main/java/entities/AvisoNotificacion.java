package entities;

import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvisoNotificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String periodo;
	
	private boolean isHabilitado;

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

}
