package com.andriosi.fabio.vendas.services;
import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.entity.Compra;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
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
    public void remove(Compra entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Compra c WHERE c.id=:id")
                .setParameter("id", entity.getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
