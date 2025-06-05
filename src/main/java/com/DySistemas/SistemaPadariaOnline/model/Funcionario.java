package com.DySistemas.SistemaPadariaOnline.model;

import com.DySistemas.SistemaPadariaOnline.model.enus.Cargo;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false, unique = true)
    private String CPF;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Set<Encomenda> encomendas;

    public Funcionario(){
    }

    public Funcionario(String nome, String endereco, String email, String CPF, Cargo cargo, Set<Encomenda> encomendas) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.CPF = CPF;
        this.cargo = cargo;
        this.encomendas = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
}
