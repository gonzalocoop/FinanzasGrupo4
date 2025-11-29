package com.portaltufinanza.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ResumenFinancieroUsuarioDTO {
    private int id_usuario;
    private String nombreCliente;
    private String direccion;
    private BigDecimal precioPropiedad;
    private String simboloMoneda;
    private BigDecimal montoPrestamo;
    private BigDecimal cuotaInicial;
    private BigDecimal tasaInteres;
    private Integer numeroCuotas;
    private String fechaInicio;
    private BigDecimal tir;
    private BigDecimal cok;
    private BigDecimal van;
    private BigDecimal tcea;
    private String estadoCredito;
    private BigDecimal totalintereses;
    private BigDecimal primeracuota;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(String estadoCredito) {
        this.estadoCredito = estadoCredito;
    }

    public BigDecimal getTcea() {
        return tcea;
    }

    public void setTcea(BigDecimal tcea) {
        this.tcea = tcea;
    }

    public BigDecimal getVan() {
        return van;
    }

    public void setVan(BigDecimal van) {
        this.van = van;
    }

    public BigDecimal getCok() {
        return cok;
    }

    public void setCok(BigDecimal cok) {
        this.cok = cok;
    }

    public BigDecimal getTir() {
        return tir;
    }

    public void setTir(BigDecimal tir) {
        this.tir = tir;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public BigDecimal getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(BigDecimal cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public BigDecimal getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(BigDecimal montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public String getSimboloMoneda() {
        return simboloMoneda;
    }

    public void setSimboloMoneda(String simboloMoneda) {
        this.simboloMoneda = simboloMoneda;
    }

    public BigDecimal getPrecioPropiedad() {
        return precioPropiedad;
    }

    public void setPrecioPropiedad(BigDecimal precioPropiedad) {
        this.precioPropiedad = precioPropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigDecimal getTotalintereses() {
        return totalintereses;
    }

    public void setTotalintereses(BigDecimal totalintereses) {
        this.totalintereses = totalintereses;
    }

    public BigDecimal getPrimeracuota() {
        return primeracuota;
    }

    public void setPrimeracuota(BigDecimal primeracuota) {
        this.primeracuota = primeracuota;
    }
}
