package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.ClienteDto;
import com.DySistemas.SistemaPadariaOnline.model.Cliente;
import com.DySistemas.SistemaPadariaOnline.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteServise {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServise(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente salvar(@RequestBody ClienteDto clienteDto){
        try{
            Cliente cliente = new Cliente();
            cliente.setNome(clienteDto.nome());
            cliente.setCPF(clienteDto.cpf());
            cliente.setEmail(clienteDto.email());
            cliente.setEndereco(clienteDto.endereco());
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Cliente buscarPorId(int id){
        Cliente cliente = clienteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return cliente;
    }

    public void excluir(int id){
        try {
            Cliente cliente = buscarPorId(id);
            clienteRepository.delete(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Cliente updateCliente(int idCliente, ClienteDto clienteDto){
        try{
            Cliente cliente = buscarPorId(idCliente);
            cliente.setEndereco(clienteDto.endereco());
            cliente.setCPF(clienteDto.cpf());
            cliente.setNome(clienteDto.nome());
            cliente.setEmail(clienteDto.email());
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
