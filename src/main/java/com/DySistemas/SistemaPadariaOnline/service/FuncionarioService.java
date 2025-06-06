package com.DySistemas.SistemaPadariaOnline.service;

import com.DySistemas.SistemaPadariaOnline.dto.FuncionarioDto;
import com.DySistemas.SistemaPadariaOnline.model.Funcionario;
import com.DySistemas.SistemaPadariaOnline.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario salvar(FuncionarioDto funcionarioDto) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(funcionarioDto.nome());
            funcionario.setEndereco(funcionarioDto.endereco());
            funcionario.setEmail(funcionarioDto.email());
            funcionario.setCPF(funcionarioDto.cpf());
            funcionario.setCargo(funcionarioDto.cargo());
            return funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Funcionario buscarPorId(int id){
        Funcionario funcionario = funcionarioRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        return funcionario;
    }

    public void excluir(int id){
        try {
            Funcionario funcionario = buscarPorId(id);
            funcionarioRepository.delete(funcionario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Funcionario updateFuncionario(int idFuncionario, FuncionarioDto funcionarioDto){
        try{
            Funcionario funcionario = buscarPorId(idFuncionario);
            funcionario.setCargo(funcionarioDto.cargo());
            funcionario.setCPF(funcionarioDto.cpf());
            funcionario.setEmail(funcionarioDto.email());
            funcionario.setNome(funcionarioDto.nome());
            return funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> listarFuncionarios(){
        try {
            List<Funcionario> f = funcionarioRepository.findAll();
            return f;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
