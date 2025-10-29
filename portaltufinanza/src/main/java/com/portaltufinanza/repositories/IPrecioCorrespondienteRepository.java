package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.PrecioCorrespondiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrecioCorrespondienteRepository extends JpaRepository<PrecioCorrespondiente,Integer> {
}
