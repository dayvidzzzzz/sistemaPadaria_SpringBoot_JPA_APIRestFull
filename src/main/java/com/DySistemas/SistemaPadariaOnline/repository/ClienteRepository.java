package com.DySistemas.SistemaPadariaOnline.repository;

import com.DySistemas.SistemaPadariaOnline.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
