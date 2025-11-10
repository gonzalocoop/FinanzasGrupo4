package com.portaltufinanza.dtos;

import com.portaltufinanza.entities.CreditoMiVivienda;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CronogramaPagosDTO {
    private int id_cronograma;
    private int numero_cuota;
    private LocalDate fecha_cuota;
    private BigDecimal cuota_fija;
    private BigDecimal interes_cuota;
    private BigDecimal amortizacion_cuota;
    private BigDecimal seguro_desgravamen;
    private BigDecimal seguro_bien;
    private BigDecimal saldo_restante;
    private CreditoMiVivienda credito;

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
