package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.ProdutoDto;
import com.DySistemas.SistemaPadariaOnline.model.Produto;
import com.DySistemas.SistemaPadariaOnline.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto salvar(ProdutoDto produtoDto){
        try {
            Produto produto = new Produto();
            produto.setDescricao(produtoDto.descricao());
            produto.setPrecoCompra(produtoDto.precoCompra());
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Produto buscar(int id){
        Produto produto = produtoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produto;
    }

    public void excluir(int id){
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Produto update(int id, ProdutoDto produtoDto){
        try {
            Produto produto = buscar(id);
            produto.setDescricao(produtoDto.descricao());
            produto.setPrecoCompra(produtoDto.precoCompra());
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
