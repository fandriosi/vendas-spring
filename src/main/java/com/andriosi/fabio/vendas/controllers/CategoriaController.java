package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.services.CategoriaRepository;
import com.andriosi.fabio.vendas.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository ;
    @GetMapping("/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @PostMapping(value = "/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>>  addCliente(@RequestBody Categoria categoria){
        repository.save(categoria);
        List<Categoria> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @DeleteMapping(value = "/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>>  deleteClintes(@RequestBody Categoria categoria){
        repository.delete(categoria);
        List<Categoria> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @PutMapping(value = "/categorias")
    public @ResponseBody ResponseEntity<List<Categoria>>  updateCliente(@RequestBody Categoria categoria){
        repository.save(categoria);
        List<Categoria> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );

    }
}
