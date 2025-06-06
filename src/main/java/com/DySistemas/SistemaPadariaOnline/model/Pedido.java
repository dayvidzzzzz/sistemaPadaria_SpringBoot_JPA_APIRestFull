package com.DySistemas.SistemaPadariaOnline.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat
    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private long valorPedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "encomenda_id", referencedColumnName = "id")
    private Encomenda encomenda;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<Item> itens;

    public Pedido(){
    }

    public Pedido(LocalDate data, long valorPedido, Encomenda encomenda) {
        this.data = data;
        this.valorPedido = valorPedido;
        this.encomenda = encomenda;
        this.itens = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public long getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(long valorPedido) {
        this.valorPedido = valorPedido;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
}