package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propietarios")
public class Propietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ID;
	private boolean isHabilitado;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
	
	
	
}
