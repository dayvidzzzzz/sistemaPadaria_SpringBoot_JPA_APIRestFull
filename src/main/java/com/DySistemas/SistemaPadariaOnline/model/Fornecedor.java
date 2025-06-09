package com.DySistemas.SistemaPadariaOnline.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String CNPJ;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private Set<Produto> produtos;

    public Fornecedor(){
    }

    public Fornecedor(String CNPJ, String razaoSocial, String endereco, String telefone) {
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.telefone = telefone;
        this.produtos = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPNJ() {
        return CNPJ;
    }

    public void setCPNJ(String CPNJ) {
        this.CNPJ = CPNJ;
    }

    public String getRasaoSocial() {
        return razaoSocial;
    }

    public void setRasaoSocial(String rasaoSocial) {
        this.razaoSocial = rasaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
