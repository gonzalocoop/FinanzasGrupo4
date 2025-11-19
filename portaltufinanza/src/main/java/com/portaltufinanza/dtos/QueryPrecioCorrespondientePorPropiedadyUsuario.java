package com.portaltufinanza.dtos;

import java.math.BigDecimal;

public class QueryPrecioCorrespondientePorPropiedadyUsuario {

    private String nombre_cliente;
    private BigDecimal cuota_inicial;
    private BigDecimal precio_calculado;
    private BigDecimal costos_notariales;
    private BigDecimal registros_publicos;
    private BigDecimal costos_transaccion;
    private BigDecimal monto_bono;
    private BigDecimal precio_propiedad;
    private String nombre_moneda;

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public BigDecimal getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(BigDecimal cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
    }

    public BigDecimal getPrecio_calculado() {
        return precio_calculado;
    }

    public void setPrecio_calculado(BigDecimal precio_calculado) {
        this.precio_calculado = precio_calculado;
    }

    public BigDecimal getCostos_notariales() {
        return costos_notariales;
    }

    public void setCostos_notariales(BigDecimal costos_notariales) {
        this.costos_notariales = costos_notariales;
    }

    public BigDecimal getRegistros_publicos() {
        return registros_publicos;
    }

    public void setRegistros_publicos(BigDecimal registros_publicos) {
        this.registros_publicos = registros_publicos;
    }

    public BigDecimal getCostos_transaccion() {
        return costos_transaccion;
    }

    public void setCostos_transaccion(BigDecimal costos_transaccion) {
        this.costos_transaccion = costos_transaccion;
    }

    public BigDecimal getMonto_bono() {
        return monto_bono;
    }

    public void setMonto_bono(BigDecimal monto_bono) {
        this.monto_bono = monto_bono;
    }

    public BigDecimal getPrecio_propiedad() {
        return precio_propiedad;
    }

    public void setPrecio_propiedad(BigDecimal precio_propiedad) {
        this.precio_propiedad = precio_propiedad;
    }

    public String getNombre_moneda() {
        return nombre_moneda;
    }

    public void setNombre_moneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }
}
