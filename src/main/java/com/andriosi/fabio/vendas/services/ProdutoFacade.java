package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Estoque;
import com.andriosi.fabio.vendas.entity.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoFacade extends AbstractFacade<Produto> {

    private EntityManager entityManager;
    public ProdutoFacade() {
        super(Produto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_VENDAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
    public List<Produto> produtoFidByDescricao(String descricicao){
        Query query = getEntityManager().
                createQuery("SELECT p FROM Produto p WHERE p.descricao LIKE :descricao")
                .setParameter("descricao", "%".concat(descricicao).concat("%"));
        return query.getResultList();
    }
    public void create(Produto entity) throws EntityExistsException{
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Produto produto = em.merge(entity);
            em.getTransaction().commit();
            em.getTransaction().begin();
            Estoque estoque = new Estoque();
            estoque.setQuantidade(entity.getQuantidade());
            estoque.setProduto(produto);
            em.merge(estoque);
            em.getTransaction().commit();
        }catch (RollbackException exception){
            throw new EntityExistsException(exception);
        }
    }
}
