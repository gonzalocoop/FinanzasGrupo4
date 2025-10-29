package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles,Integer> {
}
