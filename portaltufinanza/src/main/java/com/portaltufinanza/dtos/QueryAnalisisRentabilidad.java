package com.portaltufinanza.dtos;

import java.math.BigDecimal;

public class QueryAnalisisRentabilidad {
    private String nombre_cliente;
    private int id_credito;
    private BigDecimal tir;
    private BigDecimal cok;
    private BigDecimal margen_rentabilidad;
    private String estado_credito;
    private String direccion;
    private BigDecimal van;
    private BigDecimal tasa_interes;
    private int numero_cuotas;


    public String getEstado_credito() {
        return estado_credito;
    }

    public void setEstado_credito(String estado_credito) {
        this.estado_credito = estado_credito;
    }

    public BigDecimal getMargen_rentabilidad() {
        return margen_rentabilidad;
    }

    public void setMargen_rentabilidad(BigDecimal margen_rentabilidad) {
        this.margen_rentabilidad = margen_rentabilidad;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    public BigDecimal getTir() {
        return tir;
    }

    public void setTir(BigDecimal tir) {
        this.tir = tir;
    }

    public BigDecimal getCok() {
        return cok;
    }

    public void setCok(BigDecimal cok) {
        this.cok = cok;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getVan() {
        return van;
    }

    public void setVan(BigDecimal van) {
        this.van = van;
    }

    public BigDecimal getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(BigDecimal tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public int getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(int numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }
}
