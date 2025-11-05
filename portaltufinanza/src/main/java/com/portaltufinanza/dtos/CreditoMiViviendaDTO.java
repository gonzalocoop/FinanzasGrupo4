package com.portaltufinanza.dtos;

import com.portaltufinanza.entities.Moneda;
import com.portaltufinanza.entities.PrecioCorrespondiente;
import com.portaltufinanza.entities.Propiedad;
import com.portaltufinanza.entities.Usuarios;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditoMiViviendaDTO {
    private int id_credito;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String tipo_tasa;
    private BigDecimal tasa_interes;
    private String peridiocidad_tasa;
    private String tipo_capitalizacion;
    private int m_numero_capitalizaciones;
    private int n_numero_periodos;
    private BigDecimal tem_requerido;
    private BigDecimal tea;
    private BigDecimal tcea;
    private String tipo_gracia;
    private int duracion_gracia_meses;
    private int numero_cuotas;
    private BigDecimal cuota_inicial;
    private BigDecimal saldo_inicial;
    private BigDecimal van;
    private BigDecimal tir;
    private Propiedad propiedad;
    private Usuarios usuario;
    private PrecioCorrespondiente preciocorrespondiente;

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo_tasa() {
        return tipo_tasa;
    }

    public void setTipo_tasa(String tipo_tasa) {
        this.tipo_tasa = tipo_tasa;
    }

    public BigDecimal getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(BigDecimal tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public String getPeridiocidad_tasa() {
        return peridiocidad_tasa;
    }

    public void setPeridiocidad_tasa(String peridiocidad_tasa) {
        this.peridiocidad_tasa = peridiocidad_tasa;
    }

    public String getTipo_capitalizacion() {
        return tipo_capitalizacion;
    }

    public void setTipo_capitalizacion(String tipo_capitalizacion) {
        this.tipo_capitalizacion = tipo_capitalizacion;
    }

    public int getM_numero_capitalizaciones() {
        return m_numero_capitalizaciones;
    }

    public void setM_numero_capitalizaciones(int m_numero_capitalizaciones) {
        this.m_numero_capitalizaciones = m_numero_capitalizaciones;
    }

    public int getN_numero_periodos() {
        return n_numero_periodos;
    }

    public void setN_numero_periodos(int n_numero_periodos) {
        this.n_numero_periodos = n_numero_periodos;
    }

    public BigDecimal getTem_requerido() {
        return tem_requerido;
    }

    public void setTem_requerido(BigDecimal tem_requerido) {
        this.tem_requerido = tem_requerido;
    }

    public BigDecimal getTea() {
        return tea;
    }

    public void setTea(BigDecimal tea) {
        this.tea = tea;
    }

    public BigDecimal getTcea() {
        return tcea;
    }

    public void setTcea(BigDecimal tcea) {
        this.tcea = tcea;
    }

    public String getTipo_gracia() {
        return tipo_gracia;
    }

    public void setTipo_gracia(String tipo_gracia) {
        this.tipo_gracia = tipo_gracia;
    }

    public int getDuracion_gracia_meses() {
        return duracion_gracia_meses;
    }

    public void setDuracion_gracia_meses(int duracion_gracia_meses) {
        this.duracion_gracia_meses = duracion_gracia_meses;
    }

    public int getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(int numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public BigDecimal getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(BigDecimal saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public BigDecimal getVan() {
        return van;
    }

    public void setVan(BigDecimal van) {
        this.van = van;
    }

    public BigDecimal getTir() {
        return tir;
    }

    public void setTir(BigDecimal tir) {
        this.tir = tir;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public PrecioCorrespondiente getPreciocorrespondiente() {
        return preciocorrespondiente;
    }

    public void setPreciocorrespondiente(PrecioCorrespondiente preciocorrespondiente) {
        this.preciocorrespondiente = preciocorrespondiente;
    }

    public BigDecimal getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(BigDecimal cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
    }
}
