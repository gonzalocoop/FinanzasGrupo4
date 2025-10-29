package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="BonoBBP")
public class BonoBBP {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_bono;
    @Column(name = "monto_bono", nullable = false, precision = 8, scale = 2)
    private BigDecimal monto_bono;

    public BonoBBP() {
    }

    public BonoBBP(int id_bono, BigDecimal monto_bono) {
        this.id_bono = id_bono;
        this.monto_bono = monto_bono;
    }

    public int getId_bono() {
        return id_bono;
    }

    public void setId_bono(int id_bono) {
        this.id_bono = id_bono;
    }

    public BigDecimal getMonto_bono() {
        return monto_bono;
    }

    public void setMonto_bono(BigDecimal monto_bono) {
        this.monto_bono = monto_bono;
    }
}
