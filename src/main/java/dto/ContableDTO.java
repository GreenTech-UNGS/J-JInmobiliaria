package dto;

public class ContableDTO {

    public enum Tipo{Ingreso,
        Egreso};

    Tipo tipo;
    String anioMes;
    String detalle;
    Double monto;
    String moneda;
    String propiedadStr;
    String inquilinoStr;
    Double interes;
    String estado;
    Double montoTotal;

    public String getAnioMes() {
        return anioMes;
    }

    public void setAnioMes(String anioMes) {
        this.anioMes = anioMes;
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

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
