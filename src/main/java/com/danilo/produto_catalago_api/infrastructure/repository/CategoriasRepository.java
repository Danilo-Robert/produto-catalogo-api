package com.danilo.produto_catalago_api.infrastructure.repository;

import com.danilo.produto_catalago_api.infrastructure.entity.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasEntity, Long> {
}
