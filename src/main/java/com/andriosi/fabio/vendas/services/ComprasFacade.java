package com.andriosi.fabio.vendas.services;
import com.andriosi.fabio.vendas.entity.Compra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComprasFacade extends AbstractFacade<Compra> {
    private EntityManager entityManager;
    public ComprasFacade() {
        super(Compra.class);
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
