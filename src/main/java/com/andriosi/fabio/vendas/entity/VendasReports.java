package com.andriosi.fabio.vendas.entity;

import java.math.BigDecimal;

public class VendasReports {
    private BigDecimal totalValorPago;
    private BigDecimal totalValorTotal;

    public BigDecimal getTotalValorPago() {
        return totalValorPago;
    }

    public void setTotalValorPago(BigDecimal totalValorPago) {
        this.totalValorPago = totalValorPago;
    }

    public BigDecimal getTotalValorTotal() {
        return totalValorTotal;
    }

    public void setTotalValorTotal(BigDecimal totalValorTotal) {
        this.totalValorTotal = totalValorTotal;
    }
}
