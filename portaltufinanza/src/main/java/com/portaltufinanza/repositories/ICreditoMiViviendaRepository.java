package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.CreditoMiVivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditoMiViviendaRepository extends JpaRepository<CreditoMiVivienda,Integer> {
}
