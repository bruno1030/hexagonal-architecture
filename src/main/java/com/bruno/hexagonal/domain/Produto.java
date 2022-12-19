package com.bruno.hexagonal.domain;

import com.bruno.hexagonal.domain.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private UUID codigo;
    private String sku;
    private String nome;
    private double preco;
    private double quantidade;

    public Produto(ProdutoDTO produtoDTO){
        this.sku = produtoDTO.getSku();
        this.nome = produtoDTO.getNome();
        this.preco = produtoDTO.getPreco();
        this.quantidade = produtoDTO.getQuantidade();
    }

    public void atualizarEstoque(double novaQuantiade){
        this.quantidade = novaQuantiade;
    }

    public ProdutoDTO toProdutoDTO(){
        return new ProdutoDTO(this.sku, this.nome, this.preco, this.quantidade);
    }

}
