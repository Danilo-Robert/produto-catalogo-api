package com.danilo.produto_catalago_api.business.mapper;

import com.danilo.produto_catalago_api.business.dto.CategoriasDTO;
import com.danilo.produto_catalago_api.infrastructure.entity.CategoriasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriasConverter {

    CategoriasEntity paraEntity(CategoriasDTO dto);

    CategoriasDTO paraDTO(CategoriasEntity entity);
}
