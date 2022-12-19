package com.bruno.hexagonal.domain.ports.repositories;

import com.bruno.hexagonal.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

    Produto buscarPeloSku(String sku);

    void salvar(Produto produto);

}
