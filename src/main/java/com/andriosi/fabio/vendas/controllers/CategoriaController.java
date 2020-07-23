package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class CategoriaController {
    @Autowired
    private com.andriosi.fabio.vendas.services.CategoriaFacade CategoriaFacade;
    @GetMapping("/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>> findAll(){
        return new ResponseEntity<>(CategoriaFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping(value = "/categoria")
    public void addCliente(@RequestBody Categoria categoria){
        CategoriaFacade.create(categoria);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/Categoria")
    public void deleteClintes(@RequestBody Categoria categoria){
        CategoriaFacade.remove(categoria);
    }

    @PutMapping(value = "/categoria")
    public void updateCliente(@RequestBody Categoria categoria){
        CategoriaFacade.edit(categoria);
    }
}
