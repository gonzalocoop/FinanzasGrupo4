package com.portaltufinanza.dtos;

import java.math.BigDecimal;

public class QueryPropiedadxUserDTO {
    private String nombre;
    private Integer idPropiedad;
    private String tipoPropiedad;
    private String direccion;
    private BigDecimal precioPropiedad;

    public String getNombreCliente() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getPrecioPropiedad() {
        return precioPropiedad;
    }

    public void setPrecioPropiedad(BigDecimal precioPropiedad) {
        this.precioPropiedad = precioPropiedad;
    }
}
