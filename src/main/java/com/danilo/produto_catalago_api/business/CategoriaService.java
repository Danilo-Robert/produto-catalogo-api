package com.danilo.produto_catalago_api.business;

import com.danilo.produto_catalago_api.business.dto.CategoriaDTO;
import com.danilo.produto_catalago_api.business.mapper.CategoriaConverter;
import com.danilo.produto_catalago_api.infrastructure.entity.Categoria;
import com.danilo.produto_catalago_api.infrastructure.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaConverter categoriaConverter;

    public CategoriaDTO criar(CategoriaDTO dto){
        Categoria entity = categoriaConverter.paraEntity(dto);
        return categoriaConverter.paraDTO(categoriaRepository.save(entity));
    }

    public CategoriaDTO buscarPorId(Long id){
        Categoria entity = categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria não encontrada"));
        return categoriaConverter.paraDTO(entity);
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO dto){
        Categoria entity = categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria não encontrada"));
        entity.setNome(dto.getNome());
        return categoriaConverter.paraDTO(categoriaRepository.save(entity));
    }

    public void deletar(Long id){
        if (!categoriaRepository.existsById(id)){
            throw new RuntimeException("Categoria não encontrada");
        }
        categoriaRepository.deleteById(id);
    }
}
