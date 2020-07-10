package com.andriosi.fabio.vendas.services;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import java.util.List;

public abstract class AbstractFacade<T> {
    private final Class<T> entityClass;

    /**
     * Contrutor que recebe a classe genérica da entidade.
     * @param entityClass classe
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    /**
     * Método que implementa a inserção de uma tabela no Banco de Dados mapeada por uma entidade
     * @param entity tabela no Banco de Dados mepeada por uma entidade.
     */
    public void create(T entity) throws EntityExistsException {
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (RollbackException exception){
            throw new EntityExistsException(exception);
        }

    }
    /**
     * Método que implementa o atualização de uma tabela do Banco de Dados mapeada por uma entidade.
     * @param entity tabela do Banco de Dados mapeada por uma entidade.
     */
    public void edit(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
    /**
     * Método que implementa a exclusão de uma tabela do Banco de Dados mapeada por uma entidade.
     * @param entity tabela do Banco de Dados mapeada por uma entidade.
     */
    public void remove(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.flush();
        em.getTransaction().commit();
    }
    /**
     * Método que implementa a busca de uma tabela do Banco de Dados mapeada por uma entidade.
     * @param id parâmetro de busca do Banco de Dados.
     * @return retorna a tabela do Banco de Dados mapeada por uma entidade.
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /**
     * Método que implementa a busca de todos os dados de uma tabela do Banco de Dados mapeada por uma entidade.
     * @return returna uma lista com todos os dadas de uma tabela do Bando de Dados mapeada por uma entidade.
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    /**
     * Método que implementa a busca dos dados de uma tabela do Banco de Dados em um intervalo.
     * @param range intervalo da busca.
     * @return lista do tabela do Banco de Dados mapeada por uma entidade.
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    /**
     * Método que implementa o busca pelo numero de registro de uma tabela do Banco de Dados mapeado por uma entidade.
     * @return retorna o número de registro de um tabela do Bando de Dados mapeada por uma entidade.
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * Método que implementa a busca em uma tabela do Banco de Dados mapeada por uma entidade recebendo como parâmtro
     * uam query, um parâmetro para busca e o valor do parâmentro de busca.
     * @param query query da consulta do Banco de Dados.
     * @param param parâmetro que representa o campo cláusula where da consulta
     * @param status o valor do parâmentro da consulta
     * @return a tabela do Banco de Dados mapeada por uma entidade.
     */
    public List<T> findByStatus(String query, String param, Character status) {
        javax.persistence.Query q = getEntityManager().createNamedQuery(query, entityClass);
        q.setParameter(param, status);
        return q.getResultList();
    }
}
