package com.dsi.repositories;

import com.dsi.Entities.SubOpcionLlamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOpcionLlamadaRepository extends JpaRepository<SubOpcionLlamada, Integer> {
}
