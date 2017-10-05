package entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String pswHash;
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Persona persona;
	
	public String getPswHash() {
		return pswHash;
	}
	public void setPswHash(String pswHash) {
		this.pswHash = pswHash;
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
	
	

}
