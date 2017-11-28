package dto;

public class FichaPropiedadDTO {
    /*

    * Membrete y datos de la inmobiliaria
    * Tipo de propiedad
    * La foto de portada
    * Precio y moneda (Si se eligió mostrarlo, sino se cambia por “Consultar”)
    * Provincia y localidad
    * Cantidad de ambientes
    * Metros cuadrados
    * Otros datos
    * Observaciones públicas
        Para el segundo tipo, los datos son los mismos,
        solo que se agrega la calle, direccion, piso,
        departamento y un mapa de ubicación de la propiedad.
     */
    String TipoPropiedad;
    String Foto;
    String MetrosCuadrados;
    String CantidadDeAmbientes;
    String OtrosDatos;
    String Observaciones;
    String Calle;
    String Direccion;
    String Piso;
    String Departamento;
    String Localidad;
    String Provincia;
    String Precio;
    Double Lat;
    Double Long;
    boolean printPrecio;
    //Venta
    boolean isVenta;
    Double PrecioVenta;
    float ComisionComprador;
    float ComisionVendedor;

    //Alquiler
    boolean isAlquiler;
    Double otrosGastos;
    float porcentajeSellado;
    int cantidadMeses;
    int intervaloActualizacion;
    Double procentajeActualizacion;
    boolean isAcumulativo;

    public boolean isPrintPrecio() {
        return printPrecio;
    }

    public void setPrintPrecio(boolean printPrecio) {
        this.printPrecio = printPrecio;
    }

    public boolean isVenta() {
        return isVenta;
    }

    public void setVenta(boolean venta) {
        isVenta = venta;
    }

    public Double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        PrecioVenta = precioVenta;
    }

    public float getComisionComprador() {
        return ComisionComprador;
    }

    public void setComisionComprador(float comisionComprador) {
        ComisionComprador = comisionComprador;
    }

    public float getComisionVendedor() {
        return ComisionVendedor;
    }

    public void setComisionVendedor(float comisionVendedor) {
        ComisionVendedor = comisionVendedor;
    }

    public boolean isAlquiler() {
        return isAlquiler;
    }

    public void setAlquiler(boolean alquiler) {
        isAlquiler = alquiler;
    }

    public Double getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Double otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public float getPorcentajeSellado() {
        return porcentajeSellado;
    }

    public void setPorcentajeSellado(float porcentajeSellado) {
        this.porcentajeSellado = porcentajeSellado;
    }

    public int getCantidadMeses() {
        return cantidadMeses;
    }

    public void setCantidadMeses(int cantidadMeses) {
        this.cantidadMeses = cantidadMeses;
    }

    public int getIntervaloActualizacion() {
        return intervaloActualizacion;
    }

    public void setIntervaloActualizacion(int intervaloActualizacion) {
        this.intervaloActualizacion = intervaloActualizacion;
    }

    public Double getProcentajeActualizacion() {
        return procentajeActualizacion;
    }

    public void setProcentajeActualizacion(Double procentajeActualizacion) {
        this.procentajeActualizacion = procentajeActualizacion;
    }

    public boolean isAcumulativo() {
        return isAcumulativo;
    }

    public void setAcumulativo(boolean acumulativo) {
        isAcumulativo = acumulativo;
    }

    public String getTipoPropiedad() {
        return TipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        TipoPropiedad = tipoPropiedad;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getMetrosCuadrados() {
        return MetrosCuadrados;
    }

    public void setMetrosCuadrados(String metrosCuadrados) {
        MetrosCuadrados = metrosCuadrados;
    }

    public String getOtrosDatos() {
        return OtrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        OtrosDatos = otrosDatos;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getCalle() {
        return Calle;
    }

    public String setCalle(String calle) {
        Calle = calle;
        return calle;
    }

    public String getCantidadDeAmbientes() {
        return CantidadDeAmbientes;
    }

    public void setCantidadDeAmbientes(String cantidadDeAmbientes) {
        CantidadDeAmbientes = cantidadDeAmbientes;
    }


    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String piso) {
        Piso = piso;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLong() {
        return Long;
    }

    public void setLong(Double Long) {
        Lat = Long;
    }

}