package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.entity.Estoque;
import com.andriosi.fabio.vendas.entity.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueFacade extends AbstractFacade<Estoque> {
    private EntityManager entityManager;
    public EstoqueFacade() {
        super(Estoque.class);
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
