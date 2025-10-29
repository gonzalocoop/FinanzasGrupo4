package com.portaltufinanza.dtos;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class BonoBBPDTO {
    private int id_bono;
    private BigDecimal monto_bono;

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
