package com.bruno.hexagonal.domain.ports.interfaces;

import com.bruno.hexagonal.domain.dtos.EstoqueDTO;
import com.bruno.hexagonal.domain.dtos.ProdutoDTO;
import com.bruno.hexagonal.domain.exceptions.ProdutoNotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    void criarProduto(ProdutoDTO produtoDTO);

    List<ProdutoDTO> buscarProdutos();

    void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ProdutoNotFoundException;

}
