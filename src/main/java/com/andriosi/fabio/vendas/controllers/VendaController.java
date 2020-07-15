package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Venda;
import com.andriosi.fabio.vendas.services.VendaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  VendaController {
    @Autowired
    private VendaFacade vendaFacade;
    @GetMapping("/venda")
    public ResponseEntity<List<Venda>> findAll(){
        return new ResponseEntity<>(vendaFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/venda")
    public void addCliente(@RequestBody Venda venda){
        vendaFacade.create(venda);
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
