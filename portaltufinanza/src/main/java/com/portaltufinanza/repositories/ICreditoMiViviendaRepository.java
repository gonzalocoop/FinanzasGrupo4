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
                    "cuota_inicial, duracion_gracia_meses, fecha_fin, fecha_inicio, m_numero_capitalizaciones, " +
                    "n_numero_periodos, numero_cuotas, peridiocidad_tasa, saldo_inicial, tasa_interes, tcea, tea, " +
                    "tem_requerido, tipo_capitalizacion, tipo_gracia, tipo_tasa, tir, van, " +
                    "id_precio_correspondiente, id_propiedad, id_usuario) " +
                    "SELECT " +
                    "pc.cuota_inicial, :duracion_gracia_meses, '2099-12-31', :fecha_inicio, 0, " +
                    "0, :numero_cuotas, :peridiocidad_tasa, pc.precio_calculado, :tasa_interes, 0, 0, " +
                    "0, NULLIF(:tipo_capitalizacion, 'Nulo'), :tipo_gracia, :tipo_tasa, 0, 0, " +
                    ":id_precio_correspondiente, pc.id_propiedad, :id_usuario " + // <-- pc.id_propiedad usado aquí
                    "FROM precio_correspondiente pc " +
                    "WHERE pc.id_precio_correspondiente = :id_precio_correspondiente",
            nativeQuery = true
    )
    void registrarCreditoMiVivienda(
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



}
