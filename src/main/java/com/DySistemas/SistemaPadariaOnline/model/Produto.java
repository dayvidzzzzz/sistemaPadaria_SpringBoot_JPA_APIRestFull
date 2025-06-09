package com.DySistemas.SistemaPadariaOnline.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private long precoCompra;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public Produto(){
    }

    public Produto(long precoCompra, String descricao, Fornecedor fornecedor) {
        this.precoCompra = precoCompra;
        this.descricao = descricao;
        this.items = new HashSet<>();
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(long precoCompra) {
        this.precoCompra = precoCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
