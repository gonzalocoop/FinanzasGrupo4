package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.CronogramaPagos;
import com.portaltufinanza.entities.PrecioCorrespondiente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICronogramaPagosRepository extends JpaRepository<CronogramaPagos,Integer> {

    @Query(
            value = "SELECT cp FROM CronogramaPagos cp " +
                    "JOIN cp.credito c " +
                    "WHERE c.id_credito = :id_credito"
    )
    public List<CronogramaPagos> TodosCronogramasDeUnCredito(@Param("id_credito") Integer id_credito);
}
