package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.ItemDto;
import com.DySistemas.SistemaPadariaOnline.model.Item;
import com.DySistemas.SistemaPadariaOnline.repository.ItemRepository;
import com.DySistemas.SistemaPadariaOnline.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, ProdutoRepository produtoRepository) {
        this.itemRepository = itemRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Item salvar(ItemDto itemDto){
        try {
            Item item = new Item();
            item.setQtd(item.getQtd());
            item.setPrecoVenda(itemDto.precoVenda());
            item.setProduto(produtoRepository.findById(itemDto.idProduto()).get());
            return item;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Item buscar(int id){
        Item item = itemRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Item não encontrado"));

        return item;
    }

    public void excluir(int id){
        try {
            itemRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
