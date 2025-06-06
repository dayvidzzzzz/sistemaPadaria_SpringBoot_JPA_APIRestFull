package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.EncomendaDto;
import com.DySistemas.SistemaPadariaOnline.model.Encomenda;
import com.DySistemas.SistemaPadariaOnline.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmcomendaService {

    private final EncomendaRepository encomendaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public EmcomendaService(EncomendaRepository encomendaRepository, FuncionarioRepository funcionarioRepository, ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.encomendaRepository = encomendaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public Encomenda salvar(EncomendaDto encomendaDto){
        try {
            Encomenda encomenda = new Encomenda();
            encomenda.setData(encomendaDto.data());
            encomenda.setValorTotal(encomendaDto.valorTotal());
            encomenda.setCliente(clienteRepository.findById(encomendaDto.idCliente()).get());
            encomenda.setFuncionario(funcionarioRepository.findById(encomendaDto.idFuncionario()).get());
            encomenda.setPedido(pedidoRepository.findById(encomendaDto.idPedido()).get());
            return encomenda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Encomenda buscar(int id){
        Encomenda encomenda = encomendaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Encomenda não encontrada"));
        return encomenda;
    }

    public void excluir(int id){
        try {
            Encomenda encomenda = buscar(id);
            encomendaRepository.delete(encomenda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Encomenda> listaEncomendas(){
        try {
            return encomendaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
