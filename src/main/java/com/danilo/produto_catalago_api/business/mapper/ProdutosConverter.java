package com.danilo.produto_catalago_api.business.mapper;

import com.danilo.produto_catalago_api.business.dto.ProdutosDTO;
import com.danilo.produto_catalago_api.infrastructure.entity.ProdutosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutosConverter {

    ProdutosEntity paraEntity(ProdutosDTO dto);

    ProdutosDTO paraDTO(ProdutosEntity entity);
}
