package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {
    public Usuarios findOneByUsername(String username);

    @Query(value="SELECT u.nombre_cliente, p.*\n" +
            "FROM usuarios u\n" +
            "JOIN credito_mi_vivienda c ON c.id_usuario = u.id_usuario\n" +
            "JOIN propiedad p ON p.id_propiedad = c.id_propiedad\n" +
            "WHERE u.id_usuario = :id_usuario;",nativeQuery = true)
    public List<String[]> PropiedadesFinanciadasPorUsuario(@Param("id_usuario")Integer id_usuario);

    @Query(value="SELECT u.nombre_cliente, cr.*\n" +
            "FROM usuarios u\n" +
            "JOIN credito_mi_vivienda c  ON c.id_usuario  = u.id_usuario\n" +
            "JOIN cronograma_pagos   cr ON cr.id_credito  = c.id_credito\n" +
            "WHERE u.id_usuario = :id_usuario;", nativeQuery = true)
    public List<String[]> CronogramadePagosPorUsuario(@Param("id_usuario")Integer id_usuario);

    @Query(value = "SELECT u.nombre_cliente, pre.cuota_inicial, pre.precio_calculado, pre.costos_notariales, pre.registros_publicos, pre.costos_transaccion, \n" +
            "bn.monto_bono, pro.precio_propiedad, mon.nombre_moneda\n" +
            "FROM usuarios u\n" +
            "JOIN credito_mi_vivienda c ON c.id_usuario = u.id_usuario\n" +
            "JOIN precio_correspondiente pre ON pre.id_precio_correspondiente = c.id_precio_correspondiente\n" +
            "JOIN propiedad pro ON pro.id_propiedad = pre.id_propiedad \n" +
            "JOIN bonobbp bn ON bn.id_bono = pre.id_bono\n" +
            "JOIN moneda mon ON mon.id_moneda = pre.id_moneda\n" +
            "WHERE u.id_usuario = :id_usuario", nativeQuery = true)
    public List<String[]> PrecioCorrespondientePorPropiedadPorUsuario(@Param("id_usuario")Integer id_usuario);

    @Query (value="SELECT \n" +
            "\tu.nombre_cliente,\n" +
            "    c.id_credito,\n" +
            "    c.tir,\n" +
            "    c.cok,\n" +
            "    ROUND(c.tir - c.cok, 4) AS margen_rentabilidad,\n" +
            "    CASE\n" +
            "        WHEN c.tir > c.cok THEN 'Rentable'\n" +
            "        WHEN c.tir = c.cok THEN 'Neutro'\n" +
            "        ELSE 'No rentable'\n" +
            "    END AS estado_credito,\n" +
            "    p.direccion,\n" +
            "    c.van,\n" +
            "    c.tasa_interes,\n" +
            "    c.numero_cuotas\n" +
            "FROM credito_mi_vivienda c\n" +
            "JOIN usuarios u ON u.id_usuario = c.id_usuario\n" +
            "JOIN propiedad p ON c.id_propiedad = p.id_propiedad\n",nativeQuery = true)
    public List<String[]> AnalisisdeRentabilidadPorCreditodeUsuario();



    @Query(value = "SELECT id_credito, tipo_gracia, duracion_gracia_meses, numero_cuotas\n" +
            "FROM credito_mi_vivienda\n" +
            "WHERE id_usuario = :id_usuario\n" +
            "  AND tipo_gracia <> 'Ninguno'",nativeQuery = true)
    public List<String[]> CreditosPorUsuarioConPeriododeGracia(@Param("id_usuario")Integer id_usuario);

    @Query(value = "SELECT \n" +
            "u.id_usuario,\n"+
            "          u.nombre_cliente,                \n" +
            "            p.direccion,                    \n" +
            "            p.precio_propiedad,                \n" +
            "            m.nombre_moneda,                \n" +
            "            c.saldo_inicial as monto_prestamo,                \n" +
            "            c.cuota_inicial,              \n" +
            "            c.tasa_interes,               \n" +
            "            c.numero_cuotas,             \n" +
            "            c.fecha_inicio,                \n" +
            "            c.tir,                         \n" +
            "            c.cok,                        \n" +
            "            c.van,                       \n" +
            "            c.tcea,\n" +
            "\t\t\tCASE\n" +
            "\t\t\t\tWHEN c.tir > c.cok THEN 'Rentable'\n" +
            "\t\t\t\telse 'No rentable'\n" +
            "\t\t\tend as estado_credito,\n" +
            "\t\t\t(SELECT COALESCE(SUM(cp.interes_cuota), 0) FROM cronograma_pagos cp WHERE cp.id_credito = c.id_credito) AS total_intereses,\n" +
            "            (SELECT cp.cuota_fija\n" +
            "             FROM cronograma_pagos cp\n" +
            "             WHERE cp.id_credito = c.id_credito\n" +
            "             AND cp.numero_cuota = (COALESCE(c.duracion_gracia_meses, 0) + 1)\n" +
            "             LIMIT 1) AS cuota_mensual_representativa\n" +
            "        FROM credito_mi_vivienda c           \n" +
            "        JOIN usuarios u ON u.id_usuario = c.id_usuario \n" +
            "        JOIN propiedad p ON c.id_propiedad = p.id_propiedad \n" +
            "        JOIN precio_correspondiente pc ON c.id_precio_correspondiente = pc.id_precio_correspondiente \n" +
            "        JOIN moneda m ON pc.id_moneda = m.id_moneda"+
            "\t\tWHERE u.id_usuario = :id_usuario\n", nativeQuery = true)
    public List<String[]> ObtenerResumenFinancieroUsuario(@Param("id_usuario") Integer id_usuario);
}
