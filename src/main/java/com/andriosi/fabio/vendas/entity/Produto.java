package com.andriosi.fabio.vendas.entity;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

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
    @Column(precision = 10, scale = 2)
    @Type(type = "big_decimal")
    private BigDecimal precoCusto;
    @Column(precision = 10, scale = 2)
    @Type(type = "big_decimal")
    private BigDecimal preco;
    @OneToOne(fetch = FetchType.EAGER)
    public Categoria categoria;
    private Integer quantidade;
    @ColumnDefault("0")
    private Integer estoque;
    @Transient
    private String strPreco;
    @Transient
    private String strPrecoCusto;
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

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getStrPreco() {
        DecimalFormat currency = new DecimalFormat("'R$' 0.00");
        strPreco = currency.format(preco);
        return strPreco;
    }
    public String getStrPrecoCusto() {
        DecimalFormat currency = new DecimalFormat("'R$' 0.00");
        strPrecoCusto = currency.format(precoCusto);
        return strPrecoCusto;
    }
}
