package com.portaltufinanza.dtos;

import jakarta.persistence.Column;

public class MonedaDTO {
    private int id_moneda;
    private String nombre_moneda;

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public String getNombre_moneda() {
        return nombre_moneda;
    }

    public void setNombre_moneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }
}
