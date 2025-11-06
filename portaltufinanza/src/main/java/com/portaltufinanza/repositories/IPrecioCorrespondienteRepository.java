package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.PrecioCorrespondiente;
import com.portaltufinanza.entities.Propiedad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrecioCorrespondienteRepository extends JpaRepository<PrecioCorrespondiente,Integer> {

    @Query(
            value = "SELECT pc FROM PrecioCorrespondiente pc " +
                    "JOIN pc.propiedad p " +
                    "WHERE p.direccion = :direccion"
    )
    public List<PrecioCorrespondiente> precioSegunDireccionPropiedad(@Param("direccion") String direccion);


    @Transactional
    @Modifying
    @Query(
            // SQL Nativo para insertar una nueva fila
            value = "INSERT INTO precio_correspondiente (cuota_inicial, precio_calculado, id_bono, id_moneda, id_propiedad) " +
                    "SELECT " +
                    // 1. cuota_inicial = 0.075 * precio_propiedad
                    "p.precio_propiedad * 0.075, " +

                    // 2. precio_calculado = precio_propiedad - cuota_inicial
                    "p.precio_propiedad - (p.precio_propiedad * 0.075), " +

                    // 3. id_bono: Lógica condicional (CASE WHEN) basada en precio_propiedad
                    "CASE " +
                    "WHEN p.precio_propiedad >= 58800 AND p.precio_propiedad < 84100 THEN 1 " +
                    "WHEN p.precio_propiedad >= 84100 AND p.precio_propiedad < 125900 THEN 2 " +
                    "WHEN p.precio_propiedad >= 125900 AND p.precio_propiedad < 209800 THEN 3 " +
                    "WHEN p.precio_propiedad >= 209800 AND p.precio_propiedad < 310800 THEN 4 " +
                    "ELSE 5 " +
                    "END, " +

                    // 4. id_moneda (Parámetro de entrada)
                    ":id_moneda, " +

                    // 5. id_propiedad (Parámetro de entrada)
                    ":id_propiedad " +

                    // Selecciona el precio_propiedad de la tabla propiedad usando el id_propiedad
                    "FROM propiedad p " +
                    "WHERE p.id_propiedad = :id_propiedad",

            nativeQuery = true
    )
    public void registrarPrecioCorrespondiente(@Param("id_propiedad") Integer id_propiedad, @Param("id_moneda") Integer id_moneda);

}
