package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="PrecioCorrespondiente")
public class PrecioCorrespondiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_precio_correspondiente;
    @Column(name = "cuota_inicial", nullable = false, precision = 16, scale = 9)
    private BigDecimal cuota_inicial;
    @Column(name = "costos_notariales", nullable = false, precision = 16, scale = 9)
    private BigDecimal costos_notariales;
    @Column(name = "registros_publicos", nullable = false, precision = 16, scale = 9)
    private BigDecimal registros_publicos;
    @Column(name = "costos_transaccion", nullable = false, precision = 16, scale = 9)
    private BigDecimal costos_transaccion;
    @Column(name = "precio_calculado", nullable = false, precision = 17, scale = 9)
    private BigDecimal precio_calculado;
    @ManyToOne
    @JoinColumn(name= "id_bono")
    private BonoBBP bono;
    @ManyToOne
    @JoinColumn(name= "id_propiedad")
    private Propiedad propiedad;
    @ManyToOne
    @JoinColumn(name= "id_moneda")
    private Moneda moneda;

    public PrecioCorrespondiente() {
    }

    public PrecioCorrespondiente(int id_precio_correspondiente, BigDecimal cuota_inicial, BigDecimal costos_notariales, BigDecimal registros_publicos, BigDecimal costos_transaccion, BigDecimal precio_calculado, BonoBBP bono, Propiedad propiedad, Moneda moneda) {
        this.id_precio_correspondiente = id_precio_correspondiente;
        this.cuota_inicial = cuota_inicial;
        this.costos_notariales = costos_notariales;
        this.registros_publicos = registros_publicos;
        this.costos_transaccion = costos_transaccion;
        this.precio_calculado = precio_calculado;
        this.bono = bono;
        this.propiedad = propiedad;
        this.moneda = moneda;
    }

    public int getId_precio_correspondiente() {
        return id_precio_correspondiente;
    }

    public void setId_precio_correspondiente(int id_precio_correspondiente) {
        this.id_precio_correspondiente = id_precio_correspondiente;
    }

    public BigDecimal getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(BigDecimal cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
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

    public BigDecimal getPrecio_calculado() {
        return precio_calculado;
    }

    public void setPrecio_calculado(BigDecimal precio_calculado) {
        this.precio_calculado = precio_calculado;
    }

    public BonoBBP getBono() {
        return bono;
    }

    public void setBono(BonoBBP bono) {
        this.bono = bono;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
