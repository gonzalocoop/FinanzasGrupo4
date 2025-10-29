package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropiedadRepository extends JpaRepository<Propiedad,Integer> {
}
