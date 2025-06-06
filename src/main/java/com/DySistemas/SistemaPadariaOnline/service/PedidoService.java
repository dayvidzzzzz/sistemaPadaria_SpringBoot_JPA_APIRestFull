package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.PedidoDto;
import com.DySistemas.SistemaPadariaOnline.model.Encomenda;
import com.DySistemas.SistemaPadariaOnline.model.Item;
import com.DySistemas.SistemaPadariaOnline.model.Pedido;
import com.DySistemas.SistemaPadariaOnline.repository.EncomendaRepository;
import com.DySistemas.SistemaPadariaOnline.repository.ItemRepository;
import com.DySistemas.SistemaPadariaOnline.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final EncomendaRepository encomendaRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, EncomendaRepository encomendaRepository, ItemRepository itemRepository) {
        this.pedidoRepository = pedidoRepository;
        this.encomendaRepository = encomendaRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Pedido salvar(PedidoDto pedidoDto){
        try {
            Pedido pedido = new Pedido();
            pedido.setData(pedidoDto.data());
            pedido.setValorPedido(pedidoDto.valorPedido());
            pedido.setEncomenda(encomendaRepository.findById(pedidoDto.idEncomenda()).get());
            pedido.setItens((Set<Item>) itemRepository.findAllById(pedidoDto.idItens()));
            return pedido;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Pedido buscar(int id){
        Pedido pedido  = pedidoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return pedido ;
    }

    public void excluir(int id){
        try {
            pedidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
