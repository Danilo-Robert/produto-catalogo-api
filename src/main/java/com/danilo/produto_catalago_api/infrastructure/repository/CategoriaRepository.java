package com.danilo.produto_catalago_api.infrastructure.repository;

import com.danilo.produto_catalago_api.infrastructure.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
