package com.danilo.produto_catalago_api.infrastructure.repository;

import com.danilo.produto_catalago_api.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNome(String nome);
}
