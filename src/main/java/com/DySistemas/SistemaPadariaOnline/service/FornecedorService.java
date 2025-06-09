package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.FornecedorDto;
import com.DySistemas.SistemaPadariaOnline.model.Fornecedor;
import com.DySistemas.SistemaPadariaOnline.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public Fornecedor salvar(FornecedorDto fornecedorDto){
        try {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCPNJ(fornecedorDto.CPNJ());
            fornecedor.setEndereco(fornecedorDto.endereco());
            fornecedor.setTelefone(fornecedorDto.telefone());
            fornecedor.setRasaoSocial(fornecedorDto.rasaoSocial());
            return fornecedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fornecedor buscar(int id){
        Fornecedor fornecedor = fornecedorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        return fornecedor;
    }

    public void excluir(int id){
        try {
            fornecedorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fornecedor update(int id, FornecedorDto fornecedorDto){
        try {
            Fornecedor fornecedor = buscar(id);
            fornecedor.setRasaoSocial(fornecedorDto.rasaoSocial());
            fornecedor.setEndereco(fornecedorDto.endereco());
            fornecedor.setCPNJ(fornecedorDto.CPNJ());
            fornecedor.setTelefone(fornecedorDto.telefone());

            return fornecedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
