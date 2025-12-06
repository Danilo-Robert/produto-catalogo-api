package com.danilo.produto_catalago_api.controller;

import com.danilo.produto_catalago_api.business.ProdutoService;
import com.danilo.produto_catalago_api.business.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto){
        return ResponseEntity.ok(produtoService.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@RequestBody ProdutoDTO dto,
                                                @PathVariable Long id){
        return ResponseEntity.ok(produtoService.atualizar(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
