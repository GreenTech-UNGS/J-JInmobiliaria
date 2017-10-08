package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="contratos")
@Inheritance(strategy=InheritanceType.JOINED)
public class Contrato {
	
	//TODO: habria que poner archivos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String identificador;
	private float gastosAdmin;
	private String garantia;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<HistoriaEstadoContrato> estados;


	public Contrato() {
		estados = new ArrayList<>();
	}
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private Propiedad propiedad;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private Cliente cliente;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private Usuario creador;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public float getGastosAdmin() {
		return gastosAdmin;
	}

	public void setGastosAdmin(float gastosAdmin) {
		this.gastosAdmin = gastosAdmin;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public int getID() {
		return ID;
	}
	
	public List<HistoriaEstadoContrato> getEstados() {
		return estados;
	}

	public void setEstados(List<HistoriaEstadoContrato> estados) {
		this.estados = estados;
	}
	

}
