package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonedaRepository extends JpaRepository<Moneda,Integer> {
}
