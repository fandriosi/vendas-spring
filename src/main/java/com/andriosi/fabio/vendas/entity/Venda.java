package com.andriosi.fabio.vendas.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"clientes_id","dataCompra","dataRecebimento"}))
public class Venda implements Serializable {
    private static final long serialVersionUID = 123456789L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Calendar dataCompra;
    @Temporal(TemporalType.DATE)
    private Calendar dataRecebimento;
    private TipoPagamento tipoPagamento;
    @Column(precision = 10, scale = 2, nullable = true)
    @Type(type = "big_decimal")
    private BigDecimal valorPago;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Cliente clientes;
    @OneToMany(fetch= FetchType.EAGER, cascade =CascadeType.ALL  )
    @JoinColumn(name = "fk_produtosvendidos")
    private List<ProdutosVendidos> produtosVendidos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public List<ProdutosVendidos> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutosVendidos> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Calendar getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Calendar dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal  valorPago) {
        this.valorPago = valorPago;
    }
}
