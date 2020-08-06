package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.*;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import com.andriosi.fabio.vendas.services.VendaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("resources")
public class  VendaController {
    @Autowired
    private VendaFacade vendaFacade;
    @Autowired
    private ProdutoFacade produtoFacade;
    @Autowired
    private ClienteFacade clienteFacade;
    @GetMapping("/vendas")
    public ResponseEntity<List<Venda>> findAll(){
        return new ResponseEntity<>(vendaFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/venda")
    public @ResponseBody ResponseEntity<List<ProdutosVendidos>> cresteVenda(@RequestBody Venda venda) {
        try {
            Cliente cliente = clienteFacade.find(venda.getClientes().getId());
            if(venda.getProdutosVendidos().get(0).getProduto().getId() > 0) {
                Produto produto = produtoFacade.find(venda.getProdutosVendidos().get(0).getProduto().getId());
                produto.setQuantidade(produto.getQuantidade() - venda.getProdutosVendidos().get(0).getQuantidade());
                produtoFacade.edit(produto);
            }
            venda.setClientes(cliente);
            Venda v = vendaFacade.merge(venda);
            return new ResponseEntity<>(vendaFacade.find(v.getId()).getProdutosVendidos(), HttpStatus.OK);
        } catch (EntityExistsException ex) {
            System.out.println(ex.fillInStackTrace());
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping("/venda")
    public void deleteClintes(@RequestBody Venda venda){
        vendaFacade.remove(venda);
    }

    @PutMapping("/venda")
    public void updateCliente(@RequestBody Venda venda){
        vendaFacade.edit(venda);
    }
}
