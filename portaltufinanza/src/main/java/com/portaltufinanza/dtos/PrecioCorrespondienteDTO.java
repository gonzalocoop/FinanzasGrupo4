package com.portaltufinanza.dtos;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.Moneda;
import com.portaltufinanza.entities.Propiedad;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class PrecioCorrespondienteDTO {
    private int id_precio_correspondiente;
    private BigDecimal cuota_inicial;
    private BigDecimal precio_calculado;
    private BonoBBP bono;
    private Propiedad propiedad;
    private Moneda moneda;

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

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
