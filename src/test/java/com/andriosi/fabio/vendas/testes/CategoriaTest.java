package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import org.junit.Test;

import javax.persistence.EntityExistsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoriaTest {
    @Test
    public void CategoriaTesteA() throws EntityExistsException {
        Categoria Categoria = new Categoria();
        Categoria.setDescricao("BluSA");
        new CategoriaFacade().create(Categoria);
    }
    //@Test
    public void clienteTesteB() {
        Categoria Categoria = new Categoria();
        Categoria = new CategoriaFacade().findAll().get(0);
        assertEquals("Blusa", Categoria.getDescricao());
    }
    //@Test
    public void clienteTesteC(){
        CategoriaFacade facade = new CategoriaFacade();
        Categoria Categoria = facade.find(4L);
        Categoria.setDescricao("Casaco");
        facade.edit(Categoria);
        Categoria cg = facade.find(4L);
        assertEquals("Casaco", cg.getDescricao());
    }
    //@Test
    public void clienteTesteD(){
        Categoria Categoria = new CategoriaFacade().find(9L);
        long id = Categoria.getId();
        new CategoriaFacade().remove(Categoria);
        Categoria prod = new CategoriaFacade().find(id);
        assertNull("The car should be null", prod);
    }
}
