package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.BonoBBP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBonoBBPRepository extends JpaRepository<BonoBBP,Integer> {
}
