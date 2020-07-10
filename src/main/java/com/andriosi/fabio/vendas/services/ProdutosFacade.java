package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Produtos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutosFacade extends AbstractFacade<Produtos> {
    private EntityManager entityManager;
    public ProdutosFacade() {
        super(Produtos.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_COMPRAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
