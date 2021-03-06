package com.andriosi.fabio.vendas.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    @Column(precision = 10, scale = 2)
    @Type(type = "big_decimal")
    private BigDecimal valorTotal;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Cliente clientes;
    @OneToMany(fetch= FetchType.EAGER, cascade =CascadeType.ALL  )
    @JoinColumn(name = "fk_produtosvendidos")
    private List<ProdutosVendidos> produtosVendidos = new ArrayList<>();
    @ColumnDefault("0.0")
    private BigDecimal desconto;
    @Transient
    private String strDataRecebimento;
    @Transient
    private String strDataCompra;
    @Transient
    private String strValorPago;
    @Transient
    private String strValorTotal;
    @Transient
    private String strDesconto;

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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getStrDataRecebimento() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        strDataRecebimento = fmt.format(dataRecebimento.getTime());
        return strDataRecebimento;
    }

    public String getStrDataCompra() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        strDataCompra = fmt.format(dataCompra.getTime());
        return strDataCompra;
    }

    public String getStrValorPago() {
        DecimalFormat currency = new DecimalFormat("'R$' 0.00");
        if(valorPago != null)
            strValorPago = currency.format(valorPago);
        return strValorPago;
    }

    public String getStrValorTotal() {
        DecimalFormat currency = new DecimalFormat("'R$' 0.00");
        if(valorTotal != null)
            strValorTotal = currency.format(valorTotal);
        return strValorTotal;
    }
    public String getStrDesconto() {
        DecimalFormat currency = new DecimalFormat("'R$' 0.00");
        if(desconto != null)
            strDesconto = currency.format(desconto);
        return strDesconto;
    }
}
