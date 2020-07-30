package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.*;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import com.andriosi.fabio.vendas.services.VendaFacade;
import org.junit.Test;

import java.util.*;

public class VendaTest {
    @Test
    public void VendaTestA(){
        Produto produto = new ProdutoFacade().findAll().get(0);
        Produto produto1 = new ProdutoFacade().findAll().get(1);
        ProdutosVendidos pVendidos = new ProdutosVendidos();
        ProdutosVendidos pVendidos1 = new ProdutosVendidos();
        pVendidos.setProduto(produto);
        pVendidos.setQuantidade(3);
        pVendidos1.setProduto(produto1);
        pVendidos1.setQuantidade(1);
        Cliente cliente = new ClienteFacade().findAll().get(0);
        Venda  venda = new Venda();
        venda.setClientes(cliente);
        venda.setTipoPagamento(TipoPagamento.DINHEIRO);
        venda.setValorPago(78.00);
        venda.getProdutosVendidos().add(pVendidos);
        venda.getProdutosVendidos().add(pVendidos1);
        venda.setDataCompra(new GregorianCalendar(2020,7,15));
        venda.setDataCompra(new GregorianCalendar(2020,8,5));
        new VendaFacade().create(venda);
    }
    //@Test
    public void VendaTestB(){
        new VendaFacade().findAll().forEach(item ->{
            System.out.println(item.getProdutosVendidos());
        });
    }
}
