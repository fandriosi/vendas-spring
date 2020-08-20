package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.*;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import com.andriosi.fabio.vendas.services.VendaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody ResponseEntity<List<ProdutosVendidos>> creteVenda(@RequestBody Venda venda) {
        venda.setClientes(clienteFacade.find(venda.getClientes().getId()));
        Venda v = vendaFacade.merge(venda);
        List<ProdutosVendidos> list = vendaFacade.find(v.getId()).getProdutosVendidos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/venda")
    public ResponseEntity<List<ProdutosVendidos>> deleteVenda(@RequestBody Venda venda){
        vendaFacade.remove(venda);
        return new ResponseEntity<>(vendaFacade.find(venda.getId()).getProdutosVendidos(), HttpStatus.OK);
    }

    @PutMapping("/venda")
    public ResponseEntity<List<ProdutosVendidos>> updateVenda(@RequestBody Venda venda){
        vendaFacade.edit(venda);
        List<ProdutosVendidos> list =vendaFacade.find(venda.getId()).getProdutosVendidos();
        list.stream().forEach(item ->{
            item.setCodigoVenda(venda.getId());
        });
        return new ResponseEntity<>(vendaFacade.find(venda.getId()).getProdutosVendidos(), HttpStatus.OK);
    }
}
