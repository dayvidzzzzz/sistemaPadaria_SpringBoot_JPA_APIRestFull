package com.DySistemas.SistemaPadariaOnline.repository;

import com.DySistemas.SistemaPadariaOnline.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
