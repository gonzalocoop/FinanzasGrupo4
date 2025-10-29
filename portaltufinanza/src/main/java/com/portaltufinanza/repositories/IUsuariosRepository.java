package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {
    public Usuarios findOneByUsername(String username);
}
