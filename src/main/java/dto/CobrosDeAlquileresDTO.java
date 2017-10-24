package dto;

public class CobrosDeAlquileresDTO {

    String idContrato;
	String anioMes;
    String propiedadStr;
    String inquilinoStr;
    Double monto;
    String interesStr;
    String estadoStr;
    Double montoTotal;
    String monedaStr;


    public String getMonedaStr() {
        return monedaStr;
    }

    public void setMonedaStr(String monedaStr) {
        this.monedaStr = monedaStr;
    }


    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getInteresStr() {
        return interesStr;
    }

    public void setInteresStr(String interesStr) {
        this.interesStr = interesStr;
    }

    public String getAnioMes() {
        return anioMes;
    }

    public void setAnioMes(String anioMes) {
        this.anioMes = anioMes;
    }

    public String getEstadoStr() {
        return estadoStr;
    }

    public void setEstadoStr(String estadoStr) {
        this.estadoStr = estadoStr;
    }

	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	public String getPropiedadStr() {
		return propiedadStr;
	}
	public void setPropiedadStr(String propiedadStr) {
		this.propiedadStr = propiedadStr;
	}
	public String getInquilinoStr() {
		return inquilinoStr;
	}
	public void setInquilinoStr(String inquilinoStr) {
		this.inquilinoStr = inquilinoStr;
	}
	public Double getMonto() { return monto;}
	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
