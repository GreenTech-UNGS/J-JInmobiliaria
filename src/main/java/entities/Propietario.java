package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "propietarios")
public class Propietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private boolean isHabilitado;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Persona persona;
	
	public Propietario() {
		
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
}
