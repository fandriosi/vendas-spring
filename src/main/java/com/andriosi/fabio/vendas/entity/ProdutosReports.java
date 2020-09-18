package com.andriosi.fabio.vendas.entity;

import java.math.BigDecimal;

public class ProdutosReports {
    private BigDecimal totalPrecoCusto;
    private BigDecimal totalPreco;

    public BigDecimal getTotalPrecoCusto() {
        return totalPrecoCusto;
    }

    public void setTotalPrecoCusto(BigDecimal totalPrecoCusto) {
        this.totalPrecoCusto = totalPrecoCusto;
    }

    public BigDecimal getTotalPreco() {
        return totalPreco;
    }

    public void setTotalPreco(BigDecimal totalPreco) {
        this.totalPreco = totalPreco;
    }

}
