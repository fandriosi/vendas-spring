package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.entity.Estoque;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    public void remove(Estoque entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Estoque e WHERE e.id=:id")
                .setParameter("id", entity.getId()).executeUpdate();
        em.getTransaction().commit();
    }
    public void edit(Estoque entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Estoque e SET e.quantidade=:quantidade, e.produto.id=:produtoId  WHERE e.id=:id")
                .setParameter("id", entity.getId()).
                setParameter("quantidade", entity.getQuantidade())
                .setParameter("produtoId", entity.getProduto().getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
