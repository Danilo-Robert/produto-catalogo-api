package com.danilo.produto_catalago_api.business.mapper;

import com.danilo.produto_catalago_api.business.dto.ProdutoDTO;
import com.danilo.produto_catalago_api.infrastructure.entity.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoConverter {

    Produto paraEntity(ProdutoDTO dto);

    ProdutoDTO paraDTO(Produto entity);
}
