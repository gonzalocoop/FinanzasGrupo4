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
    @Column(name = "precio_calculado", nullable = false, precision = 17, scale = 9)
    private BigDecimal precio_calculado;
    @ManyToOne
    @JoinColumn(name= "id_bono")
    private BonoBBP bono;
    @ManyToOne
    @JoinColumn(name= "id_propiedad")
    private Propiedad propiedad;

    public PrecioCorrespondiente() {
    }

    public PrecioCorrespondiente(int id_precio_correspondiente, BigDecimal cuota_inicial, BigDecimal precio_calculado, BonoBBP bono, Propiedad propiedad) {
        this.id_precio_correspondiente = id_precio_correspondiente;
        this.cuota_inicial = cuota_inicial;
        this.precio_calculado = precio_calculado;
        this.bono = bono;
        this.propiedad = propiedad;
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
}
