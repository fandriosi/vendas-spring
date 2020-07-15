package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Cliente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Service
public class ClienteFacade extends AbstractFacade<Cliente> {
    private EntityManager entityManager;
    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_COMPRAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
    public void remove(Cliente entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Cliente> cq = em.createNamedQuery("Cliente.remove", Cliente.class)
                .setParameter("id", entity.getId());
        cq.executeUpdate();
        em.getTransaction().commit();
    }
}
