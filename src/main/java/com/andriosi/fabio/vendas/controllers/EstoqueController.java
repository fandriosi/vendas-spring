package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Estoque;
import com.andriosi.fabio.vendas.services.EstoqueFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstoqueController {
    @Autowired
    private EstoqueFacade estoqueFacade;
    @GetMapping("/estoque")
    public ResponseEntity<List<Estoque>> findAll(){
        return new ResponseEntity<>(estoqueFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/estoque")
    public void addCliente(@RequestBody Estoque estoque){
        estoqueFacade.create(estoque);
    }

    @DeleteMapping("/estoque")
    public void deleteClintes(@RequestBody Estoque estoque){
        estoqueFacade.remove(estoque);
    }

    @PutMapping("/estoque")
    public void updateCliente(@RequestBody Estoque estoque){
        estoqueFacade.edit(estoque);
    }
}
