package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.EstoqueFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("resources")
public class ProdutoController {
    @Autowired
    private ProdutoFacade produtoFacade;
    @Autowired
    private EstoqueFacade estoqueFacade;
    @GetMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>> findAll(){
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/produtosFindByDescricao")
    public @ResponseBody ResponseEntity<List<Produto>> produtosByEstoque(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoFacade.produtoFidByDescricao(produto.getDescricao()), HttpStatus.OK);
    }
    @GetMapping("/produto/{id}")
    public @ResponseBody ResponseEntity<Produto> produtosById(@PathVariable("id") Long id){
        return new ResponseEntity<>(produtoFacade.find(id), HttpStatus.OK);
    }
    @PostMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>> addCliente(@RequestBody Produto produto){
        try{
            produtoFacade.create(produto);
            return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
        }catch (EntityExistsException ex){
            System.out.println(ex.fillInStackTrace());
        }
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>> deleteClintes(@RequestBody Produto produto){
        produtoFacade.remove(produto);
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }

    @PutMapping("/produto")
    public @ResponseBody ResponseEntity<List<Produto>>  updateCliente(@RequestBody Produto produto){
        try{
            produtoFacade.create(produto);
            return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
        }catch (EntityExistsException ex){
            System.out.println(ex.fillInStackTrace());
        }
        return new ResponseEntity<>(produtoFacade.findAll(), HttpStatus.OK);
    }
}
