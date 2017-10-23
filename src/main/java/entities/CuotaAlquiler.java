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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.YearMonth;

@Entity
@Table(name = "cuotasAlquiler")
public class CuotaAlquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private ContratoAlquiler contrato;
	
	private String anioMes;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Precio monto;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<HistoriaEstadoCuota> estados;

	public CuotaAlquiler() {
		estados = new ArrayList<>();
	}
	
	public ContratoAlquiler getContrato() {
		return contrato;
	}

	public void setContrato(ContratoAlquiler contrato) {
		this.contrato = contrato;
	}

	public YearMonth getAnioMes() {
		return YearMonth.parse(anioMes);
	}

	public void setAnioMes(YearMonth anioMes) {
		this.anioMes = anioMes.toString();
	}

	public Precio getMonto() {
		return monto;
	}

	public void setMonto(Precio monto) {
		this.monto = monto;
	}

	public int getID() {
		return ID;
	}

	public List<HistoriaEstadoCuota> getEstados() {
		return estados;
	}

	public void setEstados(List<HistoriaEstadoCuota> estados) {
		this.estados = estados;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}
	
}
