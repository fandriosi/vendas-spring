package com.andriosi.fabio.vendas.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 456123789L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(unique = true)
    private Integer codigoBarra;
    @Column(unique = true)
    private  String descricao;
    @NumberFormat(pattern = "###,###.##")
    private Double precoCusto;
    @NumberFormat(pattern = "###,###.##")
    private Double preco;
    @OneToOne(fetch = FetchType.EAGER)
    public Categoria categoria;
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
        this.descricao = new StringCapitalize().getCapitalize(descricao);
    }

    public Integer getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(Integer codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
