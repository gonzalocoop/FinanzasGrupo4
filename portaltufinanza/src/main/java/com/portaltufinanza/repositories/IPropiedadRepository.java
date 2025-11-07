package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IPropiedadRepository extends JpaRepository<Propiedad,Integer> {

    @Query(
            value = "SELECT p FROM Propiedad p WHERE p.direccion = :direccion"
    )
    public List<Propiedad> propiedadSegunDireccion(@Param("direccion") String direccion);
}
