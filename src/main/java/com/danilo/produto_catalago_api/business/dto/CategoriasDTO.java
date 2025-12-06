package com.danilo.produto_catalago_api.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriasDTO {

    private Long id;
    private String nome;
}