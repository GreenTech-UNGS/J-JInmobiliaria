package entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("noBasica")
@Table(name = "personas")
public class Persona extends PersonaBasica{
	
	public enum TipoCredencial{
		DNI,
		CUIT
		
	}
	
	
	private String credencial;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoCredencial tipoCred;

	public Persona() {
		super();
	}

	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public TipoCredencial getTipoCred() {
		return tipoCred;
	}

	public void setTipoCred(TipoCredencial tipoCred) {
		this.tipoCred = tipoCred;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((credencial == null) ? 0 : credencial.hashCode());
		result = prime * result + ((tipoCred == null) ? 0 : tipoCred.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (credencial == null) {
			if (other.credencial != null)
				return false;
		} else if (!credencial.equals(other.credencial))
			return false;
		if (tipoCred != other.tipoCred)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [getCredencial()=" + getCredencial() + ", getTipoCred()=" + getTipoCred() + ", hashCode()="
				+ hashCode() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getEmail()="
				+ getEmail() + ", getTelefonos()=" + getTelefonos() + ", getID()=" + getID() + "]";
	}
	
	
	
	
	
}
