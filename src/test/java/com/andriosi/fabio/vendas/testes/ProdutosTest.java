package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.entity.Produto;
import com.andriosi.fabio.vendas.services.CategoriaFacade;
import com.andriosi.fabio.vendas.services.ProdutoFacade;
import org.junit.Test;

import javax.persistence.EntityExistsException;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProdutosTest {
    //@Test
    public void ProdutosTesteA() throws EntityExistsException {
        Produto produto = new Produto();
        produto.setDescricao("Produto para estoque");
        produto.setCodigoBarra(148);
        produto.setPrecoCusto(BigDecimal.valueOf(78.90));
        produto.setPreco(produto.getPrecoCusto());
        Categoria categoria = new CategoriaFacade().find(2L);
        produto.setQuantidade(3);
        produto.setCategoria(categoria);
        new ProdutoFacade().edit(produto);
    }
     //@Test
    public void clienteTesteB() {
        Produto produto = new Produto();
        produto = new ProdutoFacade().findAll().get(0);
        assertEquals("Blusa Molet de bufante", produto.getDescricao());
    }
    //@Test
    public void clienteTesteC(){
        Produto produto = new ProdutoFacade().findAll().get(0);
        Categoria categoria = new CategoriaFacade().findAll().get(0);
        produto.setCategoria(categoria);
        new ProdutoFacade().edit(produto);
        assertEquals("Blusa", produto.getCategoria().getDescricao());
    }
   // @Test
    public void clienteTesteD(){
        Produto produto = new ProdutoFacade().findAll().get(0);
        long id = produto.getId();
        new ProdutoFacade().remove(produto);
        Produto prod = new ProdutoFacade().find(id);
        assertNull("The car should be null", prod);
    }
   // @Test
    public void findAllProdutos() {
        List<Produto> produtoList = new ProdutoFacade().produtoFidByDescricao("Blusa Azul");
        for (Produto item : produtoList){
            System.out.println(item.getDescricao());
        }
    }

}
