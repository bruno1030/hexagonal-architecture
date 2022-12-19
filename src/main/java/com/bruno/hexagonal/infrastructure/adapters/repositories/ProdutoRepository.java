package com.bruno.hexagonal.infrastructure.adapters.repositories;

import com.bruno.hexagonal.domain.Produto;
import com.bruno.hexagonal.domain.exceptions.ProdutoNotFoundException;
import com.bruno.hexagonal.domain.ports.repositories.ProdutoRepositoryPort;
import com.bruno.hexagonal.infrastructure.adapters.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository){
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtosEntity = this.springProdutoRepository.findAll();
        List<Produto> produtos = produtosEntity.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
        return produtos;
    }

    @Override
    public Produto buscarPeloSku(String sku) {
        Optional<ProdutoEntity> produtoEntity = this.springProdutoRepository.findBySku(sku);

        if(produtoEntity.isPresent())
            return produtoEntity.get().toProduto();

        throw new ProdutoNotFoundException("Produto nao existe");
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        this.springProdutoRepository.save(produtoEntity);
    }
}
