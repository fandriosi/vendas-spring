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
@RequestMapping("resources")
public class ProdutoController {
    @Autowired
    private ProdutoFacade produtoFacade;
    @Autowired
    private CategoriaFacade categoriaFacade;
    @GetMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>> findAll(){
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK );
    }
    @GetMapping("/produtosestoque")
    public @ResponseBody ResponseEntity<List<Produto>> produtosByEstoque(){
        return new ResponseEntity<>(produtoFacade.produtoByEstoque(), HttpStatus.OK);
    }
    @PostMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>> addCliente(@RequestBody Produto produto){
        produtoFacade.create(produto);
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>> deleteClintes(@RequestBody Produto produto){
        produtoFacade.remove(produto);
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }

    @PutMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>>  updateCliente(@RequestBody Produto produto){
        produtoFacade.edit(produto);
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }
}
