package dto;

import entities.AvisoNotificacion;

public class Notificacion {

	private String titulo;
	private String descripcion;
	private AvisoNotificacion avisoNotif;
	
	public Notificacion() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public AvisoNotificacion getAvisoNotif() {
		return avisoNotif;
	}

	public void setAvisoNotif(AvisoNotificacion avisoNotif) {
		this.avisoNotif = avisoNotif;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
