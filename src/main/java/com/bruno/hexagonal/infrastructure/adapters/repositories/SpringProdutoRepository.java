package com.bruno.hexagonal.infrastructure.adapters.repositories;

import com.bruno.hexagonal.infrastructure.adapters.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    Optional<ProdutoEntity> findBySku(String sku);

}
