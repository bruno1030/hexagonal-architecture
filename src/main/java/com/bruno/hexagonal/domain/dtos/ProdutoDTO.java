package com.bruno.hexagonal.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String sku;
    private String nome;
    private double preco;
    private double quantidade;

}
