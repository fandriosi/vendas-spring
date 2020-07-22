package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("resources")
public class ProdutoController {
    @Autowired
    private ProdutoFacade produtoFacade;
    @Autowired
    private CategoriaFacade categoriaFacade;
    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> findAll(){
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK );
    }
    @GetMapping("/produto/{id}")
    public Produto getById(@PathVariable Long id){
        return produtoFacade.find(id);
    }
    @PostMapping("/produto")
    public void addCliente(@RequestBody Produto produto){
        produtoFacade.create(produto);
    }

    @DeleteMapping("/produto")
    public void deleteClintes(@RequestBody Produto produto){
        produtoFacade.remove(produto);
    }

    @PutMapping("/produto")
    public void updateCliente(@RequestBody Produto produto){
        produtoFacade.edit(produto);
    }
}
