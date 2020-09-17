package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Venda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendaRepository extends CrudRepository<Venda, Long> {
    @Query("select v from Venda v where v.clientes.nome like %?1%")
    public List<Venda> findClientesByNome(String nome);
}
