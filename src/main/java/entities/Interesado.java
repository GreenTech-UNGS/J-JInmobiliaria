package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "interesados")
public class Interesado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Persona persona;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Preferencia preferencia;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime fechaAlta;
	
	//preferencias.......raro
	
	public Interesado(){
		
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public DateTime getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(DateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
