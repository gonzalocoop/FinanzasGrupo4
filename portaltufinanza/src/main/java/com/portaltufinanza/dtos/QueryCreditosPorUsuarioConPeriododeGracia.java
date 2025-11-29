package com.portaltufinanza.dtos;

public class QueryCreditosPorUsuarioConPeriododeGracia {

    private int id_credito;
    private String tipo_gracia;
    private int duracion_gracia_meses;
    private int numero_cuotas;

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
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
}
