package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.CreditoMiVivienda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface ICreditoMiViviendaRepository extends JpaRepository<CreditoMiVivienda,Integer> {

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO credito_mi_vivienda ( " +
                    "cok,cuota_inicial, duracion_gracia_meses, fecha_fin, fecha_inicio, m_numero_capitalizaciones, " +
                    "n_numero_periodos, numero_cuotas, peridiocidad_tasa, saldo_inicial, tasa_interes, tcea, tea, " +
                    "tem_requerido, tipo_capitalizacion, tipo_gracia, tipo_tasa, tir, van, " +
                    "id_precio_correspondiente, id_propiedad, id_usuario) " +
                    "SELECT " +
                    ":cok, pc.cuota_inicial, :duracion_gracia_meses, '2099-12-31', :fecha_inicio, 0, " +
                    "0, :numero_cuotas, :peridiocidad_tasa, pc.precio_calculado, :tasa_interes, 0, 0, " +
                    "0, NULLIF(:tipo_capitalizacion, 'Nulo'), :tipo_gracia, :tipo_tasa, 0, 0, " +
                    ":id_precio_correspondiente, pc.id_propiedad, :id_usuario " + // <-- pc.id_propiedad usado aquí
                    "FROM precio_correspondiente pc " +
                    "WHERE pc.id_precio_correspondiente = :id_precio_correspondiente",
            nativeQuery = true
    )
    void registrarCreditoMiVivienda(
            @Param("cok") BigDecimal cok,
            @Param("fecha_inicio") LocalDate fechaInicio,
            @Param("tipo_tasa") String tipoTasa,
            @Param("tasa_interes") BigDecimal tasaInteres,
            @Param("peridiocidad_tasa") String periodicidadTasa,
            @Param("numero_cuotas") Integer numeroCuotas,
            @Param("tipo_gracia") String tipoGracia,
            @Param("duracion_gracia_meses") Integer duracionGraciaMeses,
            @Param("tipo_capitalizacion") String tipoCapitalizacion,
            @Param("id_precio_correspondiente") Integer idPrecioCorrespondiente,
            @Param("id_usuario") Integer idUsuario
    );


    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "UPDATE credito_mi_vivienda AS cmv SET " +

                    // CÁLCULO M_NUMERO_CAPITALIZACIONES
                    "m_numero_capitalizaciones = CAST(CASE " +
                    "WHEN cmv.tipo_tasa = 'Nominal' THEN " +
                    "CASE " +
                    "WHEN cmv.peridiocidad_tasa = 'Mensual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0 ELSE 30.0/360.0 END " +
                    "WHEN cmv.peridiocidad_tasa = 'Anual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 360.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 360.0/30.0 ELSE 360.0/360.0 END " +
                    "ELSE CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 1.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0/30.0 ELSE 1.0/360.0 END " +
                    "END " +
                    "ELSE NULL " +
                    "END AS NUMERIC), " + //CAST a NUMERIC añadido, si no lo pongo no funciona, no me preguntes por que

                    // CÁLCULO N_NUMERO_PERIODOS
                    "n_numero_periodos = CAST(CASE " +
                    "WHEN cmv.tipo_tasa = 'Nominal' THEN " +
                    "CASE " +
                    "WHEN cmv.peridiocidad_tasa = 'Mensual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0 ELSE 30.0/360.0 END " +
                    "WHEN cmv.peridiocidad_tasa = 'Anual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 30.0/30.0 ELSE 30.0/360.0 END " +
                    "ELSE CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 30.0/30.0 ELSE 30.0/360.0 END " +
                    "END " +
                    "ELSE NULL " +
                    "END AS NUMERIC), " + // CAST a NUMERIC añadido

                    // CÁLCULO TEM_REQUERIDO
                    "tem_requerido = CAST(CASE " +
                    "WHEN cmv.tipo_tasa = 'Nominal' THEN " +
                    "(POW( (1.0 + (cmv.tasa_interes / 100.0) / " +
                    "CASE " +
                    "WHEN cmv.peridiocidad_tasa = 'Mensual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0 ELSE 30.0/360.0 END " +
                    "WHEN cmv.peridiocidad_tasa = 'Anual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 360.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 360.0/30.0 ELSE 360.0/360.0 END " +
                    "ELSE CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 1.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0/30.0 ELSE 1.0/360.0 END " +
                    "END " +
                    "), " +
                    "CASE " +
                    "WHEN cmv.peridiocidad_tasa = 'Mensual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 1.0 ELSE 30.0/360.0 END " +
                    "WHEN cmv.peridiocidad_tasa = 'Anual' THEN CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 30.0/30.0 ELSE 30.0/360.0 END " +
                    "ELSE CASE WHEN cmv.tipo_capitalizacion = 'Diaria' THEN 30.0/1.0 WHEN cmv.tipo_capitalizacion = 'Mensual' THEN 30.0/30.0 ELSE 30.0/360.0 END " +
                    "END " +
                    ") - 1.0)" +
                    "ELSE " +
                    "CASE " +
                    "WHEN cmv.peridiocidad_tasa = 'Mensual' THEN cmv.tasa_interes / 100.0 " +
                    "WHEN cmv.peridiocidad_tasa = 'Anual' THEN POW( (1.0 + (cmv.tasa_interes / 100.0)), (1.0/12.0) ) - 1.0 " +
                    "ELSE POW( (1.0 + (cmv.tasa_interes / 100.0)), (30.0) ) - 1.0 " +
                    "END " +
                    "END AS NUMERIC) " +

                    "WHERE cmv.id_credito = :id_credito"
    )
    void calcularYActualizarTEM(
            @Param("id_credito") Integer id_credito
    );

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            // *** CAMBIO: Usamos CALL para ejecutar el PROCEDURE ***
            value = "CALL generar_cronograma_pagos(:id_credito)"
    )
    void generarCronogramaPagos(@Param("id_credito") Integer id_credito);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            // *** CAMBIO: Usamos CALL para ejecutar el PROCEDURE ***
            value = "CALL calcular_van_tir(:id_credito)"
    )
    void calcularVanTir(@Param("id_credito") Integer id_credito);


    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "UPDATE credito_mi_vivienda " +
                    "SET " +
                    "    tea = POW( (1.0 + tem_requerido), 12) - 1.0, " + // TEA = (1 + TEM)^12 - 1
                    "    tcea = POW( (1.0 + tir), 12) - 1.0 " +           // TCEA = (1 + TIR)^12 - 1
                    "WHERE id_credito = :id_credito"
    )
    void convertirTasasAnuales(@Param("id_credito") Integer id_credito);

}


