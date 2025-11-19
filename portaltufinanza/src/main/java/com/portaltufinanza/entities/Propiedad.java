package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Propiedad")
public class Propiedad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_propiedad;
    @Column(name = "tipo_propiedad", nullable = false, length = 60)
    private String tipo_propiedad;
    @Column(name = "direccion", nullable = false, length = 60)
    private String direccion;
    @Column(name = "precio_propiedad", nullable = false, precision = 10, scale = 4)
    private BigDecimal precio_propiedad;
    @Column(name = "url_imagen", nullable = true, length = 255) // Es nullable (opcional)
    private String url_imagen;

    public Propiedad() {
    }

    public Propiedad(int id_propiedad, String tipo_propiedad, String direccion, BigDecimal precio_propiedad) {
        this.id_propiedad = id_propiedad;
        this.tipo_propiedad = tipo_propiedad;
        this.direccion = direccion;
        this.precio_propiedad = precio_propiedad;
    }

    public int getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public String getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(String tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getPrecio_propiedad() {
        return precio_propiedad;
    }

    public void setPrecio_propiedad(BigDecimal precio_propiedad) {
        this.precio_propiedad = precio_propiedad;
    }
    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
