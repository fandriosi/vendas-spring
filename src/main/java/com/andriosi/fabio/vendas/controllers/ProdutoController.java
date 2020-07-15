package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.entity.Produtos;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ProdutosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutosFacade produtosFacade;
    @GetMapping("/produtos")
    public ResponseEntity<List<Produtos>> findAll(){
        return new ResponseEntity<>(produtosFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/produtos")
    public void addCliente(@RequestBody Produtos produtos){
        produtosFacade.create(produtos);
    }

    @DeleteMapping("/produtos")
    public void deleteClintes(@RequestBody Produtos produtos){
        produtosFacade.remove(produtos);
    }

    @PutMapping("/produtos")
    public void updateCliente(@RequestBody Produtos produtos){
        produtosFacade.edit(produtos);
    }
}
