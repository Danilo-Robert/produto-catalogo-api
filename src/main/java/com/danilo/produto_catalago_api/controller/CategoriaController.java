package com.danilo.produto_catalago_api.controller;

import com.danilo.produto_catalago_api.business.CategoriaService;
import com.danilo.produto_catalago_api.business.dto.CategoriaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
@Tag(name = "Categorias", description = "Gerenciamento de categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;


    @PostMapping
    @Operation(summary = "Criar categoria", description = "Cria uma nova categoria")
    @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO dto){
        return ResponseEntity.ok(categoriaService.criar(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Busca a categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria localizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Categoria", description = "Atualiza a categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id,
                                                  @RequestBody CategoriaDTO dto){
        return ResponseEntity.ok(categoriaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Categoria", description = "Deleta a categoria")
    @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}