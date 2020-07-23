package com.andriosi.fabio.vendas.services;

import com.andriosi.fabio.vendas.entity.Cliente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class ClienteFacade extends AbstractFacade<Cliente> {
    private EntityManager entityManager;
    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM_VENDAS");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public List<Cliente> findByCombobox(){
       return(List<Cliente>) getEntityManager().createNamedQuery("Cliente.findByCombobox").getResultList();
    }
}