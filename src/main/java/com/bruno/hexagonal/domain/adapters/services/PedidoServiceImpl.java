package com.bruno.hexagonal.domain.adapters.services;

import com.bruno.hexagonal.domain.Produto;
import com.bruno.hexagonal.domain.dtos.EstoqueDTO;
import com.bruno.hexagonal.domain.dtos.ProdutoDTO;
import com.bruno.hexagonal.domain.exceptions.ProdutoNotFoundException;
import com.bruno.hexagonal.domain.ports.interfaces.ProdutoServicePort;
import com.bruno.hexagonal.domain.ports.repositories.ProdutoRepositoryPort;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PedidoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public PedidoServiceImpl(ProdutoRepositoryPort produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtosDBList = produtoRepository.buscarTodos();
        List<ProdutoDTO> produtosDTOList = produtosDBList.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtosDTOList;
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ProdutoNotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if(Objects.isNull(produto))
            throw new ProdutoNotFoundException("Produto nao encontrato, logo nao podera ser atualizado seu estoque");

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);

    }
}
