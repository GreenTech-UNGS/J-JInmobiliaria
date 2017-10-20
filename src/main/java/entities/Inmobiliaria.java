package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inmobiliarias")
public class Inmobiliaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String CUIT;
	private String nombre;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private String email;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Localidad localidad;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PersonaBasica> contactos;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Telefono> telefonos;
	
	public Inmobiliaria() {
		this.contactos = new ArrayList<>();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<PersonaBasica> getContactos() {
		return contactos;
	}
	
	public void addContacto(PersonaBasica p) {
		this.contactos.add(p);
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	
	public void insertTelefono(Telefono t) {
		this.telefonos.add(t);
	}

	
}
