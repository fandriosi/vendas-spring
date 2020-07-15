package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Compra;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ComprasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompraController {
    @Autowired
    private ComprasFacade compraFacade;
    @GetMapping("/compra")
    public ResponseEntity<List<Compra>> findAll(){
        return new ResponseEntity<>(compraFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/compra")
    public void addCliente(@RequestBody Compra compra){
        compraFacade.create(compra);
    }

    @DeleteMapping("/compra")
    public void deleteClintes(@RequestBody Compra compra){
        compraFacade.remove(compra);
    }

    @PutMapping("/compra")
    public void updateCliente(@RequestBody Compra compra){
        compraFacade.edit(compra);
    }
}
