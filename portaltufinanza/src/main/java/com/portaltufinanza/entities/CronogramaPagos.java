package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="CronogramaPagos")
public class CronogramaPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cronograma;
    @Column(name="numero_cuota", nullable=false)
    private int numero_cuota;
    @Column(name="fecha_cuota", nullable=false)
    private LocalDate fecha_cuota;
    @Column(name = "cuota_fija", nullable = false, precision = 17, scale = 9)
    private BigDecimal cuota_fija;
    @Column(name = "interes_cuota", nullable = false, precision = 17, scale = 9)
    private BigDecimal interes_cuota;
    @Column(name = "amortizacion_cuota", nullable = false, precision = 17, scale = 9)
    private BigDecimal amortizacion_cuota;
    @Column(name = "seguro_desgravamen", nullable = false, precision = 17, scale = 9)
    private BigDecimal seguro_desgravamen;
    @Column(name = "seguro_bien", nullable = false, precision = 17, scale = 9)
    private BigDecimal seguro_bien;
    @Column(name = "saldo_restante", nullable = false, precision = 17, scale = 9)
    private BigDecimal saldo_restante;
    @ManyToOne
    @JoinColumn(name= "id_credito")
    private CreditoMiVivienda credito;

    public CronogramaPagos() {
    }

    public CronogramaPagos(int id_cronograma, int numero_cuota, LocalDate fecha_cuota, BigDecimal cuota_fija, BigDecimal interes_cuota, BigDecimal amortizacion_cuota, BigDecimal seguro_desgravamen, BigDecimal seguro_bien, BigDecimal saldo_restante, CreditoMiVivienda credito) {
        this.id_cronograma = id_cronograma;
        this.numero_cuota = numero_cuota;
        this.fecha_cuota = fecha_cuota;
        this.cuota_fija = cuota_fija;
        this.interes_cuota = interes_cuota;
        this.amortizacion_cuota = amortizacion_cuota;
        this.seguro_desgravamen = seguro_desgravamen;
        this.seguro_bien = seguro_bien;
        this.saldo_restante = saldo_restante;
        this.credito = credito;
    }

    public int getId_cronograma() {
        return id_cronograma;
    }

    public void setId_cronograma(int id_cronograma) {
        this.id_cronograma = id_cronograma;
    }

    public int getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(int numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public LocalDate getFecha_cuota() {
        return fecha_cuota;
    }

    public void setFecha_cuota(LocalDate fecha_cuota) {
        this.fecha_cuota = fecha_cuota;
    }

    public BigDecimal getCuota_fija() {
        return cuota_fija;
    }

    public void setCuota_fija(BigDecimal cuota_fija) {
        this.cuota_fija = cuota_fija;
    }

    public BigDecimal getInteres_cuota() {
        return interes_cuota;
    }

    public void setInteres_cuota(BigDecimal interes_cuota) {
        this.interes_cuota = interes_cuota;
    }

    public BigDecimal getAmortizacion_cuota() {
        return amortizacion_cuota;
    }

    public void setAmortizacion_cuota(BigDecimal amortizacion_cuota) {
        this.amortizacion_cuota = amortizacion_cuota;
    }

    public BigDecimal getSeguro_desgravamen() {
        return seguro_desgravamen;
    }

    public void setSeguro_desgravamen(BigDecimal seguro_desgravamen) {
        this.seguro_desgravamen = seguro_desgravamen;
    }

    public BigDecimal getSeguro_bien() {
        return seguro_bien;
    }

    public void setSeguro_bien(BigDecimal seguro_bien) {
        this.seguro_bien = seguro_bien;
    }

    public BigDecimal getSaldo_restante() {
        return saldo_restante;
    }

    public void setSaldo_restante(BigDecimal saldo_restante) {
        this.saldo_restante = saldo_restante;
    }

    public CreditoMiVivienda getCredito() {
        return credito;
    }

    public void setCredito(CreditoMiVivienda credito) {
        this.credito = credito;
    }
}
