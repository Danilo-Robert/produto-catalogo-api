package com.danilo.produto_catalago_api.business.mapper;

import com.danilo.produto_catalago_api.business.dto.CategoriaDTO;
import com.danilo.produto_catalago_api.infrastructure.entity.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaConverter {

    CategoriaDTO paraDTO(Categoria entity);

    Categoria paraEntity(CategoriaDTO dto);
}
