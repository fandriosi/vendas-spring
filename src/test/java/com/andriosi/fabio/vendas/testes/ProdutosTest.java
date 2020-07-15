package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.entity.Produtos;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import com.andriosi.fabio.vendas.services.ProdutosFacade;
import org.junit.Test;

import javax.persistence.EntityExistsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProdutosTest {
   //@Test
    public void ProdutosTesteA() throws EntityExistsException {
        Produtos produtos = new Produtos();
        produtos.setDescricao("blusa azul marinho marsuel");
        produtos.setCodigoBarra(128588);
        produtos.setPrecoCusto(23.90);
        produtos.setPreco(produtos.getPrecoCusto()* 2);
        Categoria categoria = new CategoriaFacade().find(1L);
        produtos.setCategoria(categoria);
        new ProdutosFacade().create(produtos);
    }
     //@Test
    public void clienteTesteB() {
        Produtos produtos = new Produtos();
        produtos = new ProdutosFacade().findAll().get(0);
        assertEquals("Blusa Molet de bufante", produtos.getDescricao());
    }
    //@Test
    public void clienteTesteC(){
        Produtos produtos = new ProdutosFacade().findAll().get(0);
        Categoria categoria = new CategoriaFacade().findAll().get(0);
        produtos.setCategoria(categoria);
        new ProdutosFacade().edit(produtos);
        assertEquals("Blusa", produtos.getCategoria().getDescricao());
    }
   // @Test
    public void clienteTesteD(){
        Produtos produtos = new ProdutosFacade().findAll().get(0);
        long id = produtos.getId();
        new ProdutosFacade().remove(produtos);
        Produtos prod = new ProdutosFacade().find(id);
        assertNull("The car should be null", prod);
    }
}
