package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String pswHash;
	@OneToOne(cascade = {CascadeType.ALL})
	private Persona persona;
	
	@Column
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Rol.class)
	private List<Rol> roles;
	
	public Usuario() {
		roles = new ArrayList<>();
	}
	
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	

}
