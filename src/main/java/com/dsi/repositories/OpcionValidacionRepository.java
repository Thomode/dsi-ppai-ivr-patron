package com.dsi.repositories;

import com.dsi.Entities.OpcionValidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionValidacionRepository extends JpaRepository<OpcionValidacion, Integer> {
}
