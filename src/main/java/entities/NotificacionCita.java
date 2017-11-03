package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notificacionesCita")
public class NotificacionCita extends AvisoNotificacion{

	public enum TipoNotificacion{
		SISTEMA,
		EMAIL
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	private PersonaBasica persona;
	
	@Enumerated(EnumType.STRING)
	private TipoNotificacion tipoNotificacion;
	
	public NotificacionCita() {
	}

	public PersonaBasica getPersona() {
		return persona;
	}

	public void setPersona(PersonaBasica persona) {
		this.persona = persona;
	}

	public TipoNotificacion getTipo() {
		return tipoNotificacion;
	}

	public void setTipo(TipoNotificacion tipo) {
		this.tipoNotificacion = tipo;
	}

	
	
}
