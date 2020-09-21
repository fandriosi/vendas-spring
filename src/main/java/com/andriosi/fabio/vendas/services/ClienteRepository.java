package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    @Query("select c from Cliente c where c.nome like %?1%")
    List<Cliente> findByNome(String nome);
}
