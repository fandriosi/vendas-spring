package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ClienteController {

    @Autowired
    private ClienteFacade clienteFacade;
    @GetMapping("/clientes")
    public @ResponseBody ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteFacade.findAll(), HttpStatus.OK );
    }
    @PostMapping("/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>> addCliente(@RequestBody Cliente cliente){
        clienteFacade.create(cliente);
        return new ResponseEntity<>(clienteFacade.findAll(), HttpStatus.OK );
    }

    @DeleteMapping("/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>> deleteClintes(@RequestBody Cliente cliente){
        clienteFacade.remove(cliente);
        return new ResponseEntity<>(clienteFacade.findAll(), HttpStatus.OK );
    }

    @PutMapping("/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>> updateCliente(@RequestBody Cliente cliente){
        clienteFacade.edit(cliente);
        return new ResponseEntity<>(clienteFacade.findAll(), HttpStatus.OK );
    }
}
