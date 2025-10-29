package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.CronogramaPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICronogramaPagosRepository extends JpaRepository<CronogramaPagos,Integer> {
}
