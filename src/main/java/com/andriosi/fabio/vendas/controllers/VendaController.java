package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.*;
import com.andriosi.fabio.vendas.services.ClienteRepository;
import com.andriosi.fabio.vendas.services.ProdutoRepository;
import com.andriosi.fabio.vendas.services.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("resources")
public class  VendaController {
    @Autowired
    private VendaRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping("/vendas")
    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @PostMapping("/vendas")
    public @ResponseBody ResponseEntity<List<ProdutosVendidos>> creteVenda(@RequestBody Venda venda) {
        venda.setClientes(clienteRepository.findById(venda.getClientes().getId()).get());
        venda.getProdutosVendidos().forEach(item ->{
            Produto produto = produtoRepository.findById(item.getProduto().getId()).get();
            produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
            produtoRepository.save(produto);
        });
        Venda v = repository.save(venda);
        List<ProdutosVendidos> list = repository.findById(v.getId()).get().getProdutosVendidos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/vendas")
    public @ResponseBody ResponseEntity<List<Venda>> updateVenda(@RequestBody Venda venda) {
        Venda v = repository.findById(venda.getId()).get();
        v.setValorPago(venda.getValorPago());
        repository.save(v);
        List<Venda> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/vendas")
    public @ResponseBody ResponseEntity<List<Venda>> deleteVenda(@RequestBody Venda venda) {
        venda = repository.findById(venda.getId()).get();
        venda.getProdutosVendidos().forEach(item ->{
            Produto produto = produtoRepository.findById(item.getProduto().getId()).get();
            produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
            produtoRepository.save(produto);
        });
        repository.delete(venda);
        List<Venda> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("vendas/tipoPagamento")
    public @ResponseBody ResponseEntity<List<TipoPagamento>> getTipoPagamento(){
        return  new ResponseEntity<>(Arrays.asList(TipoPagamento.values()), HttpStatus.OK);
    }
}
