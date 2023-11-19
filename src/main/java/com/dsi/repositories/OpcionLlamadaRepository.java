package com.dsi.repositories;

import com.dsi.Entities.OpcionLlamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionLlamadaRepository extends JpaRepository<OpcionLlamada, Integer> {
}
