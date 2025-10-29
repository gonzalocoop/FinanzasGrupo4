package com.portaltufinanza.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name="username", nullable=false, length=50)
    private String username;
    @Column(name="password", nullable=false, length=200)
    private String password;
    @Column(name="correo", nullable=false, length=80)
    private String correo;
    @Column(name="nombre_cliente", nullable=false, length=50)
    private String nombre_cliente;
    @Column(name="dni", nullable=false, length=8)
    private String dni;
    @Column(name = "ingreso_mensual", nullable = false, precision = 8, scale = 2)
    private BigDecimal ingreso_mensual;
    @Column(name="estado_civil", nullable=false, length=16)
    private String estado_civil;
    @Column(name="edad", nullable=false)
    private int edad;
    @Column(name="activo", nullable=false)
    private Boolean activo;
    @ManyToOne
    @JoinColumn(name= "id_rol") //esto es el nombre con el que saldra en esta tabla
    private Roles rol;

    public Usuarios() {
    }

    public Usuarios(int id_usuario, String username, String password, String correo, String nombre_cliente, String dni, BigDecimal ingreso_mensual, String estado_civil, int edad, Boolean activo, Roles rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.nombre_cliente = nombre_cliente;
        this.dni = dni;
        this.ingreso_mensual = ingreso_mensual;
        this.estado_civil = estado_civil;
        this.edad = edad;
        this.activo = activo;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public BigDecimal getIngreso_mensual() {
        return ingreso_mensual;
    }

    public void setIngreso_mensual(BigDecimal ingreso_mensual) {
        this.ingreso_mensual = ingreso_mensual;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
