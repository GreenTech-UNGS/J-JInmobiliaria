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
	
	
	
	
}
