package com.danilo.produto_catalago_api.business.mapper;

import com.danilo.produto_catalago_api.business.dto.ProdutoDTO;
import com.danilo.produto_catalago_api.infrastructure.entity.Categoria;
import com.danilo.produto_catalago_api.infrastructure.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoConverter {

    @Mapping(source = "categoria.id", target = "categoriaId")
    ProdutoDTO paraDTO(Produto entity);

    @Mapping(source = "categoriaId", target = "categoria")
    Produto paraEntity(ProdutoDTO dto);

    default Categoria map(Long id) {
        if (id == null) {
            return null;
        }
        return Categoria.builder().id(id).build();
    }
}
