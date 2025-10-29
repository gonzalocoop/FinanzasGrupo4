package com.portaltufinanza.dtos;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class PropiedadDTO {
    private int id_propiedad;
    private String tipo_propiedad;
    private String direccion;
    private BigDecimal precio_propiedad;

    public int getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public String getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(String tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getPrecio_propiedad() {
        return precio_propiedad;
    }

    public void setPrecio_propiedad(BigDecimal precio_propiedad) {
        this.precio_propiedad = precio_propiedad;
    }
}
