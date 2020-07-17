package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoFacade produtoFacade;
    @Autowired
    private CategoriaFacade categoriaFacade;
    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> findAll(){
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/produtos")
    public void addCliente(@RequestBody Produto produto){
        produto.setCategoria(categoriaFacade.find(produto.getCategoria().getId()));
        produtoFacade.create(produto);
    }

    @DeleteMapping("/produtos")
    public void deleteClintes(@RequestBody Produto produto){
        produtoFacade.remove(produto);
    }

    @PutMapping("/produtos")
    public void updateCliente(@RequestBody Produto produto){
        produtoFacade.edit(produto);
    }
}
