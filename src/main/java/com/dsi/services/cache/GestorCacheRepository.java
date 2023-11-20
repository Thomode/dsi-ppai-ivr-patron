package com.dsi.services.cache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorCacheRepository extends JpaRepository<GestorCache, Long> {

}
