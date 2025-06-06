package com.DySistemas.SistemaPadariaOnline.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int qtd;

    @Column(nullable = false)
    private long precoVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Item(){
    }

    public Item(int qtd, long precoVenda, Pedido pedido, Produto produto) {
        this.qtd = qtd;
        this.precoVenda = precoVenda;
        this.pedido = pedido;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public long getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(long precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
