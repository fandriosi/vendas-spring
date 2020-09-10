package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.services.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @GetMapping("/clientes")
    public @ResponseBody ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list,HttpStatus.OK );
    }
    @PostMapping("/clientes")
    public @ResponseBody ResponseEntity<List<Cliente>> addCliente(@RequestBody Cliente cliente){
        repository.save(cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @DeleteMapping("/clientes")
    public @ResponseBody ResponseEntity<List<Cliente>> deleteClintes(@RequestBody Cliente cliente){
        repository.delete(cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @PutMapping("/clientes")
    public @ResponseBody ResponseEntity<List<Cliente>> updateCliente(@RequestBody Cliente cliente){
        repository.save(cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
}
