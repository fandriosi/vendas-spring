package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Estoque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstoqueFacade extends AbstractFacade<Estoque> {
    private EntityManager entityManager;
    public EstoqueFacade() {
        super(Estoque.class);
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
