package com.bruno.hexagonal.application.adapters.controllers;


import com.bruno.hexagonal.domain.dtos.EstoqueDTO;
import com.bruno.hexagonal.domain.dtos.ProdutoDTO;
import com.bruno.hexagonal.domain.ports.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort){
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void createProduto(@RequestBody ProdutoDTO produtoDTO){
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos(){
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value="/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO){
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }

}
