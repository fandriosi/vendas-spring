package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.*;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import com.andriosi.fabio.vendas.services.VendaFacade;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class VendaTest {
    //@Test
    public void VendaTestA(){
        Produto produto = new Produto();
        Produto produto1 = new Produto();
        ProdutosVendidos pVendidos = new ProdutosVendidos();
        ProdutosVendidos pVendidos1 = new ProdutosVendidos();
        produto.setId(50L);
        produto1.setId(48L);
        pVendidos.setQuantidade(3);
        pVendidos.setProduto(produto);
        pVendidos1.setProduto(produto1);
        pVendidos1.setQuantidade(1);
        Venda  venda = new Venda();
        Cliente cliente = new ClienteFacade().find(40l);
        venda.setClientes(cliente);
        venda.setTipoPagamento(TipoPagamento.DINHEIRO);
        venda.setValorPago(BigDecimal.valueOf(78.00));
        venda.getProdutosVendidos().add(pVendidos);
        venda.getProdutosVendidos().add(pVendidos1);
        venda.setDataCompra(new GregorianCalendar(2020,8,15));
        venda.setDataRecebimento(new GregorianCalendar(2020,8,15));
        new VendaFacade().create(venda);
    }
    //@Test
    public void VendaTestB(){
        new VendaFacade().findAll().forEach(item ->{
            System.out.println(item.getProdutosVendidos());
        });
    }
}
