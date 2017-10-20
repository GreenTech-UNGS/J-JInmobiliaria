package dto;

public class MovimientoDeCajaDTO {

    public enum Tipo{Ingreso,
        Egreso};

    Tipo tipo;
    String fecha;
    String detalleStr;
    Float monto;
    String montoStr;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalleStr() {
        return detalleStr;
    }

    public void setDetalleStr(String detalleStr) {
        this.detalleStr = detalleStr;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getMontoStr() {
        return montoStr;
    }

    public void setMontoStr(String montoStr) {
        this.montoStr = montoStr;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
