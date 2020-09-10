package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Long> {
}
