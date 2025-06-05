package com.DySistemas.SistemaPadariaOnline.repository;

import com.DySistemas.SistemaPadariaOnline.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
