package com.dsi.Repositories;

import com.dsi.Entities.InformacionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionClienteRepository extends JpaRepository<InformacionCliente, Integer> {
}
