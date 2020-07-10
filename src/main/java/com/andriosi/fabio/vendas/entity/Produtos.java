package com.andriosi.fabio.vendas.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produtos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int codigoBarra;
    @Column
    private  String descricao;
    @Column
    private double precoCusto;
    @Column
    private double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
