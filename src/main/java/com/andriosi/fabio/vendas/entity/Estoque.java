package com.andriosi.fabio.vendas.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Estoque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produtos produtos;

    @Column
    private int qauntidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQauntidade() {
        return qauntidade;
    }

    public void setQauntidade(int qauntidade) {
        this.qauntidade = qauntidade;
    }
}
