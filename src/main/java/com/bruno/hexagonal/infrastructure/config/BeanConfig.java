package com.bruno.hexagonal.infrastructure.config;

import com.bruno.hexagonal.domain.adapters.services.PedidoServiceImpl;
import com.bruno.hexagonal.domain.ports.interfaces.ProdutoServicePort;
import com.bruno.hexagonal.domain.ports.repositories.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort){
        return new PedidoServiceImpl(produtoRepositoryPort);
    }

}
