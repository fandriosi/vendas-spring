package com.andriosi.fabio.vendas.entity;

import javax.persistence.*;
import java.io.Serializable;
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
    private Double valorPago;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Cliente clientes;
    @OneToMany(fetch= FetchType.LAZY, cascade =CascadeType.ALL  )
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

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}
