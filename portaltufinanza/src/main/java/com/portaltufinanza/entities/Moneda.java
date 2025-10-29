package com.portaltufinanza.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Moneda")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moneda;
    @Column(name = "nombre_moneda", nullable = false, length = 8)
    private String nombre_moneda;

    public Moneda() {
    }

    public Moneda(int id_moneda, String nombre_moneda) {
        this.id_moneda = id_moneda;
        this.nombre_moneda = nombre_moneda;
    }

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
