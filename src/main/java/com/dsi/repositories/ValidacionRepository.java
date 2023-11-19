package com.dsi.repositories;

import com.dsi.Entities.Validacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacionRepository extends JpaRepository<Validacion, Integer> {
}
