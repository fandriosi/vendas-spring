package com.andriosi.fabio.vendas.services;
import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.entity.Venda;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
public class VendaFacade extends AbstractFacade<Venda> {
    private EntityManager entityManager;

    public VendaFacade() {
        super(Venda.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_VENDAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public Venda merge(Venda entity) {
        try {
            EntityManager manager = getEntityManager();
            manager.getTransaction().begin();
            Venda venda = manager.merge(entity);
            manager.getTransaction().commit();
            return venda;
        } catch (RollbackException exception) {
            throw new EntityExistsException(exception);
        }
    }
}