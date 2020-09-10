package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
