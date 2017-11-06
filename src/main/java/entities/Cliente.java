package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private boolean isHabilitado;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Persona persona;
	
	@Enumerated(EnumType.ORDINAL)
	private CalificacionCliente calificacion;
	
	public Cliente() {
	}

	public boolean isHabilitado() {
		return isHabilitado;
	}

	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public CalificacionCliente getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionCliente calificacion) {
		this.calificacion = calificacion;
	}
	
	
	
}
