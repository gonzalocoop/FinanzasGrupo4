package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="CreditoMiVivienda")
public class CreditoMiVivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_credito;
    @Column(name="fecha_inicio", nullable=false)
    private LocalDate fecha_inicio;
    @Column(name="fecha_fin", nullable=false)
    private LocalDate fecha_fin;
    @Column(name = "tipo_tasa", nullable = false, length = 30)
    private String tipo_tasa;
    @Column(name = "tasa_interes", nullable = false, precision = 12, scale = 9)
    private BigDecimal tasa_interes;
    @Column(name = "peridiocidad_tasa", nullable = false, length = 8)
    private String peridiocidad_tasa;
    @Column(name = "tipo_capitalizacion", nullable = true, length = 8)
    private String tipo_capitalizacion;
    @Column(name = "m_numero_capitalizaciones", nullable = true)
    private BigDecimal m_numero_capitalizaciones;
    @Column(name = "n_numero_periodos", nullable = true)
    private BigDecimal n_numero_periodos;
    @Column(name = "tem_requerido", nullable = false, precision = 12, scale = 9)
    private BigDecimal tem_requerido;
    @Column(name = "tea", nullable = false, precision = 12, scale = 9)
    private BigDecimal tea;
    @Column(name = "tcea", nullable = false, precision = 18, scale = 9)
    private BigDecimal tcea;
    @Column(name = "tipo_gracia", nullable = false, length = 8)
    private String tipo_gracia;
    @Column(name = "duracion_gracia_meses", nullable = true)
    private int duracion_gracia_meses;
    @Column(name = "numero_cuotas", nullable = true)
    private int numero_cuotas;
    @Column(name = "cuota_inicial", nullable = false, precision = 16, scale = 9)
    private BigDecimal cuota_inicial;
    @Column(name = "saldo_inicial", nullable = false, precision = 17, scale = 9)
    private BigDecimal saldo_inicial;
    @Column(name = "cok", nullable = false, precision = 12, scale = 9)
    private BigDecimal cok;
    @Column(name = "van", nullable = false, precision = 18, scale = 9)
    private BigDecimal van;
    @Column(name = "tir", nullable = false, precision = 18, scale = 9)
    private BigDecimal tir;
    @ManyToOne
    @JoinColumn(name = "id_propiedad")
    private Propiedad propiedad;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "id_precio_correspondiente")
    private PrecioCorrespondiente preciocorrespondiente;

    public CreditoMiVivienda() {
    }

    public CreditoMiVivienda(int id_credito, LocalDate fecha_inicio, LocalDate fecha_fin, String tipo_tasa, BigDecimal tasa_interes, String peridiocidad_tasa, String tipo_capitalizacion, BigDecimal m_numero_capitalizaciones, BigDecimal n_numero_periodos, BigDecimal tem_requerido, BigDecimal tea, BigDecimal tcea, String tipo_gracia, int duracion_gracia_meses, int numero_cuotas, BigDecimal cuota_inicial, BigDecimal saldo_inicial, BigDecimal cok, BigDecimal van, BigDecimal tir, Propiedad propiedad, Usuarios usuario, PrecioCorrespondiente preciocorrespondiente) {
        this.id_credito = id_credito;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tipo_tasa = tipo_tasa;
        this.tasa_interes = tasa_interes;
        this.peridiocidad_tasa = peridiocidad_tasa;
        this.tipo_capitalizacion = tipo_capitalizacion;
        this.m_numero_capitalizaciones = m_numero_capitalizaciones;
        this.n_numero_periodos = n_numero_periodos;
        this.tem_requerido = tem_requerido;
        this.tea = tea;
        this.tcea = tcea;
        this.tipo_gracia = tipo_gracia;
        this.duracion_gracia_meses = duracion_gracia_meses;
        this.numero_cuotas = numero_cuotas;
        this.cuota_inicial = cuota_inicial;
        this.saldo_inicial = saldo_inicial;
        this.cok = cok;
        this.van = van;
        this.tir = tir;
        this.propiedad = propiedad;
        this.usuario = usuario;
        this.preciocorrespondiente = preciocorrespondiente;
    }

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

    public BigDecimal getM_numero_capitalizaciones() {
        return m_numero_capitalizaciones;
    }

    public void setM_numero_capitalizaciones(BigDecimal m_numero_capitalizaciones) {
        this.m_numero_capitalizaciones = m_numero_capitalizaciones;
    }

    public BigDecimal getN_numero_periodos() {
        return n_numero_periodos;
    }

    public void setN_numero_periodos(BigDecimal n_numero_periodos) {
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

    public BigDecimal getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(BigDecimal cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
    }

    public BigDecimal getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(BigDecimal saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public BigDecimal getCok() {
        return cok;
    }

    public void setCok(BigDecimal cok) {
        this.cok = cok;
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
}
