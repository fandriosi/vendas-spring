package com.andriosi.fabio.vendas.controllers;

import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.entity.ProdutosReports;
import com.andriosi.fabio.vendas.services.CategoriaRepository;
import com.andriosi.fabio.vendas.services.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("resources")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @GetMapping("/produtosFindByDescricao/{descricao}")
    public @ResponseBody ResponseEntity<List<Produto>> produtosByDescricao(@PathVariable("descricao") String descricao){
        return new ResponseEntity<>(repository.findByDescricao(descricao), HttpStatus.OK);
    }
    @GetMapping("/produtos/reports")
    public @ResponseBody ResponseEntity<ProdutosReports> getTotalPrecoCusot(){
        ProdutosReports produtosReports = new ProdutosReports();
        produtosReports.setTotalPrecoCusto(repository.getTotalPrecoCusto());
        produtosReports.setTotalPreco(repository.getTotalPreco());
        return new ResponseEntity<>(produtosReports, HttpStatus.OK);
    }

    @GetMapping("/produtos/{id}")
    public @ResponseBody ResponseEntity<Produto> produtosById(@PathVariable("id") Long id){
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>> addProduto(@RequestBody Produto produto){
        repository.save(produto);
        List<Produto> list = new ArrayList<>();
        repository.findAll().forEach(item ->{
            item.setCategoria(categoriaRepository.findById(item.getCategoria().getId()).get());
            list.add(item);
        });
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @DeleteMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>> deleteProduto(@RequestBody Produto produto){
        repository.delete(produto);
        List<Produto> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @PutMapping("/produtos")
    public @ResponseBody ResponseEntity<List<Produto>>  updateProduto(@RequestBody Produto produto){
        repository.save(produto);
        List<Produto> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
}
