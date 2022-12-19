package com.bruno.hexagonal.infrastructure.adapters.entities;

import com.bruno.hexagonal.domain.Produto;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;
    private String sku;
    private String nome;
    private double preco;
    private double quantidade;

    public ProdutoEntity(){

    }

    public Produto toProduto(){
        return new Produto(this.codigo, this.sku, this.nome, this.preco, this.quantidade);
    }

    public ProdutoEntity(Produto produto){
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }

    public void atualizar(Produto produto){
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }

}
