package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
