package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Estoque;
import com.andriosi.fabio.vendas.services.EstoqueFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resources")
public class EstoqueController {
    @Autowired
    private EstoqueFacade estoqueFacade;
    @GetMapping("/estoques")
    public @ResponseBody ResponseEntity<List<Estoque>> findAll(){
        return new ResponseEntity<>(estoqueFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/estoque")
    public @ResponseBody ResponseEntity<List<Estoque>> addCliente(@RequestBody Estoque estoque){
        estoqueFacade.create(estoque);
        return new ResponseEntity<>(estoqueFacade.findAll(), HttpStatus.OK );
    }

    @DeleteMapping("/estoque")
    public @ResponseBody ResponseEntity<List<Estoque>> deleteClintes(@RequestBody Estoque estoque){
        estoqueFacade.remove(estoque);
        return new ResponseEntity<>(estoqueFacade.findAll(), HttpStatus.OK );
    }

    @PutMapping("/estoque")
    public @ResponseBody ResponseEntity<List<Estoque>> updateCliente(@RequestBody Estoque estoque){
        estoqueFacade.edit(estoque);
        return new ResponseEntity<>(estoqueFacade.findAll(), HttpStatus.OK );
    }
}
