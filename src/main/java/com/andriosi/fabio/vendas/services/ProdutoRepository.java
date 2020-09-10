package com.andriosi.fabio.vendas.services;
import com.andriosi.fabio.vendas.entity.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    @Query("select p from Produto p where p.descricao like %?1%")
    List<Produto> findByDescricao(String descricao);

}
