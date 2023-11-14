package com.dsi.Repositories;

import com.dsi.Entities.CategoriaLlamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaLlamadaRepository extends JpaRepository<CategoriaLlamada, Integer> {
}
