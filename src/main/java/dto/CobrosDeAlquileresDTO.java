package dto;

public class CobrosDeAlquileresDTO {


    String idContrato;
	String anioMes;
    String propiedadStr;
    String inquilinoStr;
    String montoStr;
    String interesStr;
    String estadoStr;
    String montoTotalStr;

    public String getMontoTotalStr() {
        return montoTotalStr;
    }

    public void setMontoTotalStr(String montoTotalStr) {
        this.montoTotalStr = montoTotalStr;
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
	public String getMontoStr() {
		return montoStr;
	}
	public void setMontoStr(String montoStr) {
		this.montoStr = montoStr;
	}

}
