package com.danilo.produto_catalago_api.infrastructure.repository;

import com.danilo.produto_catalago_api.infrastructure.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
