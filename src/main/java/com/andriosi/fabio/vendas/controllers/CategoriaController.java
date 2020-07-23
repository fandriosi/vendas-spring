package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Categoria;

import com.andriosi.fabio.vendas.entity.CategoriaJson;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class CategoriaController {
    @Autowired
    private CategoriaFacade categoriaFacade;
    @GetMapping("/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>> findAll(){
        return new ResponseEntity<>(categoriaFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCliente(@RequestBody Categoria categoria){
        categoriaFacade.create(categoria);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/categoria" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClintes(@RequestBody @Valid Categoria categoria){
        categoriaFacade.remove(categoria);
    }

    @PutMapping(value = "/categoria" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCliente(@RequestBody @Valid Categoria categoria){
        categoriaFacade.edit(categoria);
    }
}
