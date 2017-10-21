package dto;

public class MovimientoDeCajaDTO {

    public enum Tipo{Ingreso,
        Egreso};

    Tipo tipo;
    String fecha;
    String detalleStr;
    Double monto;
    String monedaStr;
    String montoStr;


    public String getMonedaStr() {
        return monedaStr;
    }

    public void setMonedaStr(String monedaStr) {
        this.monedaStr = monedaStr;
    }


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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
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
