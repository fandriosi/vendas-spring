package com.andriosi.fabio.vendas.entity;

import javax.persistence.*;

@Entity
public class ProdutosVendidos {
    private static final long serialVersionUID = 123456789L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantidade;
    @OneToOne
    private Produto produto;
    @Transient
    private Long codigoVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Long codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
}
