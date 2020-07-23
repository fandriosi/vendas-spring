package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoFacade extends AbstractFacade<Produto> {
    private EntityManager entityManager;
    public ProdutoFacade() {
        super(Produto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_VENDAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
    public List<Produto> produtoByEstoque(){
        Query query = getEntityManager().
                createQuery("SELECT p FROM Produto p WHERE NOT EXISTS (SELECT p.id FROM Estoque e WHERE  e.produto.id = p.id )");
        return query.getResultList();
    }
}
