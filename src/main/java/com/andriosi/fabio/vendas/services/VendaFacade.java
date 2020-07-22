package com.andriosi.fabio.vendas.services;
import com.andriosi.fabio.vendas.entity.Venda;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class VendaFacade extends AbstractFacade<Venda> {
    private EntityManager entityManager;
    public VendaFacade() {
        super(Venda.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_VENDAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
    public void remove(Venda entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Venda v WHERE v.id=:id")
                .setParameter("id", entity.getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
