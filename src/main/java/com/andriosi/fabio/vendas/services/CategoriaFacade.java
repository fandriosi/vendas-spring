package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Categoria;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class CategoriaFacade extends AbstractFacade<Categoria> {
    private EntityManager entityManager;
    public CategoriaFacade() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_COMPRAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public void remove(Categoria entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Categoria c WHERE c.id=:id")
                .setParameter("id", entity.getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
