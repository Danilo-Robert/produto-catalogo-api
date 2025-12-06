package com.danilo.produto_catalago_api.business;

import com.danilo.produto_catalago_api.business.dto.ProdutoDTO;
import com.danilo.produto_catalago_api.business.mapper.ProdutoConverter;
import com.danilo.produto_catalago_api.infrastructure.entity.Categoria;
import com.danilo.produto_catalago_api.infrastructure.entity.Produto;
import com.danilo.produto_catalago_api.infrastructure.exceptions.ResourceNotFoundException;
import com.danilo.produto_catalago_api.infrastructure.repository.CategoriaRepository;
import com.danilo.produto_catalago_api.infrastructure.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoConverter produtoConverter;

    public ProdutoDTO criar(ProdutoDTO dto){
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(
                () -> new ResourceNotFoundException("Categoria não encontrada"));
        Produto entity = produtoConverter.paraEntity(dto);
        entity.setCategoria(categoria);
        produtoRepository.save(entity);

        ProdutoDTO retorno = produtoConverter.paraDTO(entity);
        retorno.setCategoriaId(categoria.getId());
        return retorno;
    }

    public ProdutoDTO buscarPorId(Long id){
        Produto entity = produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado"));
        ProdutoDTO dto = produtoConverter.paraDTO(entity);
        dto.setCategoriaId(entity.getCategoria().getId());
        return dto;
    }

    public ProdutoDTO atualizar(ProdutoDTO dto, Long id){
        Produto entity = produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado"));

        Categoria catEntity = categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(
                () -> new ResourceNotFoundException("Categoria não encontrada"));

        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setCategoria(catEntity);

        produtoRepository.save(entity);

        ProdutoDTO retorno = produtoConverter.paraDTO(entity);
        retorno.setCategoriaId(catEntity.getId());
        return retorno;
    }

    public void deletar(Long id){
        if (!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
